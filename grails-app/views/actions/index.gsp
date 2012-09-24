<html>

	<head>
	    <meta name="layout" content="main" />
	</head>
	
	<body>
	
        <div class="row">
            <div class="span12">
                <legend>All actions</legend>
                <g:paginate controller="actions" total="${total}" />
                <ul>
                    <g:each var="action" in="${actions}">
                        <li>
                            <g:formatAction action="${action}" />
                        </li>
                    </g:each>
                </ul>
            </div>
        </div>
        
	</body>
	
</html>