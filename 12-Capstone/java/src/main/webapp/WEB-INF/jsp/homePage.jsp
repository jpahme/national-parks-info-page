<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<div class="container">
    <c:forEach var="park" items="${ parks }">
    	<img src="img/parks/${ park.parkCode.toLowerCase() }.jpg">
    	<h4><c:out value="${ park.parkName }"/></h4>
    	<p><c:out value="${ park.parkDescription }"/></p>
    </c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>