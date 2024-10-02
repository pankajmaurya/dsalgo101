public class TicketBookingSystemDemo {

    public static void main(String[] args) {
        BookingSystem simpleBookingSystem = new SimpleBookingSystem();

        Ticket pankajTicket = simpleBookingSystem.book("Pankaj");
        System.out.println(pankajTicket);
        System.out.println(simpleBookingSystem.book("Chester"));
        System.out.println(simpleBookingSystem.book("Rishabh"));
        System.out.println(simpleBookingSystem.book("Peter"));
        System.out.println(simpleBookingSystem.book("Ram"));
        System.out.println(simpleBookingSystem.book("John"));
        System.out.println(simpleBookingSystem.book("Devesh"));
        Ticket lilyTicket = simpleBookingSystem.book("Lily");
        System.out.println(lilyTicket);
        System.out.println(simpleBookingSystem.book("Mary"));
        Ticket davidTicket = simpleBookingSystem.book("David");
        System.out.println(davidTicket);
        simpleBookingSystem.cancel(pankajTicket);
        System.out.println(davidTicket);
        System.out.println(lilyTicket);

    }
}
