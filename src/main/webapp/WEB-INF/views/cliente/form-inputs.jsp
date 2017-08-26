<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="title">
	<h3>
		<small>Informações básicas</small>
	</h3>
</div>

<div class="form-group label-floating">
	<label for="nome" class="control-label">Nome</label>
	<div class="input-group">
		<form:input path='nome' type='text' placeholder="Nome"
			class="form-control" />
		<form:errors path='nome' ><span class="label label-danger">Nome é obrigatório</span></form:errors>
	</div>
</div>

<div class="form-group label-floating">
	<label for="telefone" class="control-label">Telefone</label>
	<div class="input-group">
		<form:input path='telefone.telefone' type='text'
			placeholder="Telefone" class="form-control" />
		<form:errors path='telefone.telefone' />
	</div>
</div>

<div class="form-group label-floating">
	<label for="operadora" class="control-label">Operadora</label>
	<div class="input-group">
		<form:input path='telefone.operadora' type='text'
			placeholder="Operadora" class="form-control" />
		<form:errors path='telefone.operadora' />
	</div>
</div>

<div class="title">
	<h3>
		<small>Dados Pessoais</small>
	</h3>
</div>

<div class="form-group label-floating">
	<label for="dataAniversario" class="control-label">Data de
		nascimento</label>
	<div class="input-group">
		<form:input path='dataAniversario' type='text'
			placeholder="Data de nascimento" class="form-control" />
		<form:errors path='dataAniversario' ><span class="label label-danger">Data de Nascimento inválida</span></form:errors>
	</div>
</div>

<div class="form-group label-floating">
	<label for="estadoCivil" class="control-label">Estado civil</label>
	<div class="input-group">
		<form:input path='estadoCivil' type='text' placeholder="Estado civil"
			class="form-control" />
		<form:errors path='estadoCivil' />

	</div>
</div>

<div class="form-group label-floating">
	<label for="profissao" class="control-label">Profissão</label>
	<div class="input-group">
		<form:input path='profissao' type='text' placeholder="Profissão"
			class="form-control" />
		<form:errors path='profissao' />
	</div>
</div>

<div class="form-group label-floating">
	<label for="cpf" class="control-label">CPF</label>
	<div class="input-group">
		<form:input path='cpf' type='text' placeholder="CPF"
			class="form-control" />
		<form:errors path='cpf' />
	</div>
</div>

<div class="form-group label-floating">
	<label for="rg" class="control-label">RG</label>
	<div class="input-group">
		<form:input path='rg' type='text' placeholder="RG"
			class="form-control" />
		<form:errors path='rg' />

	</div>
</div>

<div class="form-group label-floating">
	<label for="renda" class="control-label">Renda bruta</label>
	<div class="input-group">
		<form:input path='renda' type='text' placeholder="Renda bruta"
			class="form-control" />
		<form:errors path='renda'><span class="label label-danger">Valor da renda inválido</span></form:errors>
	</div>
</div>

<!-- <div class="form-group label-floating"> -->
<!-- 	<label for="dataCadastro" class="control-label">Data de -->
<!-- 		cadastro</label> -->
<!-- 	<div class="input-group"> -->
<%-- 		<form:input path='dataCadastro' type='text' --%>
<%-- 			placeholder="Data de cadastro" class="form-control" /> --%>
<%-- 		<form:errors path='dataCadastro' /> --%>

<!-- 	</div> -->
<!-- </div> -->


<!-- ======================= INICIO ENDEREÇO ======================= -->

<div class="title">
	<h3>
		<small>Endereço</small>
	</h3>
</div>

<div class="form-group label-floating">
	<label for="cep" class="control-label">CEP</label>
	<div class="input-group">
		<form:input path='endereco.cep' type='text'
			placeholder="CEP" class="form-control"/>
		<form:errors path='endereco.cep' />

	</div>
</div>
<div class="form-group label-floating">
	<label for="logradouro" class="control-label">Rua</label>
	<div class="input-group">
		<form:input path='endereco.logradouro' type='text' placeholder="Rua" class="form-control"/>
		<form:errors path='endereco.logradouro' />

	</div>
</div>
<div class="form-group label-floating">
	<label for="pontoReferencia" class="control-label">Referência</label>
	<div class="input-group">
		<form:input path='endereco.pontoReferencia' type='text' placeholder="Referência" class="form-control"/>
		<form:errors path='endereco.pontoReferencia' />

	</div>
</div>
<div class="form-group label-floating">
	<label for="numero" class="control-label">Número</label>
	<div class="input-group">
		<form:input path='endereco.numero' type='text' placeholder="Número" class="form-control"/>
		<form:errors path='endereco.numero' />

	</div>
</div>
<div class="form-group label-floating">
	<label for="complemento" class="control-label">Complemento</label>
	<div class="input-group">
		<form:input path='endereco.complemento' type='text' placeholder="Complemento" class="form-control"/>
		<form:errors path='endereco.complemento' />

	</div>
</div>
<div class="form-group label-floating">
	<label for="bairro.id">Bairro</label>
	<div class="input-group" class="control-label">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path='endereco.bairro.id' items='${bairroList}'
			itemValue='id' itemLabel='nome'>
		</form:select>
		<form:errors path='endereco.bairro.id' />

	</div>
</div>

<!-- ======================= FIM DO ENDEREÇO ======================= -->

<!-- <div class="form-group"> -->
<!-- 	<label for="telefone.id">telefone.id</label> -->
<!-- 	<div class="input-group"> -->
<!-- 		<span class="input-group-addon"><i -->
<!-- 			class="glyphicon glyphicon-unchecked"></i></span> -->
<%-- 		<form:select path='telefone.id' items='${telefoneList}' itemValue='id' --%>
<%-- 			itemLabel='telefone'> --%>
<%-- 		</form:select> --%>
<%-- 		<form:errors path='telefone.id' /> --%>

<!-- 	</div> -->
<!-- </div> -->