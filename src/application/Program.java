package application;

import model.entities.Reservation;
import model.exceptions.DomainException;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date(dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date(dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("reservation " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date(dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date(dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkout);
            System.out.println("Error in reservation: " + reservation);

        } catch (ParseException e) {
            System.out.println("invalid date format");
        }catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}