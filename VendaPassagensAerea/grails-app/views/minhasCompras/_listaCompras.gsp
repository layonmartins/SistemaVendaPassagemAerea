<g:if test="${compravoos.size() > 0}">
<table id="ListaItensCompra">
	<thead>
		<tr>
			<th>N° Compra</th>
			<th>Data Compra</th>
			<th>N° Voo</th>
			<th>Origem > Destino</th>
			<th>Data Voo</th>
			<th>Passageiro</th>
			<th>Passaporte</th>
			<th>Preço</th>
		</tr>
	</thead>
	<tbody>
		<g:each var="compravoo" in="${compravoos}">
		<tr>
			<td>${compravoo.compra.id}</td>
			<td>${compravoo.compra.data.format("dd/MM/yyyy")}</td>
			<td>${compravoo.voo.numeroVoo}</td>
			<td>${compravoo.voo.especificacao.origem} > ${compravoo.voo.especificacao.destino}</td>
			<td>${compravoo.voo.data.format("dd/MM/yyyy")}</td>
			<td>${compravoo.passageiro}</td>
			<td>${compravoo.passaporte}</td>
			<td>R$${compravoo.voo.especificacao.custo}</td>
		</tr>
		</g:each>
	</tbody>
	<tfoot>
		<tr>
			<th>Total de passagens</th>
			<td><b>${compravoos.size()}</b></td>
		</tr>
	</tfoot>
</table>
</g:if>
<g:else>
	Sua lista de passagens está vazia 
</g:else>
