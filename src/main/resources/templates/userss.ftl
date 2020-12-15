<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <h1>List of users</h1>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list userss as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <#if user.isMuted() == false>
                        <a href="/userss/mute/${user.id}">mute</a>
                    </#if>
                    <#if user.isMuted() == true>
                        <a href="/userss/unmute/${user.id}">unmute</a>
                    </#if>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@pt.page>