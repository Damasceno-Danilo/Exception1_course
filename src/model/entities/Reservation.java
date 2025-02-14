package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)) {
            throw new DomainException ("check-out: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) throws DomainException{

        Date now = new Date();
        if (checkIn.before(now) || checkout.before(now)) {
            throw new DomainException ("Reservation dates for update must be future dates");
        } if (!checkout.after(checkIn)) {
            throw new DomainException ("check-out: Check-out date must be after check-in date");
        }
        else {
            this.checkIn = checkin;
            this.checkOut = checkout;
        }
    }

    @Override
    public String toString() {
        return "Room = " + roomNumber +
                ", check-in = " + sdf.format(checkIn) +
                ", check-out = " + sdf.format(checkOut) +
                ", " + duration() +
                " nights";
    }
}
