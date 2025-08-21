<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="title" required="false" %>
<%@ attribute name="description" required="false" %>
<%@ attribute name="footer" required="false" %>
<%@ attribute name="cssClass" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cardCssClass" value="${not empty cssClass ? cssClass : ''}"/>
<c:set var="classes" value="card ${cardCssClass}"/>

<div class="${classes}">
    <c:if test="${not empty title}">
        <div class="card-header">
            <h5 class="card-title">${title}</h5>
        </div>
    </c:if>
    
    <c:if test="${not empty description}">
        <div class="card-body">
            <p class="card-text">${description}</p>
        </div>
    </c:if>
    
    <c:if test="${not empty footer}">
        <div class="card-footer">
            ${footer}
        </div>
    </c:if>
</div>
