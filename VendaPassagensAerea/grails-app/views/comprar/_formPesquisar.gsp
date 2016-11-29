<h2>Buscar Voo:</h2>
<g:formRemote id="formPesquisar" name="formPesquisar" url="[controller: 'comprar', action:'buscar']" update="listVoo">
	Origem <input type="text" name="origem" value="São Carlos" required="required"/>&nbsp;
	Destino <input type="text" name="destino" value="Passos" required="required"/>&nbsp;
	Data <input type="date" name="data" value="${new Date().format('yyyy-MM-dd')}" min="${new Date().format('yyyy-MM-dd')}"/>
	
	<input id="Buscar" type="submit" name="btnBuscar" value="Buscar"/>	
</g:formRemote>
