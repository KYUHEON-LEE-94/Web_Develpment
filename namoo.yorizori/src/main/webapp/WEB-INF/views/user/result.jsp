<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>요리조리 요리책</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
  rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body>
  <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/Include/nav.jsp" />
  <!-- Navigation End-->


  <!-- Section-->
  <section class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">

          <div class="page-header">
            <h2 id="container">회원 가입을 축하합니다.</h2>
          </div>

          <div class="well">
            <p>가입한 내용은 아래와 같습니다.</p>
            <form class="form-horizontal" action="/user/regist.do" method="post">
              <fieldset>
                <div class="form-group">
                  <label class="col-lg-2 control-label">아이디</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" name="id" readonly disabled value="${param.id}">
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-lg-2 control-label">이름</label>

                  <div class="col-lg-10">
                    <input type="text" class="form-control" name="name" readonly disabled value="${param.name}"> 
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">이메일</label>

                  <div class="col-lg-10">
                    <input type="email" class="form-control" name="email" readonly disabled value="${param.email}">
                  </div>
                </div>

                <div class="form-group">
                  <div class="col-lg-10 col-lg-offset-2">
                    <button type="button" class="btn btn-primary" onclick="location.href='/'">확인</button>
                  </div>
                </div>
              </fieldset>
            </form>
          </div>
        </div>
      </div>

    </div>
  </section>
  <!-- Footer-->
  <jsp:include page="/WEB-INF/views/Include/footer.jsp" />
  <!-- Footer End-->
  <!-- Bootstrap core JS-->
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
</body>
</html>
