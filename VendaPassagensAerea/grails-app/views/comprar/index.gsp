<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Compras de Passagens Aéreas</title>
        <g:javascript library="jquery" />
    	<script type="text/javascript">
		    function cancelarComprar(){
				jQuery("#formComprar").html("")
			}
			function atualizarPoltrona(){
    			jQuery("#Buscar").submit()
    			cancelarComprar()
    		} 
    		function remover(id){
    			if(confirm("Deseja mesmo remover esta passagem?"))
 				<g:remoteFunction controller="comprar" action="remover" update="listCompras" id="'+id+'" onSuccess="atualizarPoltrona()"/>
    		}
    		function finalizarCompra(){
    			<g:remoteFunction controller="comprar" action="finalizarCompra" update="formPesquisar"/>
    			jQuery("#listCompras").html("")
    			jQuery("#formComprar").html("")
    			jQuery("#listVoo").html("")
    		}
    		function cancelarTotal(){
    			<g:remoteFunction controller="comprar" action="cancelarTotal" update="listVoo"/>
    			jQuery("#listCompras").html("")
    			jQuery("#formComprar").html("")
    			
    		}  		
        </script>
    </head>
    <body>
       <h1>AHHH Deus, abeçoaaa</h1>
       
       <div id="formPesquisar">
       		<g:render template="formPesquisar"/>
       </div>
       
       <div id="listVoo">
			
       </div>
       
       <div id="formComprar">
			
       </div>
       
       <div id="listCompras">
       
       </div>
       
    </body>
</html>
