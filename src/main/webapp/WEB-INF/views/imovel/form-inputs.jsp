<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	        <div class="form-group">
          <label for="modalidade">modalidade</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='modalidade' type='text'/>
<form:errors path='modalidade'/>

          </div>
        </div>
        <div class="form-group">
          <label for="finalidade">finalidade</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='finalidade' type='text'/>
<form:errors path='finalidade'/>

          </div>
        </div>
        <div class="form-group">
          <label for="nome">nome</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='nome' type='text'/>
<form:errors path='nome'/>

          </div>
        </div>
        <div class="form-group">
          <label for="valor">valor</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='valor' type='text'/>
<form:errors path='valor'/>

          </div>
        </div>
        <div class="form-group">
          <label for="endereco.id">endereco.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='endereco.id' items='${enderecoList}' itemValue='id' itemLabel='cep'>
</form:select>
<form:errors path='endereco.id'/>

          </div>
        </div>
        <div class="form-group">
          <label for="tipo_imovel.id">tipo_imovel.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='tipo_imovel.id' items='${tipoImovelList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='tipo_imovel.id'/>

          </div>
        </div>
        <div class="form-group">
          <label for="caracteristica_imovel.id">caracteristica_imovel.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='caracteristica_imovel.id' items='${caracteristicaImovelList}' itemValue='id' itemLabel='id'>
</form:select>
<form:errors path='caracteristica_imovel.id'/>

          </div>
        </div>
