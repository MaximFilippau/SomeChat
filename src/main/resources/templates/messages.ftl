<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

<@pt.page>

    <h1>Message history:</h1>
    <table>
        <thead>
        <tr>
            <th>Content</th>
            <th>Sender</th>
            <th>id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list messages as message>
            <tr>
                <td>${message.content}</td>
                <td>${message.sender}</td>
                <td></td>
                <td><a href="messages/delete/${message.id}">delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@pt.page>