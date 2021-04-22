<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="adoptions">
    <h2>Adoptions</h2>

    <table id="adoptionsTable" class="table table-striped"> 
        <thead>
        <tr>
            <th style="width: 50px;">Mascota</th>
            <th style="width: 100px;">Dueño Anterior</th>
            <th style="width: 120px">Dueño actual</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${adoptions}" var="adoption">
            <tr>
                <td>
                    <c:out value="${adoption.pet}"/>
                </td>
                <td>
                    <c:out value="${adoption.previousOwner.firstName}"/>
                </td>
                <td>
                    <c:out value="${adoption.actualOwner.firstName}"/>
                </td>

                
     
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
