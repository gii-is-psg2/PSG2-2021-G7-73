<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptions">
        <jsp:body>
    <h2>
        <c:if test="${adoption['new']}">Nueva </c:if> Adopcion
	</h2>
    <form:form modelAttribute="adoption" class="form-horizontal" id="add-adoption-form">
    
        <div class="form-group has-feedback">
            <petclinic:inputField label="Mascota" name="pet"/>
            <petclinic:inputField label="Antiguio propietario" name="previousOwner"/>
            <petclinic:inputField label="Propietario nuevo" name="actualOwner"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${adoption['new']}">
                        <button class="btn btn-default" type="submit">Nueva Adopcion</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Actualizar Adopcion</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
        </jsp:body>
</petclinic:layout>