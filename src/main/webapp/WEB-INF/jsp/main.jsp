<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: alxev
  Date: 09.07.2017
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cafe</title>
    <meta charset="UTF-8">
    <title>Cafe JS</title>
    <spring:url value="/bootstrap/js/bootstrap.min.js" var="bjs"/>
    <spring:url value="/bootstrap/css/bootstrap.min.css" var="bcs"/>
    <spring:url value="/bootstrap/js/jquery-3.2.0.js" var="jq"/>
    <script src="${jq}"></script>
    <link rel="stylesheet" href="${bcs}">
    <script type="application/javascript" src="${bjs}"></script>
    <script type="application/javascript">
        function getJSONP(url, success) {

            var ud = '_' + +new Date,
                script = document.createElement('script'),
                head = document.getElementsByTagName('head')[0]
                    || document.documentElement;

            window[ud] = function(data) {
                head.removeChild(script);
                success && success(data);
            };

            script.src = url.replace('callback=?', 'callback=' + ud);
            head.appendChild(script);

        }
        function showArea() {
            getJSONP('/getArea/', function(data){
                console.log(data);
            });
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>Area name</th>
    </tr>
    <c:forEach items="${area}" var="area">
        <tr>
            <td><c:out value="${area.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<button type="button" class="btn btn-success btn-block" onclick="showArea()"></button>
<div class="col-md-3">
    <p id="areaList">

    </p>
</div>

</body>
</html>
