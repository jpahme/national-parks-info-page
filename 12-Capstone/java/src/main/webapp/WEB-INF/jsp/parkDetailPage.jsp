<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="container">
	<div class="row">
		<div class="col-6">
			<img src="img/parks/${ park.parkCode.toLowerCase() }.jpg"
			 	 alt="${ park.parkName }">
	 	</div>
	
		<div class="col-6">
			<h5>
				<c:out value="${ park.parkName }" />
			</h5>
		
			<p>
				<c:out value="${ park.parkDescription }" />
			</p>
		</div>
	</div>
	
	<div class="row">
		<c:forEach var="weather" items="${ weatherForecast }">
			<c:set var="isToday" value="" />
			<c:set var="col" value="col-2" />
	
			<c:if test="${ weather.fiveDayForecastValue == 1 }">
				<c:set var="isToday" value="today" />
				<c:set var="col" value="col-3" />
			</c:if>
	
		   <div class="weather-wrapper ${ isToday } ${ col }">
		       <p>Today</p>
			   <img src="${ weather.createWeatherImage() }" alt="${ weather.forecast }" />
			   <p>High <c:out value="${ weather.high }" /></p>
			   <p>Low <c:out value="${ weather.low }" /></p>
			   <p><c:out value="${ weather.forecast }" /></p>
		   </div>
		</c:forEach>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />