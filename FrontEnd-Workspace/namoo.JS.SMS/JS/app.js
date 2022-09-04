// 애플리케이션 엔트리 포인트
import { Student } from "./Student.js"
import { StudentManager } from "./StudentManager.js"





//테스트 객체화
let cat = new Student(1, "고양이", 30, 20, 10);
let studentManager = new StudentManager();
studentManager.addStudent(cat);
studentManager.addStudent(new Student(1, "얼룩고양이", 20, 30, 40));
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
    tdRank();
})

//td의 앞에 순위 지정
function tdRank() {
    for (let i = 0; i <= tr.length; i++) {
        tr[i].children[0].textContent = i + 1;
    }
}
//tr 추가 함수
function addtr(number) {
    for (let i = 0; i < number; i++) {
        let clone = tr[1].cloneNode(true);
        tr[1].parentElement.appendChild(clone);
    }
    //tr셀을 추가하면 바로 순위를 추가해줌

}
//tr 제거함수
function deletrtr(number) {
    for (let i = 0; i < number; i++) {
        tbody.removeChild(tr[tr.length - 1])

    }

}
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
        for (let j = 1; j < tr[i].children.length; j++) {
            switch (j) {
                case 1: tr[i].children[j].textContent = Objs[i].ssn; break;
                case 2: tr[i].children[j].textContent = Objs[i].name; break;
                case 3: tr[i].children[j].textContent = Objs[i].kor; break;
                case 4: tr[i].children[j].textContent = Objs[i].eng; break;
                case 5: tr[i].children[j].textContent = Objs[i].math; break;
            }
        }
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
    if (studentManager.students.length > tr.length) {
        addtr(studentManager.students.length - tr.length)
        inputSearchvalue(studentManager.listAll())
    }
    inputSearchvalue(studentManager.listAll())
}

//-----학생명 검색버튼으로 성적 정보 찾기
function searchName() {
    regitinfo()
    let findname = studentManager.findnames(studentnamevalue);
    inputSearchvalue(findname);
}


//-----학번 검색버튼으로 성적 정보 찾기
function searchSSN() {
    regitinfo()
    let findssns = studentManager.findssns(ssninputValue);
    if (findssns === 0) {
        status.textContent = "없는학번 입니다.";
    }
    inputSearchvalue(findssns);

}



//----StudentManager에 student객체를 생성해서 등록해주는 함수
function enrollment() {
    statusreset();
    regitinfo();

    if (ssninputValue === '' || studentnamevalue === '') {
        if (ssninputValue === '') {
            status.textContent = "학번를 입력해주세요"

        }
        if (studentnamevalue === '') {
            status.textContent = "이름을 입력해주세요"
        }
    } else {
        statusreset();
        let student = new Student(ssninputValue, studentnamevalue, korInputValue, engInputValue, mathInputValue)
        studentManager.addStudent(student);
        status.textContent = studentnamevalue + " 학생의 성적 정보 추가 완료"
    }
}




function DeleteSsn() {
    statusreset()
    regitinfo();
    let deletessn = studentManager.deletessn(ssninputValue);
    if (deletessn === 0) {
        status.textContent = "없는학번 입니다.";
    }
    status.textContent = "학번:" + ssninputValue + "삭제 완료"
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
//학생 이름으로 검색해서 찾기
stNameBtn.onclick = searchName;
//학번으로 정보 삭제하기
ssnBtnDelete.onclick = DeleteSsn;

