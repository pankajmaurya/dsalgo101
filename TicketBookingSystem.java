/*
We will leverage the concept of a train ticket booking system which allows cancellation and provides
reservation against cancellation.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface BookingSystem {
    public Ticket book(String passenger);
    public void cancel(Ticket ticket);
}

class BookingQueue implements Queue<Ticket> {
    Ticket[] bookings;
    int size = 0;
    int capacity;
    BookingQueue(int capacity) {
        bookings = new Ticket[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean enqueue(Ticket item) {
        if (size == capacity) {
            return false;
        }

        bookings[size] = item;
        size++;

        return true;
    }

    @Override
    public Ticket dequeue() {
        if (size == 0) return null;

        Ticket item = bookings[0];

        for (int index = 1; index < capacity; index++) {
            bookings[index - 1] = bookings[index];
        }
        size--;
        return item;
    }
}

// Assume we only have 1 train and 1 travel date and 1 coach in the train
// The coach will only have a fixed number of seats : 1 2 3 4 5 6 7 8 where 7 is used for RAC (side lower)
class SimpleBookingSystem implements BookingSystem {
    Coach coach;
    final Seat racSeat = new Seat(7, SeatType.SIDE_LOWER);
    Map<Seat, Ticket> bookings = new HashMap<>();

    // RAC bookings queue : 2 RAC for seat 7
    BookingQueue racBookingsQueue = new BookingQueue(2);
    // Waiting list bookings queue
    BookingQueue waitingBookingsQueue = new BookingQueue(20);
    public SimpleBookingSystem() {
        coach = new Coach();
        coach.seats = new ArrayList<>();
        // https://www.confirmtkt.com/seatmap.php?class=SL
        coach.seats.add(new Seat(1, SeatType.LOWER));
        coach.seats.add(new Seat(2, SeatType.MIDDLE));
        coach.seats.add(new Seat(3, SeatType.UPPER));
        coach.seats.add(new Seat(4, SeatType.LOWER));
        coach.seats.add(new Seat(5, SeatType.MIDDLE));
        coach.seats.add(new Seat(6, SeatType.UPPER));
        coach.seats.add(racSeat);
        coach.seats.add(new Seat(8, SeatType.SIDE_UPPER));
    }


    @Override
    public synchronized Ticket book(String passenger) {
        // Try to book a confirmed ticket first

        for (Seat seat : coach.seats) {
            if (seat.seatType != SeatType.SIDE_LOWER && !bookings.containsKey(seat)) {
                Ticket ticket = new Ticket();
                ticket.passenger = passenger;
                ticket.seat = seat;
                ticket.status = Status.CONFIRMED;
                bookings.put(seat, ticket);
                return ticket;
            }
        }

        // We could not book confirmed ticket, try RAC - we will allow 2 RAC tickets for the Side Lower
        Ticket ticket = new Ticket();
        ticket.passenger = passenger;
        ticket.seat = racSeat;
        ticket.status = Status.RAC;
        if (racBookingsQueue.enqueue(ticket)) {
            return ticket;
        }

        // We could not book RAC, lets return a waiting ticket
        ticket.status = Status.WAITING;
        if (waitingBookingsQueue.enqueue(ticket)) {
            return ticket;
        }

        // as a default, no ticket was booked and we return null
        return null;
    }

    @Override
    public void cancel(Ticket ticket) {
        // TODO: implement cancellation
    }
}

class Ticket {
    Seat seat;
    Status status;
    String passenger;

    @Override
    public String toString() {
        return "Ticket{" +
                "seat=" + seat +
                ", status=" + status +
                ", passenger='" + passenger + '\'' +
                '}';
    }
}

enum Status {
    CONFIRMED,
    RAC,
    WAITING;
}

class Coach {
    List<Seat> seats;
}
enum SeatType {
    LOWER,
    MIDDLE,
    UPPER,
    SIDE_UPPER,
    SIDE_LOWER;
}
class Seat {
    int number;
    SeatType seatType;

    public Seat(int number, SeatType seatType) {
        this.number = number;
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", seatType=" + seatType +
                '}';
    }
}