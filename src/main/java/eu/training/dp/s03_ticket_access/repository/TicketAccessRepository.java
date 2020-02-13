package eu.training.dp.s03_ticket_access.repository;

import eu.training.dp.s03_ticket_access.composite.Ticket;

public interface TicketAccessRepository {

    Ticket getTicketById(Long ticketId);
}
