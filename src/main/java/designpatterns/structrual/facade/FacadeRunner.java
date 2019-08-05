package designpatterns.structrual.facade;

public class FacadeRunner {
    public static void main(String... args){
        TicketDispenser ticketDispenser = new TicketDispenser();
        ticketDispenser.getETicket();
        ticketDispenser.getPaperTicket();
    }
}




/* facade class */
class TicketDispenser{

    Ticket eTicket;
    Ticket paperTicket;

    public TicketDispenser(){
        eTicket = new ETicket();
        paperTicket = new PaperTicket();
    }

    public void getETicket(){
        eTicket.getTicket();
    }

    public void getPaperTicket(){
        paperTicket.getTicket();
    }
}




/* ticketing system */

interface Ticket{
    public void getTicket();
}

class ETicket implements Ticket{
    @Override
    public void getTicket(){
        System.out.println("This is an E-Ticket");
    }
}

class PaperTicket  implements Ticket{

    @Override
    public void getTicket() {
        System.out.println("This is a paper ticket.");
    }
}
