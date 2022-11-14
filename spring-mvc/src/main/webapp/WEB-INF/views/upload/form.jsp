<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>파일 업로드</title>
</head>
<body>
  <h2>Spring MVC 파일 업로드</h2>
  <form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="uploadfile"><br> <input
      type="text" name="uploader" placeholder="업로더"><br>
    <button type="submit">업로드</button>
  </form>
</body>
</html>