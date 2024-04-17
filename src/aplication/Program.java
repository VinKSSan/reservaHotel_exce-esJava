package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entitis.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {//exceção será tratada e não propagada
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.println("Check-in date (dd/MM/yyyy) ");
			Date checkin = sdf.parse(sc.next());
			
			System.out.println("Check-out date (dd/MM/yyyy) ");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");		
	
			System.out.print("Check-in date (dd/MM/yyyy) ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy) ");
			checkout = sdf.parse(sc.next());
		
			reservation.updateDates(checkin, checkout); //(Atent) Aqui teriamos um erro se não tratace-mos a exceção propagada em Reservatio.updateDates metodo
			System.out.println("Reservation, " + reservation);		
		}
		catch(ParseException e) {
			System.out.println("invalid date format");
		}
		catch(DomainException e) {//tratemos a exceção propagada em Reservatio.updateDates metodo. neste exemplo criamos uma exceção personalizada, 
			System.out.println("Error in reservation: "+e.getMessage());
		}
		
		
		
		sc.close();
			

	}

}
