package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class GetFlightController {

    @GetMapping("/flight")
    public Flight getFlight(){
        Flight flight1 = new Flight();
        Flight.Ticket ticket1 = new Flight.Ticket();
        Flight.Ticket.Passenger passenger1 = new Flight.Ticket.Passenger();
        flight1.setDeparts("2017-04-21 14:34");
        ticket1.setPrice("200");
        passenger1.setFirstName("Some name");
        passenger1.setLastName("Some other name");
        return flight1;
    }
}
