<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Adicionar produto</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="produto">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="nome">Nome</form:label>
							<form:input path="nome" type="text" class="form-control"
								required="required" />
							<form:errors path="nome" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="valor">Valor</form:label>
							<form:input path="valor" type="text" class="form-control"
										required="required" />
							<form:errors path="valor" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="descricao">Descri&#231&#227o</form:label>
							<form:input path="descricao" type="text" class="form-control"
										required="required" />
							<form:errors path="descricao" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="desconto">Desconto (%)</form:label>
							<form:input path="desconto" type="text" inputmode="numeric" class="form-control"
										required="required" />
							<form:errors path="desconto" cssClass="text-warning" />
						</fieldset>
						<button type="submit" class="btn btn-success">Salvar</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
