package pl.coderslab.entities;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Flight {
	Airport departure;
	Airport arrival;
	LocalDateTime departureTime;
	ZonedDateTime arrivalTime;
	int duration;
	double price;

	public Airport getDeparture() {
		return departure;
	}

	public Airport getArrival() {
		return arrival;
	}

	public ZonedDateTime getArrivalTime() {
		return arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}

	public void setArrivalTime(ZonedDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	
	}


