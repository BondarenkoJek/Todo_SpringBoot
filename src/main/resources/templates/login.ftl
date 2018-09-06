
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="/styles/login.css"/>
</head>
<body>

<form class="form" action="/login" method="post">
    <h2>Sign in</h2>

    <label for="userName">Your name</label>
    <input id="userName" name="userName" type="text"/>

    <label for="password">Password</label>
    <input id="password" name="userPassword" type="password"/>


    <input value="Sign in" type="submit"/>

    <div class="div_a"><a href="/registration">Create your account</a></div>
</form>

</body>
</html>
