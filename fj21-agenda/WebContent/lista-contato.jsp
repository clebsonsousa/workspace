<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.caelum.jdbc.dao.ContatoDao" %>
<%@ page import="br.com.caelum.jdbc.modelo.Contato" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <body>
  
  <c:import url="cabecalho.jsp" />

    <h3>Lista de Contatos</h3>

<table border="1">
<tr>
	<td>ID</td>
	<td>Nome</td>
	<td>Email</td>
	<td>Endereço</td>
	<td>Data Nascimento</td>
</tr>
<c:forEach var="contato" items="${dao.lista}">
  <tr>
    <td>${contato.id}</td>
    <td>${contato.nome}</td>
    <td>
	 <c:choose>
	  <c:when test="${not empty contato.email}">
	    <a href="mailto:${contato.email}">${contato.email}</a>
	  </c:when>
	  <c:otherwise>
	    E-mail não informado
	  </c:otherwise>
	</c:choose>
    </td>
    <td>${contato.endereco}</td>
    <td><fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy" />
   </td>
  </tr>
</c:forEach>
</table>

    <br>
    <h3>O que você deseja fazer?</h3>
    <form action="removeContato" method="POST">

    </form >


    <select>
   	  <option value="listarContato">lista</option>
	  <option value="adicionarContato">adicionar</option>
	  <option value="editarContato">editar</option>
	  <option value="atualizarContato">atualizar</option>
	  <option value="removerContato">remover</option>
	</select>
<c:import url="rodape.jsp" />	
  </body>
</html>
