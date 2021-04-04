package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// Fazer um programa para ler os dados de uma reserva de hotel
		// (número do quarto, data de entrada e data de saída) e mostrar os 
		// dados da reserva, inclusive sua duração em dias. Em seguida, 
		// ler novas datas de entrada e saída, atualizar a reserva, e mostrar 
		// novamente a reserva com os dados atualizados.
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int num = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date dataIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dataOut = sdf.parse(sc.next());
		if(!dataOut.after(dataIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reserva reserva = new Reserva(num, dataIn, dataOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
			Date now = new Date();
			if(!dataOut.after(dataIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else if(dataIn.before(now) || dataOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			}
			else {
				reserva.updateDates(dataIn, dataOut);
				System.out.println(reserva);
			}
		}
			sc.close();
	

	}

}
