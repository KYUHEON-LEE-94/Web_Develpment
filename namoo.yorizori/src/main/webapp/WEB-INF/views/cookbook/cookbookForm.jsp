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

					<div class="col-auto h2">요리책 등록</div>
					<!-- cookbook Form -->
					<form action="/cookbook/register.do" method="post">
						<div class="row mb-3">
							<label for="book_name" class="col-sm-2 col-form-label">요리책명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="book_name" name="bookname">
							</div>
						</div>
						<div class="row mb-3">
							<label for="author" class="col-sm-2 col-form-label">등록자</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									value="${cookie.loginid.value}" disabled id="book_author">
                                  <!-- disabled상태로는 값을 받아올 수 없어서 hidden input으로 받아오기 -->
                   	            <input type="hidden" name="authorid" value="${cookie.loginid.value}">
							</div>
						</div>

						<div class="row mb-3">
							<label for="book_desc" class="col-sm-2 col-form-label">설명</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="book_desc" rows="5" name="bookdesc"></textarea>
							</div>
						</div>

						<div class="row mb-3">
							<div class="col-md-4">
								<button type="submit" class="btn btn-primary">목록</button>
							</div>

							<div class="col-md-4 offset-md-4" style="text-align: right;">
								<button type="submit" class="btn btn-primary">등록</button>
							</div>
						</div>
					</form>
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
