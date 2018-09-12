
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="/styles/login.css"/>
</head>
<body>



<form class="form" action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <h2>Sign in</h2>

<#if error??>
    <div class="alert-danger">login or password entered incorrectly</div>
</#if>
    <label for="userName">Your name</label>
    <input id="userName" name="userName" type="text"/>

    <label for="password">Password</label>
    <input id="password" name="userPassword" type="password"/>

    <label for="remember-me">Remember me</label>
    <input type="checkbox" id="remember-me" name="remember-me">

    <input value="Sign in" type="submit"/>

    <div class="div_a"><a href="/signUp">Create your account</a></div>
</form>

</body>
</html>
