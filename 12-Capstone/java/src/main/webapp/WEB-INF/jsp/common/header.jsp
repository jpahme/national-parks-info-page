<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet" />
	<link rel="stylesheet"
		 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous" />
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
           rel="stylesheet" 
     integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" 
   crossorigin="anonymous" />
	<link rel="stylesheet" type="text/css" href="css/site.css" />
	<link rel="icon" href="<c:url value="img/favicon.png" />" type="image/gif" />
	<title>National Park Geek</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="<c:url value="/" />">
		  <img src="img/logo.png" class="logo" alt="logo" />
		</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item">
				    <a class="nav-link" href="<c:url value="/" />">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/survey" />">Survey</a>
				</li>
				<li class="nav-item">
                    <a class="nav-link" href="<c:url value="/favoriteparks" />">Favorite Parks</a>
                </li>
                <li>
                    <a class="nav-link" 
                        href="<c:url value="https://heguanelvis.github.io/NationalParkGeek/doc/"/>"
                      target="_blank">Web Doc</a>
                </li>
			</ul>
		</div>
	</nav>