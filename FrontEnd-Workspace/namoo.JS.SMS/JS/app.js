// 애플리케이션 엔트리 포인트
import {Student} from "./Student.js"
import {StudentManager} from "./StudentManager.js"


//테스트 객체화
let cat = new Student(1,"고양이", 30, 20, 10);
let studentManager = new StudentManager();
studentManager.addStudent(cat);
studentManager.addStudent(new Student(2,"이규헌",10,20,30));
studentManager.addStudent(new Student(3,"강아지",20,30,40));

//---객체와 여기까지--
//변수 선언---------------------
//타이틀
let h2 = document.getElementById('title');

let status = document.getElementById('status');

let trchildren = document.getElementsByClassName('tr');


function test (){
    console.log(trchildren[1].children[0]);
}
test()
//input 분류------------
let ssninput = document.getElementById('ssninput');
let studentnameinput = document.getElementById('studentnameinput');
let korInput = document.getElementById('kor');
let engInput = document.getElementById('eng');
let mathInput = document.getElementById('math');

//input의 밸류값 받아오기
let studentnamevalue = null
let ssninputValue = null
let korInputValue = null
let engInputValue = null
let mathInputValue = null

let stussn = document.getElementById('stussn');
let stuname = document.getElementById('stuname');
let stukor = document.getElementById('stukor');
let stueng = document.getElementById('stueng');
let stumath = document.getElementById('stumath');

//버튼 분류-----------------------------
//학생명 검색 버튼
let stNameBtn = document.getElementById('stNameBtn');
let ssnBtnSearch = document.getElementById('ssnBtnSearch');

//등록 버튼
let enrollBtn = document.getElementById('enroll');

//변수 선언 여기까지..

//학생 정보들 출력 함수
function regitinfo(){
    studentnamevalue = studentnameinput.value;
    ssninputValue = ssninput.value;
    korInputValue = korInput.value;
    engInputValue = engInput.value;
    mathInputValue = mathInput.value;

}
//HTML 테이블 화면에 학생의 정보들을 입력해주는 함수
//student 객체를 인자로 받아서 해당 인자의 ssn,name등의 정보를 각 테이블 위치에 입력해서 화면으로 보여줌
function tableshow(findobj){
    stussn.textContent = findobj.ssn
    stuname.textContent = findobj.name;
    stukor.textContent = findobj.kor;
    stueng.textContent = findobj.eng;
    stumath.textContent = findobj.math;
}


//h2 타이틀 적어주기
h2.innerText = Student.schoolname +" 학생 성적 관리"

//-----학생명 검색버튼으로 성적 정보 찾기
function searchName(){
    regitinfo()
    let findname = studentManager.findnames(studentnamevalue);

    tableshow(findname);
}
studentnameinput.onkeyup = enterkey;
stNameBtn.onclick = searchName; 

//-----학번 검색버튼으로 성적 정보 찾기
function searchSSN(){
    regitinfo()
    let findssn = studentManager.findssn(ssninputValue);
    tableshow(findssn);
    enterkey()
}
function enterkey(e) {
	if (e.keyCode == 13) {
        searchSSN()
    }
}
ssninput.onkeyup =enterkey
ssnBtnSearch.onclick =searchSSN;

//----StudentManager에 student객체를 생성해서 등록해주는 함수
function enrollment(){
    regitinfo();
    let student = new Student(ssninputValue, studentnamevalue,korInputValue, engInputValue, mathInputValue)
    
    studentManager.addStudent(student);
    status.textContent = studentnamevalue + " 학생의 성적 정보 추가 완료"
}
//등록 버튼을 누르면 해당 정보가 등록됨
enrollBtn.onclick = enrollment;


//----전체검색
function Allsearch(){
    let some = studentManager.listAll()
    console.dir(some);
}
Allsearch();



