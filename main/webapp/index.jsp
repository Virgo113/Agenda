
<!DOCTYPE html>
<%@page import="model.Appuntamento"%>
<%@page import="java.util.List"%>
<%@page import="dal.AppuntamentoDAOImpl"%>
<%@page import="dal.AppuntamentoDAO"%>
<html>
<head>
<meta charset="utf-8">
<title>Appuntamenti</title>
</head>
<body>

	<h1>Appuntamenti</h1>


<% 
 AppuntamentoDAO ad = new AppuntamentoDAOImpl();
 List<Appuntamento> app = ad.trovaTutti();
 for (Appuntamento appuntamento : app) {
		//System.out.println(appuntamento.getArgomento());
		//System.out.println(appuntamento.getData());
		//System.out.println(appuntamento.getOraInizio());
		//System.out.println(appuntamento.getOraFine());
		}
		
%>
<% for(Appuntamento a: app){%>
    
        <p><%=a.toString() %></p>
    
    <% } %>


	<form action="aggiungi" method="post">
	
	<input type="date" name="data" id="data" placeholder="Data">
	<input type="time" name="oraInizio" id="oraInizio" placeholder="Ora Inizio">
	<input type="time" name="oraFine" id="oraFine" placeholder="Ora Fine">
	<input type="text" name="argomento" id="argomento" placeholder="Argomento">
	
	<input type="submit" value="aggiungi">
	
	</form>


</body>
</html>