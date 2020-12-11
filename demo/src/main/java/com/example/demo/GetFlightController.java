package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class GetFlightController {

    @GetMapping("/flight")
    public Flight getFlight(){
        Flight flight1 = new Flight();
        Flight.Ticket ticket1 = new Flight.Ticket();
        Flight.Ticket.Passenger passenger1 = new Flight.Ticket.Passenger();
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");
        ticket1.setPassenger(passenger1);
        ticket1.setPrice("200");
        flight1.setDeparts("2017-04-21 14:34");
        flight1.setTicket(ticket1);
        return flight1;
    }

    @GetMapping("")
    public List<Flight> getFlights() {
        Flight flight1 = new Flight();
        Flight.Ticket ticket1 = new Flight.Ticket();
        Flight.Ticket.Passenger passenger1 = new Flight.Ticket.Passenger();
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");
        ticket1.setPassenger(passenger1);
        ticket1.setPrice("200");
        flight1.setDeparts("2017-04-21 14:34");
        flight1.setTicket(ticket1);

        Flight flight2 = new Flight();
        Flight.Ticket ticket2 = new Flight.Ticket();
        Flight.Ticket.Passenger passenger2 = new Flight.Ticket.Passenger();
        passenger2.setFirstName("Some name2");
        passenger2.setLastName("Some other name2");
        ticket2.setPassenger(passenger2);
        ticket2.setPrice("300");
        flight2.setDeparts("2017-08-25 01:00");
        flight2.setTicket(ticket2);

        return Arrays.asList(flight1, flight2);
    }

//    @PostMapping("/tickets/total")
//    public String getTotal(@RequestBody Flight flights){
//        return flights.getTicket().get()
//    }

}
