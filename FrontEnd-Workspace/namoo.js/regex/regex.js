// RegExp 주요 함수
(function () {
  let message ='Hello Java world, JavaScript';
  let regex = new RegExp("Java"); //-> ., $등을 여기서 사용
  let result = regex.exec(message); //->exec: 검색을 실행 , 거의 안씀..
  console.dir(result);
  console.log(regex.test(message)); // *test -> 존재하느냐? boolean
})();

// 배열 반환
(function () {
  let message ='HelloJava world, JavaScript';
  let regex = /Java/gm; //-> global: 전체 , m:multiline
  let result = message.match(regex); //>> math: 일치하는 값들을 배열로 반환해줌
  console.dir(result);
})();

// 인덱스 반환
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /Java/gm;
  let result = message.search(regex); //검색원하는 문장.search(regex) -> 인덱스값 반환
  console.dir(result);
})();

// 문자열 교체
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /Java/gm;
  let result = message.replace(regex, 'JavaScript');
  console.dir(result);
})();

// 문자열 분리하여 배열 반환
(function () {
  let message ='Hello world, Java JavaScript';
  let regex = /,/gm;
  let result = message.split(regex);
  console.dir(result);
})();
