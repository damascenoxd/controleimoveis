<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
<jsp:body>
  <div>
    <div class ="container min-container">
      <h2 class="basic-title">List caracteristicaImovel</h2>
        <div class="well">
          <table class="table table-condensed table-bordered table-striped table-hover">
          		  <thead>
	                  <tr>
	                  	<td>id</td>
		                  	<td>qtdeQuartos</td>
		                  	<td>qtdeSuites</td>
		                  	<td>qtdeVagasGaragem</td>
		                  	<td>dce</td>
		                  	<td>especificacao</td>
		                  	<td>tamanho</td>
		                  	<td>condicoesPagamento</td>
		                  	<td>previsaoEntrega</td>
						<td>actions</td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
						<td><a href="<c:url value='/caracteristicaImovel'/>/${object.id}">${object.id}</a></td>
		                  	<td>${object.qtdeQuartos}</td>
		                  	<td>${object.qtdeSuites}</td>
		                  	<td>${object.qtdeVagasGaragem}</td>
		                  	<td>${object.dce}</td>
		                  	<td>${object.especificacao}</td>
		                  	<td>${object.tamanho}</td>
		                  	<td>${object.condicoesPagamento}</td>
		                  	<td>${object.previsaoEntrega}</td>
	                    <td><a href="<c:url value='/caracteristicaImovel/remove'/>/${object.id}">Remove</a></td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/caracteristicaImovel"/>
          <a href="<c:url value='/caracteristicaImovel/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Add New</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
