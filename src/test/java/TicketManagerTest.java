import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {


    @Test
    public void shouldMatchWhenSomeTicketsFound() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 6899, "SVO", "KZN");
        Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN");
        Ticket ticket3 = new Ticket(3, 1399, "DME", "CSY");
        Ticket ticket4 = new Ticket(4, 5999, "SVO", "KZN");
        Ticket ticket5 = new Ticket(5, 1999, "SVO", "KZN");
        Ticket ticket6 = new Ticket(6, 3999, "SVO", "KZN");
        Ticket ticket7 = new Ticket(7, 4999, "SVO", "KZN");


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.removeById(6);


        Ticket[] actual = manager.findAll("SVO", "KZN");
        Ticket[] expected = {ticket5, ticket7, ticket4, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchWhenNoTicketsFound() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 6899, "SVO", "KZN");
        Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN");
        Ticket ticket3 = new Ticket(3, 1399, "DME", "CSY");
        Ticket ticket4 = new Ticket(4, 5999, "SVO", "KZN");

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.findAll("DME", "KZN");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldMatchWhenTicketsWithEqualPriceFound() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 5999, "SVO", "KZN");
        Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN");
        Ticket ticket3 = new Ticket(3, 1399, "DME", "CSY");
        Ticket ticket4 = new Ticket(4, 5999, "SVO", "KZN");

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] actual = manager.findAll("SVO", "KZN");
        Ticket[] expected = {ticket1, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }
}
