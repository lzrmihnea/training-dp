package eu.training.dp.service;

import eu.training.dp.composite.PrivacyLevel;
import eu.training.dp.composite.Ticket;
import eu.training.dp.composite.User;
import eu.training.dp.repository.TicketAccessRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static eu.training.dp.composite.PrivacyLevel.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TicketAccessServiceTest {

    @Mock
    private TicketAccessRepository ticketAccessRepository;

    private TicketAccessService ticketAccessService;

    @Before
    public void setUp() {
        initMocks(this);
        this.ticketAccessService = new TicketAccessService(ticketAccessRepository);
    }

    @Test
    public void testUserIsCreatedBy_expectedAccessGranted() {
        long ticketId = 1L;
        long userId = 101L;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;
        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User ticketCreator = createUser(userId, userHierarchicalLevel, userTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, ticketCreator, null, OPEN_FOR_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertTrue(actualResultCanUserViewTicket);
    }

    @Test
    public void testUserIsAssignedBy_expectedAccessGranted() {
        long ticketId = 1L;
        long userId = 101L;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;
        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User ticketAssigned = createUser(userId, userHierarchicalLevel, userTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, ticketAssigned, OPEN_FOR_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertTrue(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsPublic_expectedAccessGranted() {
        long ticketId = 1L;
        long userId = 101L;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, null, PUBLIC);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertTrue(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsOpenForTeamAndManager_userDiffTeam_userHigherInHierarchy_expectedAccessGranted() {
        long ticketId = 1L;
        long userId = 101L;
        long diffUserId = userId + 1;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;
        long diffTeamId = userTeamId + 1;
        long higherHierarchicalLevelThanUser = userHierarchicalLevel + 1;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User assignedToUser = createUser(diffUserId, higherHierarchicalLevelThanUser, diffTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, assignedToUser, OPEN_FOR_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertTrue(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsOpenForTeamAndManager_userOnSameTeam_expectedAccessGranted() {
        long ticketId = 1L;
        long userId = 101L;
        long diffUserId = userId + 1;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;
        long lowerHierarchicalLevelThanUser = userHierarchicalLevel - 1;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User assignedToUser = createUser(diffUserId, lowerHierarchicalLevelThanUser, userTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, assignedToUser, OPEN_FOR_TEAM_AND_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertTrue(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsOpenForTeamAndManager_userDiffTeam_userEqualInHierarchy_expectedAccessDenied() {
        long ticketId = 1L;
        long userId = 101L;
        long diffUserId = userId + 1;
        long userTeamId = 201L;
        long diffTeamId = userTeamId + 1;
        long userHierarchicalLevel = 5L;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User assignedToUser = createUser(diffUserId, userHierarchicalLevel, diffTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, assignedToUser, OPEN_FOR_TEAM_AND_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertFalse(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsWithNullPrivacy_userDiffFromCreatorOrAssigned_expectedAccessDenied() {
        long ticketId = 1L;
        long userId = 101L;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, null, null);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertFalse(actualResultCanUserViewTicket);
    }

    @Test
    public void testTicketIsOpenForManager_userOnDiffTeam_userSameInHierarchy_expectedAccessDenied() {
        long ticketId = 1L;
        long userId = 101L;
        long diffUserId = userId + 1;
        long userTeamId = 201L;
        long userHierarchicalLevel = 5L;
        long higherHierarchicalLevelThanUser = userHierarchicalLevel + 1;
        long diffTeamId = userTeamId + 1;

        User viewingUser = createUser(userId, userHierarchicalLevel, userTeamId);
        User assignedToUser = createUser(diffUserId, higherHierarchicalLevelThanUser, diffTeamId);
        Ticket mockedTicketFromRepo = createTicket(ticketId, null, assignedToUser, OPEN_FOR_TEAM_AND_MANAGER);

        when(this.ticketAccessRepository.getTicketById(ticketId)).thenReturn(mockedTicketFromRepo);

        boolean actualResultCanUserViewTicket = this.ticketAccessService.canAccessTicket(viewingUser, ticketId);

        assertFalse(actualResultCanUserViewTicket);
    }

    private Ticket createTicket(long ticketId, User ticketCreator, User ticketAssigned, PrivacyLevel ticketPrivacyLevel) {
        return new Ticket(ticketId, ticketCreator, ticketAssigned, ticketPrivacyLevel);
    }

    private User createUser(long userId, long hierarchicalLevel, long teamId) {
        return new User(userId, hierarchicalLevel, teamId);
    }

}
