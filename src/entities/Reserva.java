package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer numero;
	private Date checkin;
	private Date checkout;
	
	public Reserva() {
		
	}

	public Reserva(Integer numero, Date checkin, Date checkout) {
		super();
		this.numero = numero;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("Reservation: Room ");
			sb.append(this.getNumero()+", ");
			sb.append("check-in: ");
			sb.append(sdf.format(this.getCheckin())+", ");
			sb.append("check-out: ");
			sb.append(sdf.format(this.getCheckout())+", ");
			sb.append(duration()+" nights");
		
		return sb.toString();
	}
}
