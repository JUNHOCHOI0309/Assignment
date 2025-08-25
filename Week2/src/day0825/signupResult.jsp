<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: skyho
  Date: 2025-08-25
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="getParameter/getParameterValues">
    <h3> result(getParameter/getParameterValues) </h3>
    <hr>
    <%
        System.out.println("getParameter/getParameterValues");
    %>
    <p> <strong>이름 : </strong> <%= request.getParameter("name")%></p>
    <p> <strong>email : </strong> <%= request.getParameter("email")%></p>
    <p> <strong>패스워드 : </strong> <%= request.getParameter("password")%></p>
    <p> <strong>성별 : </strong> <%= request.getParameter("gender")%></p>

    <p><strong>취미 : </strong>
        <%
            String[] hobby = request.getParameterValues("hobby");
            if( hobby != null) {
                for(int i=0; i < hobby.length; i++){
                    System.out.println(hobby[i]);
                    if(i< hobby.length-1) System.out.println(", ");
                }
            }else {
                System.out.println("없음.");
            }
        %>
    </p>

    <p><strong>기술 스택 : </strong>
        <%
            String[] skill = request.getParameterValues("skills");
            if(skill != null){
                for(int i =0; i< skill.length; i++){
                    System.out.print(skill[i]);
                    if(i< skill.length-1) System.out.print(", ");
                }
            } else {
                System.out.println("없음. ");
            }
            System.out.println();
        %>
    </p>
    <p><strong>약관 동의 여부 : </strong>
        <%
            String agree = request.getParameter("agree");
            if("yes".equals(agree)){
                System.out.println("동의함");
            } else{
                System.out.println("동의하지 않음.");
            }
        %>
    </p>
</div>

<div class="getParameterValues/Enumeration">
    <h3> result(getParameterValues/Enumeration) </h3>
    <hr>
    <%
        System.out.println("---getParameterValues/Enumeration---");
        Enumeration<String> param = request.getParameterNames();
        while(param.hasMoreElements()){
            String paramName = param.nextElement();
            String[] paramValue =request.getParameterValues(paramName);

            System.out.print(paramName + " : ");
            if(paramValue != null) {
                for(int i=0; i< paramValue.length; i++){
                    System.out.print(paramValue[i]);
                    if(i < paramValue.length - 1) System.out.print(", ");
                }
            }
            System.out.println();
        }
    %>
</div>
<div class="getParameterMap">
    <h3> result(getParameterMap) </h3>
    <hr>
    <%
        System.out.println("---getParameterMap---");
        Map<String, String[]> paramMap = request.getParameterMap();
        for(String key: paramMap.keySet()){
            System.out.print(key+" : ");
            String[] values = paramMap.get(key);
            if(values != null){
                for(int i =0; i < values.length; i++){
                    System.out.print(values[i]);
                    if(i < values.length -1 ) System.out.print(", ");
                }
            }
            System.out.println();
        }
    %>
</div>
</body>
</html>
