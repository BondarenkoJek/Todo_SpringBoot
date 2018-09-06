<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/styles/reg.css"/>
</head>
<body>

<form class="form" action="/create" method="post">
    <h2>Create account</h2>
    <label for="userName">Login</label>
    <input id="userName" name="userName" type="text"/>

    <label for="email">Email</label>
    <input id="email" name="email" type="email"/>

    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>


    <input value="Create your account" type="submit">

    <div class="div_a">Already have an account?<a href="/">Sign in</a></div>
</form>

</body>
</html>
