package designpatterns.structrual.bridge;

public class BrigeRunner {
    public static void main (String... args){
        TicketManager ticketManager = new ETicketManager();
        ShowManager showManager = new ShowManager(ticketManager);
        showManager.ticketManager.postTicket();

        ticketManager = new PapperTicketManager();
        ShowManager showManager1 = new ShowManager(ticketManager);
        showManager1.ticketManager.postTicket();

    }
}

class ShowManager {
    TicketManager ticketManager;

    public ShowManager(TicketManager ticketManager){
        this.ticketManager = ticketManager;
    }
}


interface TicketManager{
    public void postTicket();
}

class ETicketManager implements TicketManager{
    @Override
    public void postTicket(){
        System.out.println("The ticket has been Emailed to the user");
    }
}

class PapperTicketManager implements TicketManager{
    @Override
    public void postTicket(){
        System.out.println("The ticket is sent in a letter");
    }
}
