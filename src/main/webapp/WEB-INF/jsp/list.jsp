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
						<th width="40%">Nome</th>
						<th width="20%">Valor</th>
						<th width="40%">Descri&#231&#227o</th>
						<th width="20%">Desconto</th>
						<th width="40%">Valor ap&#243s desconto</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.nome}</td>
							<td>${produto.valor}</td>
							<td>${produto.descricao}</td>
							<td>${produto.desconto}</td>
							<td>${produto.valorAposDesconto}</td>
							<td><a type="button" class="btn btn-success"
								href="/update?nome=${produto.nome}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete?nome=${produto.nome}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
