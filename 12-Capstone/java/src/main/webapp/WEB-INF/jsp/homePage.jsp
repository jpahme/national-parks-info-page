<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4 text-center">National Park Geek</h1>
        <p class="lead text-center">Look up information about national parks and find your favorite park!</p>
    </div>
</div>
 
<div class="container">
    <div class="row d-flex-wrap justify-content-center">
        
        <c:forEach var="park" items="${ parks }">
            <div class="col-12 col-md-6 col-xl-4">
                <div class="flip-card mt-4 mb-2">
                
                    <div class="flip-card-inner">
                        <div class="flip-card-front">
                            <img src="img/parks/${ park.parkCode.toLowerCase() }.jpg" 
                                 alt="${ park.parkName }" />
                        </div>
                        
	                    <div class="flip-card-back">
	                        <h5><c:out value="${ park.parkName }"/></h5>
	                        <p><c:out value="${ park.parkDescription }"/></p>
	                        <c:url var="parkDetailUrl" value="parkdetail">
	                            <c:param name="parkCode" value="${ park.parkCode }" />
	                        </c:url>
	                        <a href="${ parkDetailUrl }" class="btn btn-outline-info">View Park Details</a>
	                    </div>
	                </div>
	                
                </div>
            </div>
        </c:forEach>
        
    </div>
</div>  

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>