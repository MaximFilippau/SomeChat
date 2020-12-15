<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

    <@pt.page>
<!DOCTYPE html>
    <html>
    <head>
        <link rel="stylesheet" href="/static/css/main.css" />

        <!-- https://cdnjs.com/libraries/sockjs-client -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>

        <!-- https://cdnjs.com/libraries/stomp.js/ -->
        <script  src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
        <title></title>

    </head>
    <body>
    <div id="chat-container">
        <div class="chat-header">
            <div class="user-container">
                <span id="username" >${user.username}</span>
            </div>
            <h3>It's just a weird chat, don't worry</h3>
        </div>

        <hr/>

        <div id="connecting">Connecting...</div>
        <ul id="messageArea">
        </ul>
        <form id="messageForm" name="messageForm">
            <div class="input-message">
                <#if isMuted == true>
                    <p>You are muted!</p>
                </#if>
                 <#if isMuted == false>
                <input type="text" id="message" autocomplete="off"
                       placeholder="Type a message..."/>
                <button type="submit">Send</button>
                 </#if>
            </div>
        </form>
    </div>

    <script src="/static/js/main.js"></script>

    </body>
    </html>
    </@pt.page>
