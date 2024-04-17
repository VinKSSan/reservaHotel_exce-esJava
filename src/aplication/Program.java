package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entitis.Reservation;

public class Program {
	// este é muito ruim por implementar a logica de válidação aqui, na classe principal

	public static void main(String[] args) throws ParseException {// parseEx... é posto quando o metodo pode lançar uma exceção
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.println("Check-in date (dd/MM/yyyy) ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.println("Check-out date (dd/MM/yyyy) ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			

			System.out.print("Check-in date (dd/MM/yyyy) ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy) ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation, " + reservation);
			}
		}
		
		
		
		sc.close();
			

	}

}
