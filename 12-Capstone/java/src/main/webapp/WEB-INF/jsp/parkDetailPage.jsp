<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="container">
	<div class="park-detail-info row justify-content-around align-items-center">
		<div class="col-12 col-lg-5">
			<img src="img/parks/${ park.parkCode.toLowerCase() }.jpg"
			 	 alt="${ park.parkName }">
	 	</div>
	
		<div class="col-12 col-lg-6 mt-4 mt-lg-0">
			<h5>
				<c:out value="${ park.parkName }" />
			</h5>
		
			<p>
				<c:out value="${ park.parkDescription }" />
			</p>
		</div>
	</div>
	
	<div class="weather-info row justify-content-around align-items-center">
		<c:forEach var="weather" items="${ weatherForecast }">
			<c:set var="isToday" value="" />
			<c:set var="col" value="col-2" />
	
			<c:if test="${ weather.fiveDayForecastValue == 1 }">
				<c:set var="isToday" value="today" />
				<c:set var="col" value="col-3" />
			</c:if>
	
		   <div class="weather-wrapper ${ isToday } ${ col }">
		       <h5 class="text-center">Today</h5>
			   <img src="${ weather.createWeatherImage() }" alt="${ weather.forecast }" />
			   <p class="text-center high">High <c:out value="${ weather.high }" /></p>
			   <p class="text-center low">Low <c:out value="${ weather.low }" /></p>
			   <p class="text-center"><c:out value="${ weather.forecast }" /></p>
		   </div>
		</c:forEach>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />