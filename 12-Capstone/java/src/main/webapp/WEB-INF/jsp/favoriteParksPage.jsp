<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
 
<div class="container">
    <div class="row d-flex-wrap justify-content-center">
        <c:forEach var="favoritePark" items="${ favoriteParks }">
            <div class="col-12 col-md-6 col-xl-4">
                <div class="flip-card mt-4 mb-2">
                    <div class="flip-card-inner">
                        <div class="flip-card-front">
                            <img src="img/parks/${ favoritePark.parkCode.toLowerCase() }.jpg" 
                                 alt="${ favoritePark.parkName }" />
                        </div>
	                    <div class="flip-card-back">
	                        <h5><c:out value="${ favoritePark.parkName }"/></h5>
	                        <p><c:out value="${ favoritePark.parkDescription }"/></p>
	                        <p>Number of votes: <c:out value="${ favoritePark.surveyCount }" /></p>
	                    </div>
	                </div>
                </div>
            </div>
        </c:forEach>
    </div>



<c:import url="/WEB-INF/jsp/common/footer.jsp"/>