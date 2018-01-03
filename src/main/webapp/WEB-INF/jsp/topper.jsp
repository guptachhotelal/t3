<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>T3Test</title>
    </head>
    <body>
        <form id= "topper" name="topper" action="topper.htm" method="POST">
            <table>
                <tr>
                    <td>URL</td>
                    <td><input type="url" name="testURL" id="testURL" size="30" value="http://terriblytinytales.com/test.txt" readonly></td>
                </tr>
                <tr>
                    <td>Enter number</td>
                    <td><input type="number" name="num" id="num" size="30" min="0" max="500" value='<c:out value="${num}" />' pattern="\d+"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button value="Submit" id="btnSubmit" name="btnSubmit">Submit</button></td>
                </tr>
            </table>
        </form><br />
        <c:if test="${!empty viewMap}">
            <table style="border: 1px solid black; border-collapse: collapse;">
                <tr>
                    <th style="border: 1px solid black;">Sr. No.</th>
                    <th style="border: 1px solid black;">Word</th>
                    <th style="border: 1px solid black;">Frequency</th>
                </tr>
                <c:set var="counter" value="1" />
                <c:forEach items="${viewMap}" var="mapEntry">
                    <tr>
                        <td style="border: 1px solid black;"><c:out value="${counter}"/></td>
                        <td style="border: 1px solid black;"><c:out value="${mapEntry.key}"/></td>
                        <td style="border: 1px solid black;"><c:out value="${mapEntry.value}"/></td>
                    </tr>
                    <c:set var="counter" value="${counter+1}" />
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
