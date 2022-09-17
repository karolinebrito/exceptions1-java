package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// o static garante que nao sera instanciado um novo SimpleDateFormat para
	// cada objeto Reservation criado. Sera necess�rio apenas um
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
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
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime(); // resultado obtido em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	// torna compat�vel;
	//o dado � do tipo long, pois a diferen�a entre datas � do tipo long
	// TimeUnit tipo enumerado complexo que tem algumas opera��es
	// Converte o argumento em miliseconds (diff, TimeUnit.MILLISECONDS) para
	// dias (TimeUnit.DAYS.convert)
	
	public void updateDates (Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
