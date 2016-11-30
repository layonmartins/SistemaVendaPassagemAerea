<h3>Informe o nome do Passageiro:</h3>
<g:formRemote name="formComprar" url="[controller: 'comprar', action:'comprarPassagem']" update="listCompras" onSuccess="atualizarPoltrona()">
	<input type="text" name="passageiro" value="Fulano da Silva" required="required"/>&nbsp;
	<input type="text" name="passaporte" value="0002.00001.000-01" required="required"/>&nbsp;
	<input type="submit" name="ok" value="OK"/>	
	<input type="button" name="btnCancelar" value="Cancelar" onClick="cancelarComprar()"/><br>
	<input type="hidden" name="id" value="${id}"/>
</g:formRemote>
