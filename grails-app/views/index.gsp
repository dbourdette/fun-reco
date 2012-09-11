<!doctype html>
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
        <div class="span6">
            <legend>${profileCount} profiles in database<g:link controller="profiles" class="btn btn-primary pull-right">View</g:link></legend>
        </div>

        <div class="span6">
            <legend>${actionCount} actions in database<g:link controller="actions" class="btn btn-primary pull-right">View</g:link></legend>
        </div>

        <div class="span6">
            <legend>Registered Queries</legend>

            <ul>
                <g:each in="${queries}">
                    <li>
                        <g:set var="date"><g:formatDate date="${it.lastUsage}" format="HH:mm dd/MM/yyyy" /></g:set>
                        ${it.query} (used last at ${it.lastUsage ? date : 'unknown'})
                    </li>
                </g:each>
            </ul>
        </div>
     </div>
</div>
</body>
</html>
