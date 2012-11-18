<html>

	<head>
		<meta name="layout" content="main" />
	</head>
	
	<body>
            <g:link name="upload" controller="upload"  class="btn">Import data</g:link>
	
	        <g:if test="${email || facebookId}">
	            <div class="row">
	                <div class="span12">
	                    <legend>Profile</legend>
                        <span id="profile">${profile == null ? 'unknown profile' : profile}</span>
	                </div>
	            </div>
	        </g:if>
	
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
	                <ul id="actions">
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