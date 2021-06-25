package model;


import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.GregorianCalendar;

public class Appuntamento {

	private int id, id_utente;
//	private GregorianCalendar data = new GregorianCalendar();
//	private GregorianCalendar oraInizio = new GregorianCalendar();
//	private GregorianCalendar oraFine = new GregorianCalendar();
	private LocalDate data = LocalDate.now();
	private LocalTime oraInizio = LocalTime.now();
	private LocalTime oraFine = LocalTime.now();
	
	private String argomento;
	
	public Appuntamento() {	}
	
	
	

	public Appuntamento(int id, int id_utente, LocalDate data, LocalTime oraInizio, LocalTime oraFine,
			String argomento) {
		
		this.id = id;
		this.id_utente = id_utente;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.argomento = argomento;
	}




	public int getId_appuntamento() {
		return id;
	}

	public void setId_appuntamento(int id) {
		this.id = id;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	

	

	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	
	
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}

	public LocalTime getOraFine() {
		return oraFine;
	}

	public void setOraFine(LocalTime oraFine) {
		this.oraFine = oraFine;
	}

	@Override
	public String toString() {
		return "Appuntamento [id_appuntamento=" + id + ", id_utente=" + id_utente + ", data=" + data
				+ ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", argomento=" + argomento + "]";
	}
	
	
	
	
	
}
