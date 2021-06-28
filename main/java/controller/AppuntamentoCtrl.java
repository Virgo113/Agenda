package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.AppuntamentoDAO;
import dal.AppuntamentoDAOImpl;
import model.Appuntamento;


/**
 * Servlet implementation class AppuntamentoCtrl
 */
@WebServlet("/aggiungi")
public class AppuntamentoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppuntamentoDAO ad = new AppuntamentoDAOImpl();
     
    public AppuntamentoCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("argomento")!=null) {
			
//			System.out.println(request.getParameter("oraInizio"));
//			System.out.println(request.getParameter("oraFine"));
			
			int idUtente = 1;
			String argomento = request.getParameter("argomento");
			LocalDate data = LocalDate.parse(request.getParameter("data"));
			LocalTime oraInizio = LocalTime.parse(request.getParameter("oraInizio"));
			LocalTime oraFine = LocalTime.parse(request.getParameter("oraFine"));
			
			List<Appuntamento> app = ad.trovaTutti();
			boolean errore = false;
			for (Appuntamento appuntamento : app) {
				if (data.isEqual(appuntamento.getData()) && oraInizio.isAfter(appuntamento.getOraInizio()) && oraInizio.isBefore(appuntamento.getOraFine())) {
				errore = true;
				}				
			}
			
			if (errore == false) {
				
				Appuntamento a = new Appuntamento(0, idUtente, data, oraInizio, oraFine, argomento);
				
				ad.aggiungiAppuntamento(a);
			}else {
				
				System.out.println("Esiste un appuntamento giá inserito");
			}
				
		}
		
		
		
		doGet(request, response);
	}

}
