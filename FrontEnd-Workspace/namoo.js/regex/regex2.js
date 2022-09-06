// 정규표현식 주요 패턴
// 일치하는 단어 검색
(function(){
  let message = 'Java, HTML, CSS, JavaScript, SQL';
  let regex = /Java/gm;
  let result = message.match(regex);
  console.dir(result);
})();

// 임의의 한 문자(.)
(function(){
  let message = 'Java, HTML, CSS, JavaScript, SQL';
  // let regex = /./gm;
  let regex = /a.a/gm;
  let result = message.match(regex);
  console.dir(result);
})();



// 수량 관련 메타문자(?, *, +)
(function(){
  let message = 'I love griy, gray, grey color gry graay graaaay';
  // let regex = /gra*y/gm; //*= 0이거나 그 이상
  // let regex = /gra+y/gm;
  // let regex = /gra?y/gm;
  // let regex = /gra{2}y/gm;
  // let regex = /gra{2,3}y/gm;
  let regex = /gra{2,}y/gm;
  let result = message.match(regex);
  console.dir(result);
})();


// OR 메타문자(|)
(function(){
  let message = 'Hi there, Nice to meet you. And Hello there and hi.';
  let regex = /Hi|Hello/gm; //대소문자 구분없이는 i를 추가 ->gmi
  let result = message.match(regex);
  console.dir(result);
})();



// 경계 관련 메타문자( ^, $)
(function(){
  let message = "JavaScript, HTML, CSS, JavaScript, Java\n"+
  "JavaScript, HTML, CSS, JavaScript, Java.";
  // let regex = /^Java/gm; //^: 각줄의 첫번째
  let regex = /^Java/g;
  let result = message.match(regex);
  console.dir(result);
})();


// 그룹 메타문자('()')
(function(){
  let message = 'HelloHelloHello Hellooo';
  // let regex = /Hello/gm;
  let regex = /(Hello){3}/gmi;
  let result = message.match(regex);
  console.dir(result);
})();


(function(){
  let message = 'I love griy, gray, grey color';
  let regex = /gr(i|a|e)y/gm;
  let result = message.match(regex);
  console.dir(result);
})();

console.clear();

// '[]' 문자클래스
(function(){
  let message = 'I love griy, gray, grey color';
  // let regex = /[ae]/gm; // a or e
  let regex = /gr[ae]y/gm;
  // let regex = /gr[a-z]y/gm; // 소문자 알파벳
  let result = message.match(regex);
  console.dir(result);
})();

(function(){
  let message = 'I love griy, gray, grey color';
  // let regex = /[a-zA-Z0-9]/gm;
  // let regex = /\S/gm; //공백 문자가 아닌 모든것을 의미한다.
  let regex = /[^a-zA-Z0-9]/gm; // [^] 부정
  let result = message.match(regex);
  console.dir(result);
})();


// 축약 문자 클래스(\w, \W, \d, \D, \s, \S)
(function(){
  let message = 'I love griy, gray, grey color 122';
  let regex = /\w/gm;  // /w 알파벳 + 숫자 + _ 중의 한 문자임을 의미한다.
  // let regex = /\s/gm;
  // let regex = /\S/gm;
  let result = message.match(regex);
  console.dir(result);
})();

console.clear();
// 축약 경계 문자클래스(\b, \B)
(function(){
  let message = 'Ya ya YaYaYa Ya';
  // let regex = /Ya/gm;  
  // let regex = /\bYa/gm; // 단어앞에서 쓰이는 Ya만 선택(Ya, Ya, Ya)
  let regex = /Ya\b/gm; // 단어뒤에서 쓰이는 문자만 선택(Ya, Ya, Ya)
  // let regex = /Ya\B/gm; // 단어뒤에서 쓰이지 않는 문자만 선택(Ya, Ya)
  let result = message.match(regex);
  console.dir(result);
})();


// 이스케이프 문자
(function(){
  let message = 'Java/HTML/CSS/JavaScript';
  // let regex = ///gm;
  let regex = /\//gm; // 이스케이스 문자 처리 
  // let result = message.match(regex);
  let result = message.split(regex);
  console.dir(result);
})();
