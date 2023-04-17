<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add">Adicionar produto</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Produtos</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="20%">Nome</th>
						<th width="20%">Valor</th>
						<th width="20%">Descri&#231&#227o</th>
						<th width="20%">Desconto</th>
						<th width="20%">Valor ap&#243s desconto</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.nome}</td>
							<td>R$${produto.valor}</td>
							<td>${produto.descricao}</td>
							<td>${produto.desconto}%</td>
							<td>R$${produto.valorAposDesconto}</td>
							<td><a type="button" class="btn btn-success"
								href="/update?id=${produto.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete?id=${produto.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
