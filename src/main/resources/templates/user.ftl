<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

<@pt.page>
    <h3>Your account:</h3>
    <p></p>
    <p>Username: ${user.username}</p>
    <p>E-mail: ${user.email}  <a href="/user/email"><button class="btn btn-info">Change email</button></a></p>
    <p><a href="/user/password">Change Password</a></p>
    <p><a href="/user/username">Change nickname</a></p>
</@pt.page>