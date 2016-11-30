<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Compras de Passagens Aéreas</title>
        <g:javascript library="jquery" />
    	<script type="text/javascript">
		    window.onload = function(){
		    	<g:remoteFunction controller="minhasCompras" action="exibir" update="listCompras"/>
		    }
        </script>
    </head>
    <body>
       <h1>Minhas Passagens Compradas</h1>
       
       <div id="listCompras">
       		
       </div>
       
    </body>
</html>
