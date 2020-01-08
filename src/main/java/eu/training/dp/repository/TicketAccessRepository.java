package eu.training.dp.repository;

import eu.training.dp.composite.Ticket;

public interface TicketAccessRepository {

    Ticket getTicketById(Long ticketId);
}
