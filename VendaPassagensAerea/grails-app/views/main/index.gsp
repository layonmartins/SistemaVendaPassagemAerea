<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:javascript library="jquery" />
    </head>
    <body>
     

            <h1>Voo com a agente - #Vem de VarinGrails</h1>
            <asset:image src="aviao.png"/><br/>
            
          <sec:ifNotLoggedIn>
          	<h3>Ainda não tem um cadastro?</h3>
          	<ul>
				<li><g:link controller='cadastrar' action='index'>Cadastrar</g:link></li>
			</ul>
		  </sec:ifNotLoggedIn>
		  
		
		<sec:ifLoggedIn>
				<sec:ifAnyGranted roles='ROLE_ADMIN'>
					Perfil: <b>Administrador</b>
					<h3>Ações:</h3>
					<ul>
						<li><g:link controller='aviao' action='index'>Cadastrar Avião</g:link></li>
						<li><g:link controller='cidade' action='index'>Cadastrar Cidades</g:link></li>
						<li><g:link controller='cliente' action='index'>Clientes</g:link></li>
						<li><g:link controller='compra' action='index'>Compras dos Clientes</g:link></li>
						<li><g:link controller='compraVoo' action='index'>ComprasVoo</g:link></li>
						<li><g:link controller='especificacao' action='index'>Cadastro de Especificações de Voo</g:link></li>
						<li><g:link controller='voo' action='index'>Cadastro de Voos</g:link></li>
					</ul>
				</sec:ifAnyGranted>

				<sec:ifAnyGranted roles='ROLE_CLIENTE'>
					Perfil: <b>Cliente</b>
					<h3>Ações:</h3>
					<ul>
						<li><g:link controller='comprar' action='index'>Comprar Passagens</g:link></li>
						<li><g:link controller='minhasCompras' action='index'>Minhas Passagens</g:link></li>
					</ul>
				</sec:ifAnyGranted>
		</sec:ifLoggedIn> 
    </body>
</html>
