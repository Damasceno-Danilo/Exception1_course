package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
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

    public String updateDates(Date checkin, Date checkout) {

        Date now = new Date();
        if (checkIn.before(now) || checkout.before(now)) {
            return "Reservation dates for update must be future dates";
        } if (!checkout.after(checkIn)) {
            return "check-out: Check-out date must be after check-in date";
        }
        else {

            this.checkIn = checkin;
            this.checkOut = checkout;
            return null;
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
