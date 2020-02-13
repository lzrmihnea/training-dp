package eu.training.dp.s03_ticket_access.service;

import eu.training.dp.s03_ticket_access.composite.User;
import eu.training.dp.s03_ticket_access.repository.TicketAccessRepository;

public class TicketAccessService {

    private TicketAccessRepository ticketAccessRepository;

    public TicketAccessService(TicketAccessRepository ticketAccessRepository) {
        this.ticketAccessRepository = ticketAccessRepository;
    }

    public boolean canAccessTicket(User user, Long ticketId) {

        /*
         * TODO add decision tree here for accessing the ticket
         */

        return false;
    }
}
