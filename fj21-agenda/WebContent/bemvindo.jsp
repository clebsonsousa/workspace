<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.caelum.jdbc.dao.ContatoDao" %>
<%@ page import="br.com.caelum.jdbc.modelo.Contato" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <body>
  
  <c:import url="cabecalho.jsp" />
<form action="mvc?"  >
    <select name="proxpag" id="proxpag">
   	  <option value="lista-contato.jsp">Lista</option>
	  <option value="adiciona-contato.jsp">Adicionar</option>
	  <option value="atualiza-contato.jsp">Atualizar</option>
	  <option value="remove-contato.jsp">Remover</option>
	</select>
	<input type="submit" value="Submit" />
</form>
<c:import url="rodape.jsp" />	
  </body>
</html>
