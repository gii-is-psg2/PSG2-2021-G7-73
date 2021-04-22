<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="causas">
<jsp:body>
     <h2>
        <c:if test="${causa['new']}">Nueva </c:if> Causa
    </h2>
    <form:form modelAttribute="causa" class="form-horizontal" id="add-causa-form" action="/causas/save">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Nombre" name="nombre"/>
            <petclinic:inputField label="Descripción" name="descripcion"/>
            <petclinic:inputField label="Organización" name="organizacion"/>
            <petclinic:inputField label="Objetivo" name="num"/>            
            
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            	<c:choose>
            		<c:when test="${causa['new']}">
                        <button class="btn btn-default" type="submit">Añadir Causa</button>
                    </c:when>
           			
               	 </c:choose>
            </div>
        </div>
    </form:form>
    </jsp:body>
</petclinic:layout>