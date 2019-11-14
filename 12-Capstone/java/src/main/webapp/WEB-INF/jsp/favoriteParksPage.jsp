<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
 
<div class="container">

        <c:forEach var="favoritePark" items="${ favoriteParks }">
	        <div class="row justify-content-around align-items-center favorite-parks">
		        <div class="col-5">
	                <c:url var="parkDetailUrl" value="parkdetail">
	                    <c:param name="parkCode" value="${ favoritePark.parkCode }" />
	                </c:url>
			        <a href="${ parkDetailUrl }">
				        <img src="img/parks/${ favoritePark.parkCode.toLowerCase() }.jpg" 
				             alt="${ favoritePark.parkName }" />
			        </a>
		        </div>
		        
		        <div class="col-7">
			        <h5><c:out value="${ favoritePark.parkName }"/></h5>
			        <p><c:out value="${ favoritePark.parkDescription }"/></p>
			        <p>Number of votes: <c:out value="${ favoritePark.surveyCount }" /></p>
	            </div>
	        </div>
        </c:forEach>
        
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>