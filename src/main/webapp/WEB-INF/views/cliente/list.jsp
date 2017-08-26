<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
   <jsp:body>
      <div class="main main-raised">
         <div class="section section-basic">
            <div class="container">
               <div class="title">
                  <h2>Clientes</h2>
               </div>
               <table class="table">
                  <thead>
                     <tr>
                        <th>Nome</th>
                        <th>Data de Anivers�rio</th>
                        <th>Telefone</th>
                        <th>Estado Civil</th>
                        <th>Profiss�o</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Renda</th>
                        <th>A��es</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items='${findAll}' var='object'>
                        <tr>
                           <td>${object.nome}</td>
                           <td>${object.dataAniversario}</td>
                           <td>${object.telefone.telefone}</td>
                           <td>${object.estadoCivil}</td>
                           <td>${object.profissao}</td>
                           <td>${object.cpf}</td>
                           <td>${object.rg}</td>
                           <td>${object.renda}</td>
                           <td>
                              <a href="<c:url value='/cliente'/>/${object.id}"
                                 class="btn btn-warning btn-sm">Editar</a>
                              <a
                                 href="<c:url value='/cliente/remove'/>/${object.id}"
                                 class="btn btn-danger btn-sm">Excluir</a>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               <%-- 		  <template:paginationComponent paginatedList="${paginatedList}" --%>
               <%-- 						page="${param.page}" action="/cliente" /> --%>
               <a href="<c:url value='/cliente/form'/>"
                  class="btn btn-success"><span
                  class="glyphicon glyphicon-plus-sign"></span> Novo Cliente</a>
            </div>
         </div>
      </div>
   </jsp:body>
</template:admin>