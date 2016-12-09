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
        <div class="container-fluid">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                
       <h1>Minhas Passagens Compradas</h1>
       
       <div id="listCompras">
          
       </div>
       <button onClick="location.href='../Comprar'"">Comprar Nova Passagem</button>       
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
    </body>
</html>
