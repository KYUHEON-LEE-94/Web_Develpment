// 정규표현식 활용
// 전화번호
(function () {
  let telephone = 
  `02-777-88888
  02-7777-88888
  010 333 4444
  010.3333.4444
  010.3333.444
  010-1234-5678`;
  let regex = /\d{2,3}[- .]\d{3,4}[- .]\d{4}/gm;
  let result = telephone.match(regex);
  console.dir(result);
})();

// 유효성 검증 함수
function isTelephone(telephone){
  let regex = /\d{2,3}[- .]\d{3,4}[- .]\d{4}/gm;
  return regex.test(telephone);
}
const ok = isTelephone('010.3333.4455');
console.log(ok);

// 이메일
(function () {
  let email = 
  `bangry313@gmail.com
  bangry@daum.net
  bangry313@some.co.kr
  bangry-313@some.co.kr
  bangry+313@some.co.kr
  namoo.bangry@some.co.kr`;
  let regex = /[a-zA-Z0-9._+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+/gm;
  let result = email.match(regex);
  console.dir(result);
})();

// URL
(function () {
  let url = 
  `https://www.naver.com
  https://en.wikipedia.org/wiki/Regular_expression
  https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Regular_Expressions
  https://jsbin.com/?html,output
  https://codepen.io/
  https://www.youtu.be/-ZClicWm0zM`;

  let regex = /https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)/gm;
  let result = url.match(regex);
  console.dir(result);
})();