
<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Appuntamento"%>
<%@page import="java.util.List"%>
<%@page import="dal.AppuntamentoDAOImpl"%>
<%@page import="dal.AppuntamentoDAO"%>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>Appuntamenti del giorno</h1>

<% 
 AppuntamentoDAO ad = new AppuntamentoDAOImpl();
 List<Appuntamento> app = ad.trovaByData(LocalDate.now());
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
    
    <a href="http://localhost:8080/Es_Agenda/index.jsp">
	<button>Tutti gli appuntamenti</button></a>
    
    
    

</body>
</html>