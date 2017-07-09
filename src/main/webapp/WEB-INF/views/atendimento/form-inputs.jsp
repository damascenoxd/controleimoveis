<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	        <div class="form-group">
          <label for="cliente.id">cliente.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='cliente.id' items='${clienteList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='cliente.id'/>

          </div>
        </div>
        <div class="form-group">
          <label for="tipo_contato.id">tipo_contato.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='tipo_contato.id' items='${tipoContatoList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='tipo_contato.id'/>

          </div>
        </div>
        <div class="form-group">
          <label for="tipo_pretensao.id">tipo_pretensao.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='tipo_pretensao.id' items='${tipoPretensaoList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='tipo_pretensao.id'/>

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
          <label for="endereco.id">endereco.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='endereco.id' items='${enderecoList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='endereco.id'/>

          </div>
        </div>
        <div class="form-group">
          <label for="dataAtendimento">dataAtendimento</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='dataAtendimento' type='text'/>
<form:errors path='dataAtendimento'/>

          </div>
        </div>
        <div class="form-group">
          <label for="valorPretensao">valorPretensao</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='valorPretensao' type='text'/>
<form:errors path='valorPretensao'/>

          </div>
        </div>
        <div class="form-group">
          <label for="valorProposta">valorProposta</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='valorProposta' type='text'/>
<form:errors path='valorProposta'/>

          </div>
        </div>
        <div class="form-group">
          <label for="observacao">observacao</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='observacao' type='text'/>
<form:errors path='observacao'/>

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
