<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Fazer Cadastro</title>
        <g:javascript library="jquery" />
    	<script type="text/javascript">
		  	function sucesso(){
		  		jQuery("#formCadastrar").html("")
		  		jQuery("#divVoltar").html("<a href='../'>Voltar a página inicial</a>")
		  	}
        </script>
    </head>
    <body>
   <h2>Tela de Cadastro de Cliente</h2>
    <div id="formCadastrar">
	   <g:formRemote name="formCadastrar" url="[controller: 'cadastrar', action:'cadastrar']" update="divCadastrado" onSuccess="sucesso()">
		Nome <input type="text" name="nome" value="Beltrano" required="required"/><br/>
		SobreNome <input type="text" name="sobreNome" value="Monteiro" required="required"/><br/>
		Email <input type="email" name="email" value="beltrano@cliente.com" required="required"/><br/>
		Data Nasc <input type="date" name="data" value="${new Date().format('yyyy-MM-dd')}"/><br/>
		Login <input type="text" name="username" value="beltrano" required="required"/><br/>
		Senha <input type="password" name="password" value="123" required="required"/><br/>
		<input type="submit" name="salvar" value="Salvar"/>	
		<input type="button" name="btnCancelar" value="Cancelar" onClick="location.href='../'"/><br>
		</g:formRemote>
    </div>
       
    <div id="divCadastrado">
    </div>
    
     <div id="divVoltar">
    </div>
    
    </body>
</html>
