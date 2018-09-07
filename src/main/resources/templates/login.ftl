
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="/styles/login.css"/>
</head>
<body>



<form class="form" action="/authentication" method="post">
    <h2>Sign in</h2>

<#if error??>
    <div class="alert-danger">login or password entered incorrectly</div>
</#if>

    <label for="userName">Your name</label>
    <input id="userName" name="userName" type="text"/>

    <label for="password">Password</label>
    <input id="password" name="userPassword" type="password"/>


    <input value="Sign in" type="submit"/>

    <div class="div_a"><a href="/signUp">Create your account</a></div>
</form>

</body>
</html>
