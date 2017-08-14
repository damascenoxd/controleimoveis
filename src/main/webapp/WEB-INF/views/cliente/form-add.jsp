<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>

	<jsp:body>
      <div class="main main-raised">
         <div class="section section-basic">
            <div class="container">
               <div class="title">
                  <h2>Novo Cliente</h2>
               </div>
      <form:form role="form" commandName="cliente"
						servletRelativeAction="/cliente" method="POST">
      	<%@include file="form-inputs.jsp"%>
        <button type="submit" class="btn btn-success">Salvar</button>
<!-- cssClass="well"  -->
      </form:form>	
    </div>
  </div>
  </div>
  </jsp:body>
</template:admin>
