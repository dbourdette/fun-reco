<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="/">Fun-reco</a>
        </div>
    </div>

    <div class="row">
        <div class="span12">
        	<legend>All actions</legend>
            <ul>
               <g:each var="action" in="${actions}">
                   <li>
                       <g:formatDate value="${action.date}" pattern="dd/MM HH:mm" />
                       -
                       <a href="?facebookId=${action.profile.facebookId}">${action.profile.name}</a>
                       -
                       ${action.object}
                   </li>
               </g:each>
               <g:paginate next="Forward" prev="Back" controller="actions" total="${actionCount}" />
           </ul>
        </div>
    </div>
</div>
</body>
</html>