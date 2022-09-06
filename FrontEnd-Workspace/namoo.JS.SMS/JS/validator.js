// 유효성 검증 객체
let Validator = {};

/** 입력 여부 검증 */
Validator.isAvailable = function (value) {
  let regex = /^[a-zA-Z가-힣]+/gmi;
  return value != undefined && (value.trim().length > 0 && regex.test(value));
}

/** 전화번호 형식 검증 */
Validator.isTelephone = function (telephone) {
  let regex = /\d{2,3}[- .]\d{3,4}[- .]\d{4}/gm;
  return regex.test(telephone);
}
/**학번 형식 검색 */
Validator.isNumber = function (...ssn) {
  let regex = /\d{1,}/gm;
  let Check = regex.test(ssn)
  return Check
}
export { Validator };