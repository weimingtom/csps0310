<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>南昌城市配送平台</title>
    <script src="/js/jquery-1.12.1.min.js"></script>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div id="loginForm">
        <form id="theFrom" action="/login" method="post">
            <div class="form-item">
                <h6>物流团购管理后台</h6>
            </div>
            <div class="form-item">
                <span class="field-title">登录名:</span>
                <input type="text" name="j_username" value="" class="field-input" />
            </div>
            <div class="form-item">
                <span class="field-title">密&nbsp;&nbsp;&nbsp;码:</span>
                <input type="password" name="j_password" value="" class="field-input" />
            </div>
            <div class="form-item">
                <input type="submit" value="登录" style="height: 100px;;" />
            </div>
        </form>
    </div>
</body>

</html>
