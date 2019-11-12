<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div class="container">
    <div class="row">
	    <c:forEach var="park" items="${ parks }">
	        <div class="card-wrapper col-12 col-md-6 col-xl-4">
		    	<div class="card">
		    	    <img class="card-img-top" 
		    	         src="img/parks/${ park.parkCode.toLowerCase() }.jpg" 
		    	         alt="${ park.parkName }">
		    	         
		            <div class="card-body">
		                <h5 class="card-title"><c:out value="${ park.parkName }"/></h5>
		                <p class="card-text"><c:out value="${ park.parkDescription }"/></p>
		                
		                <c:url var="parkDetailUrl" value="parkdetail">
		                    <c:param name="parkCode" value="${ park.parkCode }" />
		                </c:url>
		                <a href="${ parkDetailUrl }" class="btn btn-primary">Park Details</a>
		            </div>
		        </div>
	        </div>
	    </c:forEach>
    </div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>