<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	        <div class="form-group">
          <label for="nome">nome</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='nome' type='text'/>
<form:errors path='nome'/>

          </div>
        </div>
        <div class="form-group">
          <label for="estado.id">estado.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='estado.id' items='${estadoList}' itemValue='id' itemLabel='sigla'>
</form:select>
<form:errors path='estado.id'/>

          </div>
        </div>
