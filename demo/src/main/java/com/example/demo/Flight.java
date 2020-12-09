package com.example.demo;

import java.util.List;

public class Flight {
    //Constructor
    private String departs;
    private Ticket ticket;
    //Getters & Setters
    public String getDeparts() {
        return departs;
    }
    public void setDeparts(String departs) {
        this.departs = departs;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    //Nested class: Ticket
    static class Ticket {

        //Constructor
        private Passenger passenger;
        private String price;
        //Getters & Setters
        public String getPrice() {
            return price;
        }
        public void setPrice(String price) {
            this.price = price;
        }
        public Passenger getPassenger() {
            return passenger;
        }
        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }
        //Nested class: Passenger
        static class Passenger {
            //Constructor
            private String firstName;
            private String lastName;
            //Getters & Setters
            public String getFirstName() {
                return firstName;
            }
            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }
            public String getLastName() {
                return lastName;
            }
            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

        }
    }
}
