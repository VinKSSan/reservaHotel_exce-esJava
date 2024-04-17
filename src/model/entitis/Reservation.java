package model.entitis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//deve ser statico para que não seja instãnciado um novo para cada objt reservation 
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if(!checkout.after(checkin)) {// tratando a exceção logo no começo, programação defênciva
			throw new DomainException("Check-out date must be after check-in date"); // tecnica para instaciar exceções
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckin() {
		return checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainException{//(Atent)como a exceção será tratada na classe principal, aqui podemos propagar
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates"); 
		}
		if(!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date"); // tecnica para instaciar exceções
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS );
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", check-in: "
				+sdf.format(checkin)
				+", check-out"
				+sdf.format(checkout)
				+", duration: "
				+duration()
				+" nigths.";
	}	
	
	
}
