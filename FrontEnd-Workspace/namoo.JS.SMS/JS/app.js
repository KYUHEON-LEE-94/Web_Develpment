// 애플리케이션 엔트리 포인트
import { Student } from "./Student.js"
import { StudentManager } from "./StudentManager.js"


//테스트 객체화
let cat = new Student(1, "고양이", 30, 20, 10);
let studentManager = new StudentManager();
studentManager.addStudent(cat);
studentManager.addStudent(new Student(1, "송아지", 20, 30, 40));
studentManager.addStudent(new Student(2, "이규헌", 10, 20, 30));
studentManager.addStudent(new Student(3, "강아지", 20, 30, 40));

//---객체와 여기까지--


//변수 선언---------------------
//타이틀
let h2 = document.getElementById('title');

//알림창 선택자 변수
let status = document.getElementById('status');

//table ----------
let tbody = document.getElementById('tbody')
//tr을 복제하기 위한 변수 선언
let tr = document.getElementsByClassName('tr');


//input 분류------------
//input의 밸류값 받아오기
let ssninput = document.getElementById('ssninput');
let studentnameinput = document.getElementById('studentnameinput');
let korInput = document.getElementById('kor');
let engInput = document.getElementById('eng');
let mathInput = document.getElementById('math');


//버튼 분류-----------------------------
//학생명 검색 버튼
let stNameBtn = document.getElementById('stNameBtn');
let ssnBtnSearch = document.getElementById('ssnBtnSearch');
let ssnBtnDelete = document.getElementById('ssnBtnDelete');

//등록 버튼
let enrollBtn = document.getElementById('enroll');

//전체 검색 버튼
let SearchAll = document.getElementById('SearchAll');
//-------------------------------------
let studentnamevalue = null
let ssninputValue = null
let korInputValue = null
let engInputValue = null
let mathInputValue = null
//변수 선언 여기까지..
//윈도우창 로딩되자마자 선언할 초기화함수
window.addEventListener("load", function () {
    //출력되는 예시를 window가 실행되자마자 로드해서 보여줌
    DisplayShow(studentManager.students[0],0);
    //앞의 순번은 항상 자동적으로 입력됨        
    tdRank();
})

//입력받은 student값과 tr[인덱스값]을 입력받아서, student값을 해당 tr[인덱스값]에 출력해줌
function DisplayShow(obj,trchild){
    let Display=[obj.ssn, obj.name, obj.kor, obj.eng, obj.math]
    Display.forEach((element, index) =>{ tr[trchild].children[index+1].textContent = element})
}

//td의 앞에 순위 지정
function tdRank() {
    for (let i = 0; i <= tr.length; i++) {
        tr[i].children[0].textContent = i + 1;
    }
}
//tr 추가 함수
function addtr(number) {
    for (let i = 0; i < number; i++) {
        let clone = tr[0].cloneNode(true);
        tr[0].parentElement.appendChild(clone);
    }
    //tr셀을 추가하면 바로 순위를 추가해줌

}
//tr 제거함수
// function deletrtr(number) {
//     for (let i = 0; i < number; i++) {
//         tbody.removeChild(tr[tr.length-1])
//     }
// }


function statusreset() {
    status.textContent = '';
}


//학생 정보들 출력 함수
function regitinfo() {
    studentnamevalue = studentnameinput.value;
    ssninputValue = ssninput.value;
    korInputValue = korInput.value;
    engInputValue = engInput.value;
    mathInputValue = mathInput.value;

}
//HTML 테이블 화면에 학생의 정보들을 입력해주는 함수
//student 객체를 인자로 받아서 해당 인자의 ssn,name등의 정보를 각 테이블 위치에 입력해서 화면으로 보여줌
function inputSearchvalue(Objs) {
    for (let i = 0; i < tr.length; i++) {
        DisplayShow(Objs[i],i)
    }
}

function resetAllInput() {
    for (let i = 0; i < tr.length; i++) {
        for (let j = 1; j < tr[i].children.length; j++) {
            tr[i].children[j].textContent = '';
        }
    }
}

//목록 전부 찾아오기
function searchAll() {
    statusreset();
    //만약 검색되는 학생정보의 값이 현재 설정되어있는 테이블의 개수보다 많다면 테이블의 개수를 그만큼 늘려줘야한다.

    if (studentManager.students.length > tr.length) {
        //현재의 학생정보의 객체 수 - 현재의 테이블 개수를 빼면 추가해줘야할 값이 나옴./ 그만큼을 추가해줌
        addtr(studentManager.students.length - tr.length)
        //전체 목록을 인쇄해줌
        inputSearchvalue(studentManager.listAll())
    }
    //else의 경우
    inputSearchvalue(studentManager.listAll())
}

//-----학생명 검색버튼으로 성적 정보 찾기
function searchName() {
    regitinfo()
    let findname = studentManager.findnames(studentnamevalue);
    if(studentnamevalue === ''){
        status.textContent ="이름을 입력해주세요"
    }
    if (findname.length > tr.length) {
        addtr(findname.length - tr.length)
        inputSearchvalue(findname);
    }
    inputSearchvalue(findname);
}


//-----학번 검색버튼으로 성적 정보 찾기
function searchSSN() {
    resetAllInput();
    regitinfo()
    let findssns = studentManager.findssns(ssninputValue);
    if (findssns === 0) {
        status.textContent = "없는학번 입니다.";
    }

    if (findssns.length > tr.length) {
        addtr(studentManager.students.length - tr.length)
        inputSearchvalue(findssns);
    }
    inputSearchvalue(findssns);
    // if (findssns.length < tr.length) {
    //     deletrtr(tr.length - findssns.length)
    //     inputSearchvalue(findssns);
    // }

}


//----StudentManager에 student객체를 생성해서 등록해주는 함수
function enrollment() {
    statusreset();
    regitinfo();
    //입력되는 ssn값이 없거나 학생명이 없을때 상태창에 출력해줄 문구들
    if (ssninputValue === '' || studentnamevalue === '') {
        ssninputValue === ''? status.textContent = "학번를 입력해주세요": status.textContent = "이름을 입력해주세요"
        
    } else {
        //정상 출력이 되는 경우에, 상태창 문구를 한번 지워주고
        statusreset();
        //해당 정보들을 입력받아 새로운 정보를 studentManager에 추가해준다. 그리고 상태창 문구로 표시해준다.
        let student = new Student(ssninputValue, studentnamevalue, korInputValue, engInputValue, mathInputValue)
        studentManager.addStudent(student);
        status.textContent = studentnamevalue + " 학생의 성적 정보 추가 완료"
    }
}




function DeleteSsn() {
    //상태창 문구를 한번 초기화해준다.
    statusreset()
    //입력받은 밸류값들을 불러낸다.
    regitinfo();
    let deletessn = studentManager.deletessn(ssninputValue);
    //입력받은 값이 0이라는 건 학번이 없다는 뜻이므로 아래의 경고창을 출력
    deletessn === 0? status.textContent = "없는학번 입니다." : status.textContent = "학번:" + ssninputValue + "삭제 완료"
    if(deletessn === 1){
        status.textContent = "삭제 가능한 항목이 없습니다."
        resetAllInput();
    }
    
}


//--------------아래는 버튼 이벤트 모임

//h2 타이틀 적어주기
h2.innerText = Student.schoolname + " 학생 성적 관리"
//전체검색 버튼을 누르면 전체 목록을 불러오기
SearchAll.onclick = searchAll;
//등록 버튼을 누르면 해당 정보가 등록됨
enrollBtn.onclick = enrollment;
//학번 검색 버튼을 누르면 해당 학번으로 검색 함수가 실행됨
ssnBtnSearch.onclick = searchSSN;
ssninput.onkeyup = searchSSN;
//학생 이름으로 검색해서 찾기
stNameBtn.onclick = searchName;
studentnameinput.onkeyup = searchName;
//학번으로 정보 삭제하기
ssnBtnDelete.onclick = DeleteSsn;

