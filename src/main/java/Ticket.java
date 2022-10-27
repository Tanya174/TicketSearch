public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;

    public Ticket(int id, int price, String from, String to) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    @Override
    public int compareTo(Ticket otherTicket) {
        if (this.getPrice() < otherTicket.getPrice()) {
            return -1;
        } else if (this.getPrice() > otherTicket.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
