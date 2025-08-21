<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="text" required="true" %>
<%@ attribute name="size" required="false" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="cssClass" required="false" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="onclick" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="btnSize" value="${not empty size ? size : 'md'}"/>
<c:set var="btnType" value="${not empty type ? type : 'button'}"/>
<c:set var="btnCssClass" value="${not empty cssClass ? cssClass : ''}"/>
<c:set var="btnDisabled" value="${disabled ne null ? disabled : false}"/>
<c:set var="btnOnClick" value="${not empty onclick ? onclick : ''}"/>
<c:set var="classes" value="styled-btn styled-btn-${btnSize} ${btnCssClass}"/>

<button type="${btnType}"
        class="${classes}"
        <c:if test="${btnDisabled}">disabled</c:if>
        <c:if test="${not empty btnOnClick}">onclick="${btnOnClick}"</c:if>
        role="button"
>${text}</button>
