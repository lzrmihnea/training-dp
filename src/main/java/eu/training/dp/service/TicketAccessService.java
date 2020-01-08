package eu.training.dp.service;

import eu.training.dp.composite.Ticket;
import eu.training.dp.composite.User;
import eu.training.dp.repository.TicketAccessRepository;

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
