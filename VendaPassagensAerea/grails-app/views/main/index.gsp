<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:javascript library="jquery" />

	
</head>
<body>



<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			
			<center><asset:image src="planes.png"/></center>
			<hr>

			<sec:ifNotLoggedIn>
				<h3>Ainda não tem um cadastro?</h3>
				<ul>
					<button class="btn btn-defaul"><g:link controller='cadastrar' action='index'>Cadastrar</g:link></button>
				</ul>
			</sec:ifNotLoggedIn>

			<sec:ifLoggedIn>
				<sec:ifAnyGranted roles='ROLE_ADMIN'>

					Perfil: <b>Administrador</b>
					<nav class="navbar navbar-inverse">
		                <div class="container-fluid">
		                    <!-- Brand and toggle get grouped for better mobile display -->
		                    <div class="navbar-header">
		                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		                            <span class="sr-only">Toggle navigation</span>
		                            <span class="icon-bar"></span>
		                            <span class="icon-bar"></span>
		                            <span class="icon-bar"></span>
		                        </button>
		                    </div>

		                    <!-- Collect the nav links, forms, and other content for toggling -->
		                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                        <ul class="nav navbar-nav">
		                            <li><g:link controller='aviao' action='index'>Cadastrar Avião</g:link></li>
		                            <li><g:link controller='cidade' action='index'>Cadastrar Cidades</g:link></li>
									<li><g:link controller='cliente' action='index'>Consultar Clientes</g:link></li>
									<li><g:link controller='compra' action='index'>Consultar Compras</g:link></li>
									<li><g:link controller='especificacao' action='index'>Cadastro de Especificações de Voo</g:link></li>
									<li><g:link controller='voo' action='index'>Cadastro de Voos</g:link></li>
		                        </ul>

		                        
		                    </div><!-- /.navbar-collapse -->
		                </div><!-- /.container-fluid -->
		            </nav>

				</sec:ifAnyGranted>

				<sec:ifAnyGranted roles='ROLE_CLIENTE'>

					<nav class="navbar navbar-inverse">
		                <div class="container-fluid">
		                    <!-- Brand and toggle get grouped for better mobile display -->
		                    <div class="navbar-header">
		                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		                            <span class="sr-only">Toggle navigation</span>
		                            <span class="icon-bar"></span>
		                            <span class="icon-bar"></span>
		                            <span class="icon-bar"></span>
		                        </button>
		                    </div>

		                    <!-- Collect the nav links, forms, and other content for toggling -->
		                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                        <ul class="nav navbar-nav">
		                            <li><g:link controller='comprar' action='index'>Comprar Passagens</g:link></li>
									<li><g:link controller='minhasCompras' action='index'>Minhas Passagens</g:link></li>
									%{--No botão a baixo não consegui pegar o id do usuario logado para editar então coloquei 2--}%
									<li><g:link controller='Cliente' action='edit' id="2">Editar meus dados</g:link></li>
		                        </ul>
		                    </div><!-- /.navbar-collapse -->
		                </div><!-- /.container-fluid -->
		            </nav>

				</sec:ifAnyGranted>


			</sec:ifLoggedIn>

		</div>
		<div class="col-md-1"></div>
	</div>
</div>

	

</body>


</html>
