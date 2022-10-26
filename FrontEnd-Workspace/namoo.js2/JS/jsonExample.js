let name  ='이규헌';
let age = 30;
let jsonName = JSON.stringify(name); //Json표기로 바꾸는 중..
let jsonAge = JSON.stringify(age);
console.log(jsonName, jsonAge);
console.log(typeof jsonAge);

let user = {
    name:'이규헌',
    age:30,
    weight: null,
    birthday: new Date(),
    toString: function(){
        console.log(`${this.name}, 나이: ${this.age}`);
    },
};

let jsonUser = JSON.stringify(user);
console.log(jsonUser); //객체가 전부 string타입으로 변환됨, //함수는 직렬화 대상에저 제외됨
// -> 함수를 서버쪽으로 보내야할 이유가 없기 때문에

let languages = ['java', 'css', 'js']
let jsonLanguages = JSON.stringify(languages);
console.log(jsonLanguages);

jsonUser = JSON.stringify(user,["name", "age"]); //user객체의 name과 age만 직렬화 할때의 문법
console.log(jsonUser);

//callback함수를 써서 직렬화와 동시에 원하는 값을 넣는 방법
//JSON.stringify(객체, 함수(키,밸류){ return 내용 })
jsonUser = JSON.stringify(user, function(key, value){
    return key === "weight"? 50:value;
}) // key가 weight이면 50! 아니면 value값 그대로 유지

console.log(jsonUser);

//------------역직렬화-------------
console.log("------------역직렬화----------");
let stringStudnt = '{"ssn":"10","name":"이구구"}'
let student = JSON.parse(stringStudnt);
console.log(student);
console.dir(student);
console.log(typeof student);

//APT DOM 사용
//document.querySelector('body').appendChild(document.createElement('h2')).textContent //=student.name;

//직렬화 하면서 빠졌던 function기능을 역직렬화하면서 다시 넣고싶다!


let jsonUser2 = JSON.stringify(user);
user = JSON.parse(jsonUser2)
console.dir(user);

user = JSON.parse(jsonUser2, function(key, value){
    return key === "birthday"? new Date(value): value;
})

console.dir(user);

function loginUser(id, wd , onSucess, OnErro){}