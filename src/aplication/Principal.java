package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// Fazer um programa para ler os dados de uma reserva de hotel
		// (n�mero do quarto, data de entrada e data de sa�da) e mostrar os 
		// dados da reserva, inclusive sua dura��o em dias. Em seguida, 
		// ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar 
		// novamente a reserva com os dados atualizados.
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int num = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date dataIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dataOut = sdf.parse(sc.next());
		Reserva reserva = new Reserva(num, dataIn, dataOut);
		System.out.println(reserva);
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date datanovaIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date datanovaOut = sdf.parse(sc.next());
		Reserva novaReserva = new Reserva(num, datanovaIn, datanovaOut);
		System.out.println(novaReserva);
		sc.close();
	}

}