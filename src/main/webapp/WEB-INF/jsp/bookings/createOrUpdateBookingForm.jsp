<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="bookings">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#fechaEntrada").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
                <script>
            $(function () {
                $("#fechaSalida").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
        <jsp:body>
    <h2>
        <c:if test="${booking['new']}">New </c:if> Booking
	</h2>
    <form:form modelAttribute="booking" class="form-horizontal" id="add-booking-form">
    
        <div class="form-group has-feedback">
            <petclinic:inputField label="Fecha de entrada" name="fechaEntrada"/>
            <petclinic:inputField label="Fecha de salida" name="fechaSalida"/>
            <petclinic:inputField label="Informacion adicional" name="info"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${owner['new']}">
                        <button class="btn btn-default" type="submit">Add Booking</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Booking</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
        </jsp:body>
</petclinic:layout>