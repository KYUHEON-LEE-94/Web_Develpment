<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Yorizori</title>
<link
  href="https://getbootstrap.com/docs/5.2/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
  crossorigin="anonymous">

<!-- Favicons -->
<link rel="apple-touch-icon"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/apple-touch-icon.png"
  sizes="180x180">
<link rel="icon"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/favicon-32x32.png"
  sizes="32x32" type="image/png">
<link rel="icon"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/favicon-16x16.png"
  sizes="16x16" type="image/png">
<link rel="manifest"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/manifest.json">
<link rel="mask-icon"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/safari-pinned-tab.svg"
  color="#712cf9">
<link rel="icon"
  href="https://getbootstrap.com/docs/5.2/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.modal-sheet .modal-dialog {
	width: 500px;
	transition: bottom .75s ease-in-out;
}

.modal-sheet .modal-footer {
	padding-bottom: 2rem;
}

.modal-alert .modal-dialog {
	width: 500px;
}

.modal-tour .modal-dialog {
	width: 500px;
}
</style>

<!-- Custom styles for this template -->
<link
  href="https://getbootstrap.com/docs/5.2/examples/sign-in/signin.css"
  rel="stylesheet">
</head>
<body class="text-center">
  <div
    class="modal modal-sheet position-static d-block bg-secondary py-5"
    tabindex="-1" role="dialog" id="modalSheet">
    <div class="modal-dialog" role="document">
      <div class="modal-content rounded-4 shadow">
        <div class="modal-header border-bottom-0">
          <h5 class="modal-title">에러 메시지</h5>
          <a href="" class="btn-close"
            data-bs-dismiss="modal" aria-label="Close"></a>
        </div>
        <div class="modal-body py-2">
          <p>사용자 로그인에 실패하였습니다.로그인 정보를 확인하세요.</p>
        </div>
        <div class="modal-footer flex-column border-top-0">
          <a href="" class="btn btn-lg btn-primary w-40 mx-0 mb-2">확인</a>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
