<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>adiciona</title>
	<style>
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		  overflow: hidden;
		  background-color: #333333;
		}
		
		li {
		  float: left;
		}
		
		li a {
		  display: block;
		  color: white;
		  text-align: center;
		  padding: 16px;
		  text-decoration: none;
		}
		
		li a:hover {
		  background-color: #111111;
		}
	</style>
</head>
<body>
	<ul style="list-style-type:none;">
		<li><a href="/fubaEmJava/adiciona.jsp">nova amostra</a></li>
		<li><a href="/encontrarAmostra">encontrar amostra</a></li>
		<li><a href="/alterar">produtos</a>
	</ul>
	
	<form>
	<select name="tdas">
		<%
  			List tdas = (List)session.getAttribute("tiposDeAmostra");
  			for(int i = 0; i < tdas.size(); i++) {
     		TipoDeAmostra tda = tdas.get(i);
 		%>
      	<option value=<%=tda.getId()%>> <%=tda.getDsTipoDeAmostra();%> </option>																
 		<% } //fecha for
		%>
	</select>
	</form>
</body>
</html>