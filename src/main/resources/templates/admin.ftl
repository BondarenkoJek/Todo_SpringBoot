<html>
<head>
    <title>TodoList</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>

<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Role</th>
            <th>State</th>
        </tr>
        <#list users as user>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.userRole}</td>
            <td>${user.userState}</td>
        </#list>
    </table>
</div>
</body>
</html>





