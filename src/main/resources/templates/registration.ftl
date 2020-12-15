<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <form method="post">
        <input type="hidden" name="id"
               value="<#if user?? && user.id??>${user.id}</#if>"/>
        <input type="text" name="username" placeholder="username"
               class="form-control ${(usernameError??)?string('is-invalid', '')}"
               value="<#if user?? && user.username??>${user.username}</#if>"/>
        <#if usernameError??>
            <div class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
        <input type="password" name="password" placeholder="password"
               class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
        <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
        <input type="password" name="passwordConfirm" placeholder="Confirm your password"
               class="form-control ${(passwordConfirmError??)?string('is-invalid', '')}"/>
        <#if passwordConfirmError??>
            <div class="invalid-feedback">
                ${passwordConfirmError}
            </div>
        </#if>
        <input type="email" name="email" placeholder="email"
               class="form-control ${(emailError??)?string('is-invalid', '')}"
               value="<#if user?? && user.email??>${user.email}</#if>"/>
        <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
        </#if>
        <button type="submit">Registration</button>
    </form>

</@pt.page>