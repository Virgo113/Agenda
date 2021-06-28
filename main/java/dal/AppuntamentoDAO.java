package dal;

import java.time.LocalDate;
import java.util.List;

import model.Appuntamento;

public interface AppuntamentoDAO {
	
	String ADD_APPUNTAMENTO = "insert into appuntamenti(id_utente, data, ora_inizio, ora_fine, argomento) values (?,?,?,?,?)";
	String TROVA_APPUNTAMENTI = "select * from appuntamenti";
	String TROVA_APPUNTAMENTO_ID = "select * from appuntamenti where id= ?";
	String UPD_APPUNTAMENTI = "update appuntamenti set data=?, ora_inizio=?, ora_fine=?, argomento=?";
	String DEL_APPUNTAMENTO = "delete from appuntamenti where id=?";
	
	String TROVA_BY_DATA = "SELECT * FROM `appuntamenti` a, utenti u WHERE a.id_utente = u.id and data=? order by ora_inizio";
	
	void aggiungiAppuntamento(Appuntamento a);
	
	List<Appuntamento> trovaTutti();
	Appuntamento trovaAppuntamento(int id);
	
	void correggi(Appuntamento a, int id);
	
	void delAppuntamento(Appuntamento a, int id);
	
	List<Appuntamento> trovaByData(LocalDate data);
	
	
	

}
