<%--
  Created by IntelliJ IDEA.
  User: alliswell008
  Date: 2016/12/1
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h6>注册新账户</h6>

<form action="" method="post">
    <table class="">
        <tr>
            <td>账户ID:</td>
            <td><input type="text" id="account" name="" value=""/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" id="email" name="" value=""/></td>
        </tr>
        <tr>
            <td>显示名称:</td>
            <td><input type="text" id="name" name="" value=""/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" id="passwd" name="" value=""/></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="text" id="cfmpasswd" name="" value=""/></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" id="identifyCode" name="" value=""/></td>
        </tr>
        <tr>
            <td>验证码图片:</td>
            <td><input type="text" id="identifyImage" name="" value=""/></td>
        </tr>
        <tr>
            <td><input type="submit" id="signup" name="" value="确认并提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
