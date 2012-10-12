<html>

	<head>
		<meta name="layout" content="main" />
	</head>
	
	<body>
	        <g:if test="${email || facebookId}">
	            <div class="row">
	                <div class="span12">
	                    <legend>Profile</legend>
	                    ${profile == null ? 'unknown profile' : profile}
	                </div>
	            </div>
	        </g:if>
	
	        <div class="row">
	            <div class="span12">
	                <legend>Recommendations for ${profile == null ? 'all users' : profile.email}</legend>
	                <g:each var="recommendationEntry" in="${recommendation?.entries}">
	                    <h4>${recommendationEntry.query}</h4>
	                    <ul>
	                        <g:each var="recommendedObject" in="${recommendationEntry.objects}">
	                            <li>
	                                <g:formatRecommendation recommendedObject="${recommendedObject}" />
	                            </li>
	                        </g:each>
	                    </ul>
	                </g:each>
	            </div>
	        </div>
	
	        <g:if test="${profile}">
	            <div class="row">
	                <div class="span12">
	                    <legend>Friends</legend>
	                    <g:each var="friend" in="${friends}">
	                        <a href="?facebookId=${friend.facebookId}">${friend.name}</a>
	                    </g:each>
	                </div>
	            </div>
	        </g:if>
	
	        <div class="row">
	            <div class="span12">
	                <legend>
	                    Latests actions
	                    
	                    <g:link name="viewAll" controller="actions"  class="btn btn-warning pull-right">View all</g:link>
	                </legend>
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