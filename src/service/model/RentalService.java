package service.model;

import java.time.Duration;

import entiti.model.CarRental;
import entiti.model.Invoice;

public class RentalService {
	private double pricePerHour;
	private double pricePerDay;
	
	private TaxServices bts;

	public RentalService() {
	}

	public RentalService(double pricePerHour, double pricePerDay, TaxServices bts) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.bts = bts;
	}
	
	public void processinvoice(CarRental carRental) {
		
		double min = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = min / 60;
		double basicpayment;
		if(hours <= 12) {
			basicpayment = pricePerHour * Math.ceil(hours);
		}
		else {
			basicpayment = pricePerDay * Math.ceil(hours/24);
		}
		double tax = bts.tax(basicpayment);
		carRental.setInvoice(new Invoice(basicpayment,tax));
	}
}
