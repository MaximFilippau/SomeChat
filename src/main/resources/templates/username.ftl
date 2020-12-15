<#import "parts/pageTemplate.ftl" as pt>
<#include "parts/security.ftl">

<@pt.page>
    <form method="post" action="/user/username">
        <input type="text" name="oldUsername" placeholder="Enter your old Username" class="form-control ${(oldUsernameError??)?string('is-invalid', '')}">
        <#if oldUsernameError??>
            <div class="invalid-feedback">
                ${oldUsernameError}
            </div>
        </#if>
        <input type="text" name="newUsername" placeholder="Enter your new Username" class="form-control ${(newUsernameError??)?string('is-invalid', '')}">
        <#if newUsernameError??>
            <div class="invalid-feedback">
                ${newUsernameError}
            </div>
        </#if>
        <input type="password" name="currentPassword" placeholder="Enter your Password" class="form-control ${(currentPasswordError??)?string('is-invalid', '')}">
        <#if confirmPasswordError??>
            <div class="invalid-feedback">
                ${currentPasswordError}
            </div>
        </#if>
        <button class="btn btn-info">Change</button>
    </form>
</@pt.page>