package eu.training.dp.s03_ticket_access.composite;

public class TicketCheckDecisionNodeExample implements TicketCheckComponent {

    private TicketCheckComponent nodeForFalse;
    private TicketCheckComponent nodeForTrue;

    public TicketCheckDecisionNodeExample(TicketCheckComponent nodeForFalse, TicketCheckComponent nodeForTrue) {
        this.nodeForFalse = nodeForFalse;
        this.nodeForTrue = nodeForTrue;
    }

    @Override
    public boolean checkCondition(User accessingUser, Ticket ticketToAccess) {

        /*
        If FALSE: return nodeForFalse;
        If TRUE: return nodeForTrue;
         */


        return false;
    }
}
