package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public Integer duracao() {
		Date dataAtual = new Date();
		//String data = sdf.format(dataAtual);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataAtual);
		int anoAtual = cal.get(Calendar.YEAR);
		//System.out.println(anoAtual);
		cal.setTime(checkin);
		int diaIn = cal.get(Calendar.DAY_OF_MONTH);
		@SuppressWarnings("unused")
		int mesIn = cal.get(Calendar.MONTH);
		int anoIn = cal.get(Calendar.YEAR);
		cal.setTime(checkout);
		int diaOut = cal.get(Calendar.DAY_OF_MONTH);
		@SuppressWarnings("unused")
		int mesOut = cal.get(Calendar.MONDAY);
		int anoOut = cal.get(Calendar.YEAR);
		
		if(anoIn >= anoAtual && anoOut >= anoAtual) {
			if(diaOut > diaIn){
				return diaOut - diaIn;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(duracao() != 1 && duracao() !=2) {
			sb.append("Reservation: Room ");
			sb.append(this.getNumero()+", ");
			sb.append("check-in: ");
			sb.append(sdf.format(this.getCheckin())+", ");
			sb.append("check-out: ");
			sb.append(sdf.format(this.getCheckout())+", ");
			sb.append(duracao()+" nights");
		}else if(duracao() == 1) {
			sb.append("Error in reservation: Check-out date must be after check-in date");
		}else if(duracao() == 2) {
			sb.append("Error in reservation: Reservation dates for update must be future dates");
		}
		return sb.toString();
	}
}
