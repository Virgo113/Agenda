package dal;

import java.sql.SQLException;
import java.util.List;

import model.Utente;

public interface UtenteDAO {
	//queries
	String FIND_ALL = "select * from utenti";
	String FIND_ONE_BY_ID = "select * from utenti where id= ?";
	String ADD = "insert into utenti(nome, cognome, password) values (?,?,?)";
	String UPDATE = "update utenti set nome=?, cognome=? where id=?";
	String DELETE_ONE = "delete from utenti where id=?";
	String UPDATE_PASSWORD = "update utenti set password=? where id=?";

	List<Utente> getAll() throws SQLException;
	
	Utente getOne(int id) throws SQLException;
	
	void addUtente(Utente u);
	
	void delUtente(int id);
	
	void updUtente(Utente u, int id);
	
	void updPassword(Utente u, int id);
	
	
	
	
	
	
	
}
