package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	Date now = new Date();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// o static garante que nao sera instanciado um novo SimpleDateFormat para
	// cada objeto Reservation criado. Sera necessário apenas um
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
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

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // resultado obtido em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	// torna compatível;
	//o dado é do tipo long, pois a diferença entre datas é do tipo long
	// TimeUnit tipo enumerado complexo que tem algumas operações
	// Converte o argumento em miliseconds (diff, TimeUnit.MILLISECONDS) para
	// dias (TimeUnit.DAYS.convert)
	
	public void updateDates(Date checkIn, Date checkOut) {		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
