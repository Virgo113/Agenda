package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Utente;

public class UtenteDAOImpl implements UtenteDAO {

	 DB db = new DB();
	 
	 PreparedStatement ps;
	 ResultSet rs;
	 Statement stat;
	 
	 
	 
	@Override
	public List<Utente> getAll() throws SQLException{
		List<Utente> utenti = new LinkedList<>();
		
		stat = db.getConn().createStatement();
		rs = stat.executeQuery(FIND_ALL);
		
		while (rs.next()) {
			Utente u = new Utente();
			u.setId_utente(rs.getInt("id"));
			u.setNome(rs.getString("nome"));
			u.setCognome(rs.getString("cognome"));
			u.setPassword(rs.getString("password"));
			
			utenti.add(u);
		}
		
		return utenti;
	}
	@Override
	public Utente getOne(int id) throws SQLException {
		return getAll().get(id);
	}
		

	public void addUtente(Utente u) {
		try {
			ps = db.getConn().prepareStatement(ADD);
			
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCognome());
			ps.setString(3, u.getPassword());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void delUtente(int id) {
		try {
			ps = db.getConn().prepareStatement(DELETE_ONE);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updUtente(Utente u, int id) {
		try {
			ps = db.getConn().prepareStatement(UPDATE);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCognome());
			ps.setInt(3, id);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void updPassword(Utente u, int id) {
		try {
			ps = db.getConn().prepareStatement(UPDATE);
			ps.setString(1, u.getPassword());
			ps.setInt(2, id);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		UtenteDAO ud = new UtenteDAOImpl();
		
//		Utente u1 = new Utente();
//		u1.setNome("Pino");
//		u1.setCognome("Silvestri");
//		u1.setPassword("mano");
//		
//		ud.addUtente(u1);
//		
//		Utente u2 = new Utente();
//		u2.setNome("Marco");
//		u2.setCognome("pluto");
//		
//		
//		ud.updUtente(u2, 1);
		
		ud.delUtente(2);
		
		
		try {
			
			
			
			List<Utente> tutti = ud.getAll();
			
			for (Utente utente : tutti) {
				
				System.out.println(utente.getNome());
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
