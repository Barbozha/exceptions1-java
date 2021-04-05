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
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dataSaida = sdf.parse(sc.next());
		Reserva reserva = new Reserva(num, dataEntrada, dataSaida);
		System.out.println(reserva);
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		dataEntrada = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		dataSaida = sdf.parse(sc.next());
		String error = reserva.updateDates(dataEntrada, dataSaida);
		if(error != null) {
			System.out.println("Error in reservation: "+error);
		}
		else {
			System.out.println("Reservation: "+ reserva);
		}
		
		sc.close();
	}

}
