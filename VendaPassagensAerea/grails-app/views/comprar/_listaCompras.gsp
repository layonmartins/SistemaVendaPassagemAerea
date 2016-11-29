
<h2>Minhas Passagens: </h2>
<g:if test="${compravoos.size() > 0}">
<table id="ListaItensCompra">
	<thead>
		<tr>
			<th>N° Voo</th>
			<th>Origem > Destino</th>
			<th>Data Voo</th>
			<th>Passageiro</th>
			<th>Preço</th>
			<th>Ação</th>
		</tr>
	</thead>
	<tbody>
		<g:each var="compravoo" in="${compravoos}">
		<tr>
			<td>${compravoo.voo.numeroVoo}</td>
			<td>${compravoo.voo.especificacao.origem} > ${compravoo.voo.especificacao.destino}</td>
			<td>${compravoo.voo.data.format("dd/MM/yyyy")}</td>
			<td>${compravoo.passageiro}</td>
			<td>R$${compravoo.voo.especificacao.custo}</td>
			<td>
				<a href="#" onclick="remover('${compravoo.index}')">Remover</a>
			</td>
		</tr>
		</g:each>
	</tbody>
	<tfoot>
		<tr>
			
			<th>Total de passagens</th>
			<td><b>${compravoos.size()}</b></td>
			<th>Preço total</th>
			<td>
				<b>R$ ${compravoos.voo.especificacao.custo.sum()}</b>
			</td>
			<td>
				
			</td>
		</tr>
	</tfoot>
</table>
<div id="divFinalizar">
<h2>Finalizar compra:</h2>
<input type="button" name="finalizar" value="Finalizar Compra" onClick="finalizarCompra()"/>&nbsp;
<input type="button" name="btnCancelar" value="Cancelar" onClick="cancelarTotal()"/><br>
</div>
</g:if>
<g:else>
	Sua lista de passagens está vazia 
</g:else>
