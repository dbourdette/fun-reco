${recommendedObject.object.id}
<g:each var="profile" in="${recommendedObject.by}">
    <a href="http://www.facebook.com/${profile.facebookId}" target="_blank">
        <img src="https://graph.facebook.com/${profile.facebookId}/picture" 
             alt="${profile.name}" height="24px" width="24px">
   </a>
</g:each>