<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-sm bg-light">

    <!-- Links -->
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="/">Main page</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/registration">Registration</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/chat">Chat</a>
        </li>
        <#if isAdmin?? && isAdmin!>
            <li class="nav-item">
                <a class="nav-link" href="/users">Users</a>
            </li>
        </#if>
        </li>
        <#if isModerator?? && isModerator!>
            <li class="nav-item">
                <a class="nav-link" href="/userss">Users</a>
            </li>
        </#if>
        <#if isAdmin?? && isAdmin!>
            <li class="nav-item">
                <a class="nav-link" href="/messages">Message history</a>
            </li>
        </#if>
    </ul>
    <div class="navbar-text mr-3 text-info"><#if user??><a href="/user"></#if>${name}<#if user??></a></#if></div>
    <#if user??><div class="navbar-text mr-3 text-info"><@l.logout/></div></#if>


</nav>