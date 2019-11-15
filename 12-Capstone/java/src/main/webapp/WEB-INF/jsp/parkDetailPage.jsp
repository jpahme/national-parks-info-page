<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="container">
	<div class="park-detail-info row justify-content-around align-items-center">
		<div class="col-12 col-lg-5">
			<img src="img/parks/${ park.parkCode.toLowerCase() }.jpg"
			 	 alt="${ park.parkName }">
	 	</div>
	
		<div class="col-12 col-lg-6 mt-4 mt-lg-0">
			<h5>
				<c:out value="${ park.parkName }" /> (<c:out value="${ park.parkCode }" />)
			</h5>
		
			<p>
				<c:out value="${ park.parkDescription }" />
			</p>
		</div>
	</div>
	
	<div class="park-info-table row justify-content-around align-items-center">
		<table class="col-12 col-md-5">
		   <tr>
		       <th class="text-center">State</th>
		       <th class="text-center">Acreage</th>
		       <th class="text-center">Elevation</th>
		       <th class="text-center">Miles of Trail</th>
		       <th class="text-center">Number of Campsites</th>
		       <th class="text-center">Climate</th>
		       <th class="text-center">Year Founded</th>
		       <th class="text-center">Annual Visitor Count</th>
		       <th class="text-center">Entry Fee</th>
		       <th class="text-center">Number of Animal Species</th>
		   </tr>
		   <tr>
		       <td align="center"><c:out value="${ park.state }" /></td>
		       <td align="center"><c:out value="${ park.acreage }" /></td>
		       <td align="center"><c:out value="${ park.elevationInFeet }" /> feet</td>
		       <td align="center"><c:out value="${ park.milesOfTrail }" /> miles</td>
		       <td align="center"><c:out value="${ park.numberOfCampSites }" /> </td>
		       <td align="center"><c:out value="${ park.climate }" /></td>
		       <td align="center"><c:out value="${ park.yearFounded }" /></td>
		       <td align="center"><c:out value="${ park.annualVisitorCount }" /></td>
		       <td align="center">$ <c:out value="${ park.entryFee }" /></td>
		       <td align="center"><c:out value="${ park.numberOfAnimalSpecies }" /></td>
		   </tr>
		</table>
		
		<div class="col-12 col-md-6">
			<h5 class="text-justify">"<c:out value="${ park.inspirationalQuote }" />"</h5>
		    <p class="text-right">- <c:out value="${ park.inspirationalQuoteSource }" /></p>
		</div>
	</div>
	
	<div class="weather-info">
	
	    <h4 class="text-center">Weather for the Next 5 Days</h4>
	    <form action="parkdetail" id="celcius" style="display:none" method="POST">
	       <input type="hidden" name="parkCode" value="${ park.parkCode }" />
	       <input type="hidden" name="temperatureScale" value="celcius" />
	    </form>
	    
	    <form action="parkdetail" id="fahrenheit" style="display:none" method="POST">
	       <input type="hidden" name="parkCode" value="${ park.parkCode }" />
	       <input type="hidden" name="temperatureScale" value="fahrenheit" />
	    </form>
	    
	    <div class="text-center">
	        <button class="btn btn-info" type="submit" form="celcius">Celcius</button>
	        <button class="btn btn-info" type="submit" form="fahrenheit">Fahrenheit</button>
        </div>
        
		<div class="row justify-content-around align-items-center">
			<c:forEach var="weather" items="${ weatherForecast }">
				<c:set var="isToday" value="" />
				<c:set var="col" value="col-2" />
		
				<c:if test="${ weather.fiveDayForecastValue == 1 }">
					<c:set var="isToday" value="today" />
					<c:set var="col" value="col-3" />
				</c:if>
		
			   <div class="weather-wrapper ${ isToday } ${ col }">
				       <h5 class="text-center">Today</h5>
				       <p class="text-center">${ weather.createDate() }</p>
				       <img src="${ weather.createWeatherImage() }" 
				            alt="${ weather.forecast }" />
				            
					   <c:set var="tempHigh" value="${ weather.high } &deg;F" />
					   <c:set var="tempLow"  value="${ weather.low } &deg;F" />
	
				       <c:if test="${ temperatureScale == 'celcius' }">
				           <fmt:parseNumber var = "intHigh" 
				                    integerOnly = "true" 
				                           type = "number" 
				                          value = "${ (weather.high - 32) * (5 / 9) }" />
				                          
				           <fmt:parseNumber var = "intLow" 
	                                integerOnly = "true" 
	                                       type = "number" 
	                                      value = "${ (weather.low - 32) * (5 / 9) }" />  
	                                                      
				           <c:set var="tempHigh" value="${ intHigh } &deg;C" />
	                       <c:set var="tempLow"  value="${ intLow } &deg;C" />
				       </c:if>
					   
	                   <p class="text-center high text-danger">High ${ tempHigh }</p>
	                   <p class="text-center low text-primary">Low ${ tempLow }</p>
					   <p class="text-center"><c:out value="${ weather.forecast }" /></p>

				       <h6 class="text-center text-info">${ weather.createClimateRecommendation() }</h6>
				       <c:forEach var="tempRecommendation" items="${ weather.createTemperatureRecommendations() }">
				           <h6 class="text-center text-info"><c:out value="${ tempRecommendation }" /></h6>
				       </c:forEach>
			   </div>
			</c:forEach>
		</div>
		
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />