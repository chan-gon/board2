<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sitemesh:write property="head" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Charlie</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">파일 업로드</a>
	        </li>
	        <li class="nav-item">
	          <li class="nav-item"><a class="nav-link" href="/community"><spring:message code="menu.community" /></a>
	          <li class="nav-item"><a class="nav-link" href="/notice"><spring:message code="menu.notice" /></a>
	          <li class="nav-item"><a class="nav-link" href="/faq"><spring:message code="menu.faq" /></a>
	          <li class="nav-item"><a class="nav-link" href="/inquiry"><spring:message code="menu.inquiry" /></a>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>

	<sitemesh:write property="body" />
</body>
</html>

