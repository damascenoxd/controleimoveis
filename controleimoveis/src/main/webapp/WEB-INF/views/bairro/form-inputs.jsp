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
          <label for="zona">zona</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='zona' type='text'/>
<form:errors path='zona'/>

          </div>
        </div>
        <div class="form-group">
          <label for="populacao">populacao</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='populacao' type='text'/>
<form:errors path='populacao'/>

          </div>
        </div>
        <div class="form-group">
          <label for="cidade.id">cidade.id</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:select path='cidade.id' items='${cidadeList}' itemValue='id' itemLabel='nome'>
</form:select>
<form:errors path='cidade.id'/>

          </div>
        </div>
