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
    <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/Include/nav.jsp" />
  <!-- Navigation End-->

  <!-- Section-->
  <section>
    <div class="container px-4 px-lg-5 mt-5">
      <div class="row">
        <div class="col h2 fw-bold">
          레시피 목록 <a href="/recipe/register.do" class="btn btn-md btn-warning">레시피 등록</a>
        </div>
      </div>
      <div class="row" style="height: 15px">
        <p class="col">
          <span class="fs-4 fw-bold text-warning bg-dark align-middle">[
            한식 요리책 ]</span> 한식 요리를 맛있게 만드는 방법을 설명합니다.
        </p>
      </div>
    </div>

    <div class="container px-4 px-lg-5 mt-5">
      <div
        class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <!-- 레시피 목록 -->
        
        <!-- 예시 카드 -->
        <div class="col mb-5">
          <div class="card h-70">
          <!-- 이미지를 보여주는 링크를 서블릿을 통해서 동적으로 보여주어야 한다. -->
            <img class="card-img-top" src="/recipe/image.do?recipeid=${reciepeid}" alt="${reciepeid}" />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
          </div>
        </div>

        <div class="col mb-5">
          <div class="card h-70">
            <img class="card-img-top" src="../assets/dj.jpg" alt="..." />
            <!-- 레시피 details-->
            <div class="card-body p-4">
              <div class="text-center">
                <!-- 레시피 name-->
                <h5 class="fw-bolder">된장찌개</h5>
                <!-- 요리시간, 난이도 -->
                (30분 / 난이도 : 상)
              </div>
            </div>
            <!-- Product actions-->
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
