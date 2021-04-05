package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
		updateDates(checkin, checkout);
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
	
	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int anoAtual = cal.get(Calendar.YEAR);
		cal.setTime(checkin);
		int anoIn = cal.get(Calendar.YEAR);
		cal.setTime(checkout);
		int anoOut = cal.get(Calendar.YEAR);
		if(!checkout.after(checkin)) {
			throw new IllegalArgumentException("Check-out date must be after check-in date");
		}
		if(anoIn < anoAtual || anoOut < anoAtual) {
			throw new IllegalArgumentException("Reservation dates for update must be future dates");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("Reservation: Room "+this.getRoomNumber()+", check-in: "+sdf.format(this.getCheckin())+", check-out: "+sdf.format(this.getCheckout())+", "+duracao()+" nights");
		return sb.toString();
	}

}
