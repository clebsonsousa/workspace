<!DOCTYPE html>
<html>
  <body>
    <h1>Atualiza Contatos</h1>
    <hr />
    <form action="mvc?logica=AtualizaContatoLogic" method="POST">
      ID: <input type="text" name="id" /><br />
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data Nascimento: 
        <input type="text" name="dataNascimento" /><br />
      <input type="submit" value="Gravar" />
    </form>
  </body>
</html>