<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="/">Yorizori Cookbook</a>
    <button class="navbar-toggler" type="button"
      data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
        <li class="nav-item"><a class="nav-link active"
          aria-current="page" href="/">홈</a></li>
        <li class="nav-item"><a class="nav-link" href="/cookbook/register.do">요리책
            등록</a></li>
        <li class="nav-item"><a class="nav-link" href="#">요리책 목록</a></li>
      </ul>

      <c:choose>
        <c:when test="${not empty cookie.loginid}">
          <div class="col-4">
            ${cookie.loginid.value}님 환영합니다.
            <button type="button" class="btn btn-danger"
              onclick="location.href='/user/login.do'">로그아웃</button>
          </div>
        </c:when>
        <c:when test="${empty cookie.loginid}">
          <c:if test="${empty cookie.saveid}">
            <form class="row row-cols-lg-auto g-3 align-items-center"
              method="post" action="user/login.do">
              <div class="col-12">
                <div class="form-check">
                  <input class="form-check-input" type="checkbox"
                    id="saveid" name="saveid" value="save"> <label
                    class="form-check-label" for="saveid">아이디저장</label>
                </div>
              </div>
              <div class="col-12">
                <input type="text" size="8" maxlength="8"
                  class="form-control" id="id" name="id"
                  placeholder="아이디">
              </div>
              <div class="col-12">
                <input type="password" size="8" maxlength="8"
                  class="form-control" id="passwd" name="passwd"
                  placeholder="비밀번호">
              </div>
              <div class="col-12">
                <button type="submit" class="btn btn-primary">로그인</button>
              </div>
              <div class="col-12">
                <a href="/user/regist.do" class="btn btn-warning">회원가입</a>
              </div>
            </form>
          </c:if>
          <c:if test="${not empty cookie.saveid}">
            <form class="row row-cols-lg-auto g-3 align-items-center"
              method="post" action="user/login.do">
              <div class="col-12">
                <div class="form-check">
                  <input class="form-check-input" type="checkbox"
                    id="saveid" name="saveid" value="save" checked>
                  <label class="form-check-label" for="saveid">아이디저장</label>
                </div>
              </div>
              <div class="col-12">
                <input type="text" size="8" maxlength="8"
                  class="form-control" id="id" name="id"
                  placeholder="아이디" value="${cookie.saveid.value}">
              </div>
              <div class="col-12">
                <input type="password" size="8" maxlength="8"
                  class="form-control" id="passwd" name="passwd"
                  placeholder="비밀번호" value="${sessionPasswd}">
              </div>
              <div class="col-12">
                <button type="submit" class="btn btn-primary">로그인</button>
              </div>
              <div class="col-12">
                <a href="/user/regist.do" class="btn btn-warning">회원가입</a>
              </div>
            </form>
          </c:if>
        </c:when>

      </c:choose>




    </div>
  </div>
</nav>