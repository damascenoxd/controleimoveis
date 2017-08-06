<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="cep">cep</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='cep' type='text' />
		<form:errors path='cep' />

	</div>
</div>
<div class="form-group">
	<label for="logradouro">logradouro</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='logradouro' type='text' />
		<form:errors path='logradouro' />

	</div>
</div>
<div class="form-group">
	<label for="pontoReferencia">pontoReferencia</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='pontoReferencia' type='text' />
		<form:errors path='pontoReferencia' />

	</div>
</div>
<div class="form-group">
	<label for="numero">numero</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='numero' type='text' />
		<form:errors path='numero' />

	</div>
</div>
<div class="form-group">
	<label for="complemento">complemento</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='complemento' type='text' />
		<form:errors path='complemento' />

	</div>
</div>
<div class="form-group">
	<label for="bairro.id">bairro.id</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path='bairro.id' items='${bairroList}' itemValue='nome'
			itemLabel='nome'>
		</form:select>
		<form:errors path='bairro.id' />

	</div>
</div>
