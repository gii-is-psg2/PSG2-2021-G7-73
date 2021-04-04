<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>


<petclinic:layout pageName="bookings">
	<h2>Información de la Reserva</h2>



	<c:forEach var="booking" items="${bookings}">
		<table class="table table-striped">

			<tr>
				<th>Fecha de entrada</th>
				<td><b><c:out value="${booking.fechaEntrada}" /></b></td>
			</tr>
			<tr>
				<th>Fecha de salida</th>
				<td><c:out value="${booking.fechaSalida}" /></td>
			</tr>
			<tr>
				<th>Información</th>
				<td><c:out value="${booking.info}" /></td>
			</tr>
			<%-- <tr>
			<th></th>
			<td><spring:url
					value="/bookings/{bookingId}/edit" var="visitUrl">
					<spring:param name="bookingId" value="${booking.id}" />
				</spring:url> <a href="${fn:escapeXml(visitUrl)}">Editar</a>
			</td>
			</tr>
			--%>
		</table>
	</c:forEach>
</petclinic:layout>
