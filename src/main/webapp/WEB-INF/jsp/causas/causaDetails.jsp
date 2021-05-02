<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>


<petclinic:layout pageName="causasDetails">
	<h2>Información de la Causa</h2>



		<table class="table table-striped">

			<tr>
				<th>Nombre</th>
				<td><b><c:out value="${causa.nombre}" /></b></td>
			</tr>
			<tr>
				<th>Descripción</th>
				<td><c:out value="${causa.descripcion}" /></td>
			</tr>
			<tr>
				<th>Organización</th>
				<td><c:out value="${causa.organizacion}" /></td>
			</tr>
			<tr>
				<th>Recaudación actual</th>
				<td><c:out value="${causa.totalBudget}" /></td>
			</tr>
			<tr>
				<th>Donaciones</th>
				<td><c:out value="${donation.amount}" /></td>
				<td><c:out value="${donation.client}" /></td>
			</tr>
			<tr>
				<th>Objetivo</th>
				<td><c:out value="${causa.num}" /></td>
			</tr>

		</table>
</petclinic:layout>