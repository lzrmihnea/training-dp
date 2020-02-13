package eu.training.dp.s03_ticket_access.composite;

public interface TicketCheckComponent {

    boolean checkCondition(User accessingUser, Ticket ticketToAccess);
}
