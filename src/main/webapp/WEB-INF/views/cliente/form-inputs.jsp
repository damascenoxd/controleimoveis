<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">nome</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' />
		<form:errors path='nome' />

	</div>
</div>
<div class="form-group">
	<label for="dataAniversario">dataAniversario</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='dataAniversario' type='text' />
		<form:errors path='dataAniversario' />

	</div>
</div>
<div class="form-group">
	<label for="estadoCivil">estadoCivil</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='estadoCivil' type='text' />
		<form:errors path='estadoCivil' />

	</div>
</div>
<div class="form-group">
	<label for="profissao">profissao</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='profissao' type='text' />
		<form:errors path='profissao' />

	</div>
</div>
<div class="form-group">
	<label for="cpf">cpf</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='cpf' type='text' />
		<form:errors path='cpf' />

	</div>
</div>
<div class="form-group">
	<label for="rg">rg</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='rg' type='text' />
		<form:errors path='rg' />

	</div>
</div>
<div class="form-group">
	<label for="renda">renda</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='renda' type='text' />
		<form:errors path='renda' />

	</div>
</div>
<div class="form-group">
	<label for="dataCadastro">dataCadastro</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='dataCadastro' type='text' />
		<form:errors path='dataCadastro' />

	</div>
</div>

<!-- ======================= INICIO ENDEREÇO ======================= -->

<div class="form-group">
	<label for="cep">cep</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='endereco.cep' type='text' />
		<form:errors path='endereco.cep' />

	</div>
</div>
<div class="form-group">
	<label for="logradouro">logradouro</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='endereco.logradouro' type='text' />
		<form:errors path='endereco.logradouro' />

	</div>
</div>
<div class="form-group">
	<label for="pontoReferencia">pontoReferencia</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='endereco.pontoReferencia' type='text' />
		<form:errors path='endereco.pontoReferencia' />

	</div>
</div>
<div class="form-group">
	<label for="numero">numero</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='endereco.numero' type='text' />
		<form:errors path='endereco.numero' />

	</div>
</div>
<div class="form-group">
	<label for="complemento">complemento</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='endereco.complemento' type='text' />
		<form:errors path='endereco.complemento' />

	</div>
</div>
<div class="form-group">
	<label for="bairro.id">bairro.id</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path='endereco.bairro.id' items='${bairroList}' itemValue='id'
			itemLabel='nome'>
		</form:select>
		<form:errors path='endereco.bairro.id' />

	</div>
</div>

<!-- ======================= FIM DO ENDEREÇO ======================= -->

<div class="form-group">
	<label for="telefone.id">telefone.id</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path='telefone.id' items='${telefoneList}' itemValue='id'
			itemLabel='telefone'>
		</form:select>
		<form:errors path='telefone.id' />

	</div>
</div>
