package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;
import model.exception.DomainException;

public class Principal {

	public static void main(String[] args) {
		// Fazer um programa para ler os dados de uma reserva de hotel
		// (número do quarto, data de entrada e data de saída) e mostrar os 
		// dados da reserva, inclusive sua duração em dias. Em seguida, 
		// ler novas datas de entrada e saída, atualizar a reserva, e mostrar 
		// novamente a reserva com os dados atualizados.
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
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
			
			reserva.updateDates(dataEntrada, dataSaida);
			
				System.out.println("Reservation: "+ reserva);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		
		catch(DomainException e) {
			System.out.println("Error in Reservation: "+e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error: ");
			System.exit(0);
		}
		
		sc.close();
	}

}
