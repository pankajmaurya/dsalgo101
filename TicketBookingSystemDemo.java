public class TicketBookingSystemDemo {

    public static void main(String[] args) {
        BookingSystem simpleBookingSystem = new SimpleBookingSystem();

        System.out.println(simpleBookingSystem.book("Pankaj"));
        System.out.println(simpleBookingSystem.book("Chester"));
        System.out.println(simpleBookingSystem.book("Rishabh"));
        System.out.println(simpleBookingSystem.book("Peter"));
        System.out.println(simpleBookingSystem.book("Ram"));
        System.out.println(simpleBookingSystem.book("John"));
        System.out.println(simpleBookingSystem.book("Devesh"));
        System.out.println(simpleBookingSystem.book("Lily"));
        System.out.println(simpleBookingSystem.book("Mary"));
        System.out.println(simpleBookingSystem.book("David"));
    }
}
