<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ attribute name="name" required="true" %>
<%@ attribute name="type" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="required" required="false" type="java.lang.Boolean" %>
<%@ attribute name="disabled" required="false" type="java.lang.Boolean" %>
<%@ attribute name="error" required="false" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="cssClass" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="inputType" value="${not empty type ? type : 'text'}"/>
<c:set var="inputPlaceholder" value="${not empty placeholder ? placeholder : ''}"/>
<c:set var="inputValue" value="${not empty value ? value : ''}"/>
<c:set var="inputRequired" value="${required ne null ? required : false}"/>
<c:set var="inputDisabled" value="${disabled ne null ? disabled : false}"/>
<c:set var="inputCssClass" value="${not empty cssClass ? cssClass : ''}"/>
<c:set var="hasError" value="${not empty error}"/>
<c:set var="classes" value="styled-input ${hasError ? 'styled-input-error' : ''} ${inputCssClass}"/>

<div class="styled-input-wrapper">
    <c:if test="${not empty label}">
        <label for="${name}" class="styled-input-label">
            ${label}
            <c:if test="${inputRequired}">
                <span class="required-indicator">*</span>
            </c:if>
        </label>
    </c:if>
    
    <input type="${inputType}"
           id="${name}"
           name="${name}"
           class="${classes}"
           <c:if test="${not empty inputPlaceholder}">placeholder="${inputPlaceholder}"</c:if>
           <c:if test="${not empty inputValue}">value="${inputValue}"</c:if>
           <c:if test="${inputRequired}">required</c:if>
           <c:if test="${inputDisabled}">disabled</c:if>
    />
    
    <c:if test="${hasError}">
        <div id="${name}_error" class="styled-input-error-message" role="alert">
            ${error}
        </div>
    </c:if>
</div>
