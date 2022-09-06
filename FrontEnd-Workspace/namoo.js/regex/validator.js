// 유효성 검증 객체
let Validator = {};

/** 입력 여부 검증 */
Validator.isNull = function(value){
  return value == undefined;
}

/** 전화번호 형식 검증 */
Validator.isTelephone = function(telephone){
  let regex = /\d{2,3}[- .]\d{3,4}[- .]\d{4}/gm;
  return regex.test(telephone);
}
export {Validator};