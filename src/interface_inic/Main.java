package interface_inic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entiti.model.CarRental;
import entiti.model.Vehicle;
import service.model.BrazilTaxService;
import service.model.RentalService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String car_model = sc.nextLine();
		
		System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
		
		System.out.print("Return (dd/MM/yyyy hh:ss): ");
		LocalDateTime finich = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental car_rental = new CarRental(start,finich,new Vehicle(car_model));
		
		
		System.out.print("Enter price per hour: ");
		double per_hour = sc.nextDouble();
		
		System.out.print("Enter price per day: ");
		double per_day = sc.nextDouble();
		
		RentalService rs = new RentalService(per_hour,per_day,new BrazilTaxService());
		rs.processinvoice(car_rental);
		
		System.out.println("Fatura:");
		System.out.printf("Pagamento basico: %.2f\n",car_rental.getInvoice().getBasicPaymen());
		System.out.printf("tax:  %.2f\n",car_rental.getInvoice().getTax());
		System.out.printf("Payday total: %.2f\n",car_rental.getInvoice().getTotalPayment());
		sc.close();

	}

}  
