<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="container">
	<img src="img/parks/${ park.parkCode.toLowerCase() }.jpg"
		 alt="${ park.parkName }">

	<h5>
		<c:out value="${ park.parkName }" />
	</h5>
	
	<p>
		<c:out value="${ park.parkDescription }" />
	</p>
	
	<c:forEach var="weather" items="${ weatherForecast }">
	   <p><c:out value="${ weather.forecast }" /></p>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />