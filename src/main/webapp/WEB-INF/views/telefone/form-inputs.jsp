<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	        <div class="form-group">
          <label for="telefone">telefone</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='telefone' type='text'/>
<form:errors path='telefone'/>

          </div>
        </div>
        <div class="form-group">
          <label for="operadora">operadora</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='operadora' type='text'/>
<form:errors path='operadora'/>

          </div>
        </div>
