package TestServis;

import grud.TicketCrudService;

public class TestTicketCrudService {

    public void testGetAll(TicketCrudService ticletCrudService){
        ticletCrudService.getAllTickets();
    }

    public static void main(String[] args) {
        new TestTicketCrudService().testGetAll(new TicketCrudService());
    }
}
