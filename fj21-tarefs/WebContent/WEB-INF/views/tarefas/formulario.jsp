<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <body>
    <h3>Adicionar tarefas</h3>
  <form action="adicionaTarefa" method="post">
    Descrição:
			<br/>
    <textarea rows="5" cols="100" name="descricao"></textarea> 
			<br/>     
			<br/>
    <input type="submit" value="Adicionar"/>
  </form>
  </body>
</html>