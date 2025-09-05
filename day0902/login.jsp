<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Login Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=10" />
    <meta http-equiv="imagetoolbar" content="no" />
    <meta name="copyright" />
    <script
            src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script>
        $(function(){
            $("img#btnSubmit").click(function(e){
                e.preventDefault();
                const $f = $("form[name=login]");
                if(!$f.find("input[name=username]").val().trim()) alert("아이디를 입력하세요.");
                if(!$f.find("input[name=password]").val().trim()) alert("패스워드를 입력하세요.");
                $f.submit();
            });
        });
    </script>
    <link href="<c:url value='../../css/contents.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<form name="login" method="post"  action="${cpath}/front/0902member/login.jsp">
    <div id="loginWrapper">
        <div class="loginForm">
            <fieldset>
                <legend>시스템 로그인</legend>
                <dl>
                    <dt><img src="../../img/common/th_id.gif" alt="아이디" /></dt>
                    <dd><input type="text" name="username" class="text" id="user_id" /></dd>

                    <dt><img src="../../img/common/th_pw.gif" alt="비밀번호" /></dt>
                    <dd><input type="password" name="password" class="text" id="user_passwd" /></dd>
                </dl>
                <div class="btn">
                    <img id="btnSubmit" src="../../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  />
                </div>

                <div class="saveId"><input type="checkbox" id="checker" name="checker" />
                    <img src="../../img/common/save_id.gif" alt="아이디 저장" />
                </div>
                <div style="margin-top:10px";>
                    <a href="${cpath}/front/0902member/signup.jsp">회원가입</a>
                </div>
            </fieldset>
        </div>
    </div>
</form>
</body>
</html>