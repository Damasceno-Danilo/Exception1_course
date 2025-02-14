package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date(dd/MM/yyyy): " );
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-in date(dd/MM/yyyy): " );
        Date checkout = sdf.parse(sc.next());

        if(!checkout.after(checkIn)) {
            System.out.println("Error in reservation: check-out: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("reservation " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date(dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date(dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());


                String error =  reservation.updateDates(checkIn, checkout);
                if (error != null) {
                    System.out.println("Error in reservation: " + error);
                }
                else {
                    System.out.println("reservation " + reservation);
                }
        }
        sc.close();
    }
}