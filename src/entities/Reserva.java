package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private Integer retorno;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
		checarData();
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
	
	public void checarData() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int anoAtual = cal.get(Calendar.YEAR);
		cal.setTime(checkin);
		int diaIn = cal.get(Calendar.DAY_OF_MONTH);
		int anoIn = cal.get(Calendar.YEAR);
		cal.setTime(checkout);
		int diaOut = cal.get(Calendar.DAY_OF_MONTH);
		int anoOut = cal.get(Calendar.YEAR);
		if(anoIn == anoAtual  || anoOut >= anoAtual) {
			if(diaIn < diaOut) {
				retorno = 0;
			}else{
				retorno = 1;
			}	
		}else {
			retorno = 2;
		}
	}
	
	public void updateDates(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
		checarData();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(retorno == 0) {
			sb.append("Reservation: Room "+this.getRoomNumber()+", check-in: "+sdf.format(this.getCheckin())+", check-out: "+sdf.format(this.getCheckout())+", "+duracao()+" nights");
		}else if(retorno == 1) {
			sb.append("Error in reservation: Check-out date must be after check-in date.");
		}else if(retorno ==2){
			sb.append("Error in reservation: Reservation dates for update must be future dates.");
		}
		return sb.toString();
	}

}
