<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>



<petclinic:layout pageName="causas">
    <h2>Causas</h2>

    <table id="causasTable" class="table table-striped">
        <thead>
        <tr>

            <th>Nombre</th>
            <th>Descripción</th>
            <th>Oranización</th>
            <th>Objetivo</th>
            <th>Alcanzado</th>
            
             <sec:authorize access="hasAuthority('owner')">
            <th>Donar</th>
            </sec:authorize>

        </tr>
        </thead>
        
        <tbody>
        <c:forEach items="${causas}" var="causa">
            <tr>
                <td>
                	 <spring:url value="/causas/{causaId}" var="causaUrl">
                        <spring:param name="causaId" value="${causa.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(causaUrl)}"><c:out value="${causa.nombre}"/></a>
                
                </td>
                <td>
                    <c:out value="${causa.descripcion}"/>
                </td>
                <td>
                    <c:out value="${causa.organizacion}"/>
                </td>
                <td>
                    <c:out value="${causa.num}"/>
                </td> 
                
                <td>
                    <c:out value="${causa.totalBudget}"/>
                </td> 
                
                 <sec:authorize access="hasAuthority('owner')">
                <td>

                	 <spring:url value="/donations/{causaId}/new" var="donationUrl">
                        <spring:param name="causaId" value="${causa.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(donationUrl)}">Añadir Donación</a>
                </td>
                </sec:authorize>
                
            </tr>
            
		</c:forEach>
		</tbody>
    </table>
    
    <sec:authorize access="hasAuthority('owner')">
		<a class="btn btn-default" href='<spring:url value="/causas/new" htmlEscape="true"/>'>Añadir Causa</a>
	</sec:authorize>
</petclinic:layout>


	
