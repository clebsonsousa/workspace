<%@page import="java.util.ArrayList"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>


<!DOCTYPE html>
<html>
  <head>
    <link href ="js/jquery/jquery-ui.css" rel="stylesheet">
    <script src="js/jquery/external/jquery/jquery.js"></script>
    <script src="js/jquery/jquery-ui.js"></script>
  </head>
  <body>
 	<c:import url="cabecalho.jsp" />	
	    <h1>Adiciona Contatos</h1>
	    <hr />
	    <form action="mvc?logica=AdicionaContatoLogic" method="POST">
	      Nome: <input type="text" name="nome" /><br />
	      E-mail: <input type="text" name="email" /><br />
	      Endereço: <input type="text" name="endereco" /><br />
	      Data Nascimento: 
	       <caelum:campoData id="dataNascimento"/><br />
	      <input type="submit" value="Gravar" />
	    </form>
	<c:import url="rodape.jsp" />
  </body>
</html>
