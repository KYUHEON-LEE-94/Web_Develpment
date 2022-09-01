// 애플리케이션 엔트리 포인트
import {Student} from "./Student.js"
import {StudentManager} from "./StudentManager.js"


//테스트 객체화
let person1 = new Student(1,"굿", 30, 20, 10);
let studentManager = new StudentManager();
studentManager.addStudent(person1);
studentManager.addStudent(new Student(1,"시험",10,20,30));
studentManager.addStudent(new Student(1,"야",10,20,30));

//---객체와 여기까지--
//변수 선언-----
let h2 = document.getElementById('title');
let accountOwnerBtn = document.getElementById('accountOwnerBtn');
let accountNumInput = document.getElementById('accountNumInput');

let classname = document.getElementById('classname');
let accountOwnerInput = document.getElementById('accountOwnerInput');
//변수 선언 여기까지..


let list = studentManager.listAll();
for (const student of list) {
    console.log(student.toString());
}

//h2 타이틀 적어주기
h2.innerText = Student.schoolname +" 학생 성적 관리"

console.log(accountOwnerInput.value);

accountOwnerInput.onchange = inputValueChange; 
function inputValueChange(){
    let inputValue = document.getElementById('accountOwnerInput').value;
    classname.textContent = inputValue;
}

