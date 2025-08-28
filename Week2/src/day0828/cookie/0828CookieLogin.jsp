<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
  <title>관리자</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"
          integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
          crossorigin="anonymous"></script>
  <%
    String id ="";
    Cookie [] cookies = request.getCookies();
    if(cookies != null){
      for(Cookie cook : cookies){
        if("id".equals(cook.getName())){
          id = cook.getValue();
          break;
        }
      }
    }
  %>
  <script>
    $(function (){
      $("input#checker").prop("checked", <%=id.length()!=0%>);
      $("img[title='LOGIN']").click(function (){
        $("form[name='login']").submit();
      })
    });
  </script>

  <link href="../../css/contents.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="login" method="post" action="0828CookieProcess.jsp" >
  <div id="loginWrapper">
    <div class="loginForm">
      <fieldset>
        <legend>관리자 시스템 로그인</legend>
        <dl>
          <dt><img src="../../img/common/th_id.gif" alt="아이디" /></dt>
          <dd><input type="text" name="id" class="text" id="user_id" value="<%=id%>" /></dd>

          <dt><img src="../../img/common/th_pw.gif" alt="비밀번호" /></dt>
          <dd><input type="password" name="pass" class="text" id="user_passwd" /></dd>
        </dl>
        <div class="btn">
          <img id="btnSubmit" src="../../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  />
        </div>

        <div class="saveId"><input type="checkbox" id="checker" name="checker"/>
          <img src="../../img/common/save_id.gif" alt="아이디 저장" />
        </div>
      </fieldset>
    </div>
  </div>
</form>
</body>
</html>