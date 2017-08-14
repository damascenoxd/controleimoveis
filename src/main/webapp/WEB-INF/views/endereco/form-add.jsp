<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>

	<jsp:attribute name="extraStyles">
      <link rel="stylesheet"
			href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
   </jsp:attribute>
	<jsp:attribute name="extraScripts">
      <script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
   </jsp:attribute>
   
	<jsp:body>
	
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<div class="container min-container">
					<h2 class="basic-title">Add</h2>
					<form:form role="form" cssClass="well" commandName="endereco"
							servletRelativeAction="/endereco" method="POST">
						<%@include file="form-inputs.jsp"%>
						<button type="submit" class="btn btn-primary">Submit</button>

					</form:form>
				</div>
			</div>
		</div>
	</div>
	</jsp:body>
</template:admin>
