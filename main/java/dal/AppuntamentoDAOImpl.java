package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.ZoneId;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;



import model.Appuntamento;

public class AppuntamentoDAOImpl implements AppuntamentoDAO {
	
	DB db = new DB();
	
	PreparedStatement ps;
	ResultSet rs;
	Statement stat;
	
	
	
	

	@Override
	public void aggiungiAppuntamento(Appuntamento a) {
		
		try {
			ps = db.getConn().prepareStatement(ADD_APPUNTAMENTO);
			
			ps.setInt(1, a.getId_utente());
			ps.setDate(2, Date.valueOf(a.getData()));
			ps.setTime(3, Time.valueOf(a.getOraInizio()));
			ps.setTime(4, Time.valueOf(a.getOraFine()));
			ps.setString(5, a.getArgomento());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Appuntamento> trovaTutti() {
		List<Appuntamento> appuntamenti = new LinkedList<>();
		
		try {
			stat = db.getConn().createStatement();
			rs = stat.executeQuery(TROVA_APPUNTAMENTI);
			
			while (rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setId_utente(rs.getInt("id_utente"));
				a.setData(rs.getDate("data").toLocalDate());
				a.setOraInizio(rs.getTime("ora_inizio").toLocalTime());
				a.setOraFine(rs.getTime("ora_fine").toLocalTime());
				a.setArgomento(rs.getString("argomento"));
				
				appuntamenti.add(a);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return appuntamenti;
	}

	@Override
	public Appuntamento trovaAppuntamento(int id) {
		
		return trovaTutti().get(id);
	}

	@Override
	public void correggi(Appuntamento a, int id) {
		
		try {
			ps = db.getConn().prepareStatement(UPD_APPUNTAMENTI);
			
			
			ps.setDate(1, Date.valueOf(a.getData()));
			ps.setTime(2, Time.valueOf(a.getOraInizio()));
			ps.setTime(3, Time.valueOf(a.getOraFine()));
			ps.setString(4, a.getArgomento());
			
			ps.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delAppuntamento(Appuntamento a, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Appuntamento> trovaByData(LocalDate data) {
		
		List<Appuntamento> appuntamenti = new LinkedList<>();
		
		try {
			ps = db.getConn().prepareStatement(TROVA_BY_DATA);
			ps.setDate(1, Date.valueOf(data));
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Appuntamento a = new Appuntamento();
				a.setId_utente(rs.getInt("id_utente"));
				a.setData(rs.getDate("data").toLocalDate());
				a.setOraInizio(rs.getTime("ora_inizio").toLocalTime());
				a.setOraFine(rs.getTime("ora_fine").toLocalTime());
				a.setArgomento(rs.getString("argomento"));
				
				appuntamenti.add(a);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appuntamenti;
	}
	
	
	public static void main(String[] args) {
		
		AppuntamentoDAO ad = new AppuntamentoDAOImpl();
		
		
		LocalDate a = LocalDate.of(2021, 5, 30);
		LocalTime i = LocalTime.of(13, 00);
		LocalTime f = LocalTime.of(14, 00);
		
		Appuntamento ap1 = new Appuntamento(0, 1, a, i, f, "Mangiare");
		
//		ad.aggiungiAppuntamento(ap1);
		
//		ad.correggi(ap1, 1);
		
		
		
		
		
		
		
		
		
		
		
		List<Appuntamento> app = ad.trovaTutti();
		
		for (Appuntamento appuntamento : app) {
			System.out.println(appuntamento.getArgomento());
			System.out.println(appuntamento.getData());
			System.out.println(appuntamento.getOraInizio());
			System.out.println(appuntamento.getOraFine());
			
		}
		
		
		
		
		
		
	}
	
	
}


