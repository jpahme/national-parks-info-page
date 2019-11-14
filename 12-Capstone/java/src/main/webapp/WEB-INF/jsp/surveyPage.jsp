<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div class="container survey">
	<form:form action="survey" method="POST" modelAttribute="survey">
	    <h1>Survey</h1>
	    <p>Please give us some feedback on your favorite national park and
	        let us know where you're from and your activity level. Thanks for
	        visiting our page!</p>
	    <hr />
	    <br />
	    
		<div class="form-group row">
			<form:label path="parkCode" cssClass="col-sm-3 col-form-label">Favorite National Park</form:label>
			<div class="col-sm-9">
				<form:select path="parkCode" cssClass="form-control">
					<c:forEach var="park" items="${ parks }">
						<option value="${ park.parkCode }">
							<c:out value="${ park.parkName }" />
						</option>
					</c:forEach>
				</form:select>
				<form:errors path="parkCode" cssClass="error" />
			</div>
		</div>

		<div class="form-group row">
			<form:label path="emailAddress" cssClass="col-sm-3 col-form-label">Your Email</form:label>
			<div class="col-sm-9">
				<form:input path="emailAddress" cssClass="form-control" />
				<form:errors path="emailAddress" cssClass="error" />
			</div>
		</div>

		<div class="form-group row">
			<form:label path="state" cssClass="col-sm-3 col-form-label">State of Residence</form:label>
			<div class="col-sm-9">
				<form:select path="state" cssClass="form-control">
					<option value="Alabama">Alabama</option>
					<option value="Alaska">Alaska</option>
					<option value="Arizona">Arizona</option>
					<option value="Arkansas">Arkansas</option>
					<option value="California">California</option>
					<option value="Colorado">Colorado</option>
					<option value="Connecticut">Connecticut</option>
					<option value="Delaware">Delaware</option>
					<option value="District of Columbia">District of Columbia</option>
					<option value="Florida">Florida</option>
					<option value="Georgia">Georgia</option>
					<option value="Guam">Guam</option>
					<option value="Hawaii">Hawaii</option>
					<option value="Idaho">Idaho</option>
					<option value="Illinois">Illinois</option>
					<option value="Indiana">Indiana</option>
					<option value="Iowa">Iowa</option>
					<option value="Kansas">Kansas</option>
					<option value="Kentucky">Kentucky</option>
					<option value="Louisiana">Louisiana</option>
					<option value="Maine">Maine</option>
					<option value="Maryland">Maryland</option>
					<option value="Massachusetts">Massachusetts</option>
					<option value="Michigan">Michigan</option>
					<option value="Minnesota">Minnesota</option>
					<option value="Mississippi">Mississippi</option>
					<option value="Missouri">Missouri</option>
					<option value="Montana">Montana</option>
					<option value="Nebraska">Nebraska</option>
					<option value="Nevada">Nevada</option>
					<option value="New Hampshire">New Hampshire</option>
					<option value="New Jersey">New Jersey</option>
					<option value="New Mexico">New Mexico</option>
					<option value="New York">New York</option>
					<option value="North Carolina">North Carolina</option>
					<option value="North Dakota">North Dakota</option>
					<option value="Northern Marianas Islands">Northern Marianas Islands</option>
					<option value="Ohio">Ohio</option>
					<option value="Oklahoma">Oklahoma</option>
					<option value="Oregon">Oregon</option>
					<option value="Pennsylvania">Pennsylvania</option>
					<option value="Puerto Rico">Puerto Rico</option>
					<option value="Rhode Island">Rhode Island</option>
					<option value="South Carolina">South Carolina</option>
					<option value="South Dakota">South Dakota</option>
					<option value="Tennessee">Tennessee</option>
					<option value="Texas">Texas</option>
					<option value="Utah">Utah</option>
					<option value="Vermont">Vermont</option>
					<option value="Virginia">Virginia</option>
					<option value="Virgin Islands">Virgin Islands</option>
					<option value="Washington">Washington</option>
					<option value="West Virginia">West Virginia</option>
					<option value="Wisconsin">Wisconsin</option>
					<option value="Wyoming">Wyoming</option>
				</form:select>
				<form:errors path="state" cssClass="error" />
			</div>
		</div>
		
	    <fieldset class="form-group">
	    	<div class="row">
	      		<legend class="col-form-label col-sm-3 pt-0">Activity Level</legend>
	      		<div class="col-sm-9">
	      		    <div>
						<form:radiobutton path="activityLevel" value="inactive" checked="checked" cssClass="radio" />
						<form:label path="activityLevel">Inactive</form:label>
						<form:errors path="activityLevel" cssClass="error" />
					</div>
					
					<div>
	                    <form:radiobutton path="activityLevel" value="sedentary" cssClass="radio" />
	                    <form:label path="activityLevel">Sedentary</form:label>
	                    <form:errors path="activityLevel" cssClass="error" />
                    </div>
                    
                    <div>
	                    <form:radiobutton path="activityLevel" value="active" cssClass="radio" />
	                    <form:label path="activityLevel">Active</form:label>
	                    <form:errors path="activityLevel" cssClass="error" />
                    </div>
                    
                    <div>
	                    <form:radiobutton path="activityLevel" value="extremely active" cssClass="radio" />
	                    <form:label path="activityLevel">Extremely Active</form:label>
	                    <form:errors path="activityLevel" cssClass="error" />
                    </div>
	      		</div>
	    	</div>
	  	</fieldset>
	  	
	  	<div class="text-center">
	  	    <input class="btn btn-info" type="submit" value="Submit" />
        </div>
	</form:form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />