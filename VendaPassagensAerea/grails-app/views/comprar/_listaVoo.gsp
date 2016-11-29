<h3> Voo: </h3>
<g:if test="${voos.size() > 0}">
<table>
	<thead>
		<tr>
			<th>N° Voo</th>
			<th>Origem</th>
			<th>Destino</th>
			<th>Data</th>
			<th>Lugares Disp.</th>
			<th>Tipo</th>
			<th>Preço</th>
			<th>Ação</th>
		</tr>
	</thead>
	<tbody>
		<g:each var="voo" in="${voos}">
		<tr>
			<td>${voo.numeroVoo}</td>
			<td>${voo.especificacao.origem}</td>
			<td>${voo.especificacao.destino}</td>
			<td>${voo.data.format("dd/MM/yyyy")}</td>
			<td>${voo.lugaresDisponiveis}</td>
			<td>${voo.especificacao.tipo}</td>
			<td>R$${voo.especificacao.custo}</td>
			<td>
				<g:if test="${voo.lugaresDisponiveis == 0}">
				<b>Lotado</b>
				</g:if>
				<g:else>
				<g:remoteLink controller="comprar" action="comprar" update="formComprar" id="${voo.id}">Comprar</g:remoteLink>	</g:else>
			</td>
		</tr>
		</g:each>
	</tbody>
</table>
</g:if>
<g:else>
	Nenhuma voo encontrado
</g:else>
