<!DOCTYPE HTML>

<html lang="en-US">

	<head>
	    <meta charset="UTF-8">
	    <r:require module="bootstrap"/>
	    <r:layoutResources/>
		<g:layoutHead />
	</head>
	
	<body>
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="/">Fun-reco</a>
					<g:form controller="index" class="navbar-form pull-left">
						<input type="text" name="email" value="${email}" class="span2"
							placeholder="Email">
						<input type="text" name="facebookId" value="${facebookId}"
							class="span2" placeholder="Facebook ID">
						<button type="submit" class="btn">Search</button>
					</g:form>
				</div>
			</div>

            <g:if test="${errorMessage != null}" >
                <div class="alert alert-error">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    <h4>Error</h4>
                    ${errorMessage}
                </div>
            </g:if>

            <g:layoutBody />
		</div>

        <r:layoutResources/>
	</body>

</html>