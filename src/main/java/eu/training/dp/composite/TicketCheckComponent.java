package eu.training.dp.composite;

public interface TicketCheckComponent {

    boolean checkCondition(User accessingUser, Ticket ticketToAccess);
}
