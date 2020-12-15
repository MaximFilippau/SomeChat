<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isModerator = user.isModerator()
    isMuted = user.isMuted()
    currentUserId = user.getId()
    >
<#else>
    <#assign
    name = '<a href="/login">Login</a>'
    isAdmin = false
    isModerator = false
    isMuted = false
    currentUserId = -1
    >
</#if>