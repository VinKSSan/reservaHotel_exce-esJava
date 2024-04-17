package model.entitis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//deve ser statico para que não seja instãnciado um novo para cada objt reservation 
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		super();
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
	//agora updateDates retorna uma string
	public String updateDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(!checkout.after(checkin)) {
			return "Check-out date must be after check-in date";
		} 
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null; // retornando nulo caso não haja erros
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
