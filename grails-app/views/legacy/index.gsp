<html>
    <head>
        <meta name="layout" content="main" />
    </head>

    <body>
        <div class="row">
            <div class="span12">
                <legend>Reset DB</legend>
                <g:link controller="legacy" action="bootstrap" class="btn btn-warning">Reset DB</g:link>
            </div>
        </div>

        <div class="row">
            <div class="span12">
                <legend>Build recos for all profiles</legend>
                <g:link controller="legacy" action="build" class="btn btn-warning">Build recos</g:link>
            </div>
        </div>

        <div class="row">
            <div class="span12">
                <legend>Build recos for profile</legend>
                <g:form controller="legacy" action="buildForProfile" class="navbar-form pull-left">
                    <input type="text" name="email" value="" class="span2" placeholder="Email">
                    <input type="text" name="facebookId" value="" class="span2" placeholder="Facebook ID">
                    <button type="submit" class="btn btn-warning">Build recos</button>
                </g:form>
            </div>
        </div>
    </body>
</html>