package model;

public class Utente {
	
	private int id_utente;
	private String password, nome, cognome;

	
	
	public Utente() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}




	@Override
	public String toString() {
		return "Utente [id_utente=" + id_utente + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome
				+ "]";
	}
	
	
	
	
	
	
	

}
