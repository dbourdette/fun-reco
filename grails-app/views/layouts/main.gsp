<!DOCTYPE HTML>

<html lang="en-US">

	<head>
	    <meta charset="UTF-8">
	    <link href="/css/bootstrap-combined.min.css" rel="stylesheet">
		<g:layoutHead />
	</head>
	
	<body>
	    <div class="container">
	    	
	    	<div class="navbar">
		        <div class="navbar-inner">
		            <a class="brand" href="/">Fun-reco</a>
		        </div>
		    </div>
	    
	        <div class="row">
	            <div class="span12 well">
	                <g:link controller="index" action="bootstrap" class="btn btn-warning pull-right">Reset DB</g:link>
	                <g:form controller="index" class="form-inline">
	                    email
	                    <input type="text" name="email" value="${email}" class="input-medium search-query input-xlarge">
	                    facebook id
	                    <input type="text" name="facebookId" value="${facebookId}" class="input-medium search-query input-xlarge">
	                    <button type="submit" class="btn">Search</button>
	                </g:form>
	            </div>
	        </div>
		<g:layoutBody />
	    </div>
	</body>
	
</html>