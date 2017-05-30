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
          <label for="email">email</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='email' type='text'/>
<form:errors path='email'/>

          </div>
        </div>
        <div class="form-group">
          <label for="login">login</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='login' type='text'/>
<form:errors path='login'/>

          </div>
        </div>
        <div class="form-group">
          <label for="senha">senha</label>
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked"></i></span><form:input path='senha' type='text'/>
<form:errors path='senha'/>

          </div>
        </div>
