<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
 
<div class="container">
    <h1>Favorite Parks Page</h1>
    <c:forEach var="favoritePark" items="${ favoriteParks }">
        <h1><c:out value="${ favoritePark.parkName }" /></h1>
        <p><c:out value="${ favoritePark.surveyCount }" /></p>
    </c:forEach>
</div>  

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>