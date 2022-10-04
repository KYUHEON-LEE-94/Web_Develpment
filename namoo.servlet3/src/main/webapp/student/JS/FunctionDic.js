import { Student } from "./Student.js"
import { StudentManager } from "./StudentManager.js"
import { Validator } from "./validator.js"

let FunctionDic = {};

//테스트 객체화
let cat = new Student(12, "고양이", 40, 50, 60);
let studentManager = new StudentManager();
studentManager.addStudent(cat);
studentManager.addStudent(new Student(21, "이규헌", 100, 90, 80));
studentManager.addStudent(new Student(30, "강아지", 20, 30, 40));

//---객체화 여기까지--
//변수 선언---------------------
//타이틀
let h2 = document.getElementById('title');

//알림창 선택자 변수 --> 무언가의 경고나 알릴 사항이 있을경우에 문구를 출력해주기 위해서
let status = document.getElementById('status');

/**
 * tr을 복제하기 위한 변수 선언
 * tr들을 배열로 받기 위한 선택자 변수 선언
 */
let tr = document.getElementsByClassName('tr');


//input 분류------------
//input의 밸류값 받아오기
let ssninput = document.getElementById('ssninput');
let studentnameinput = document.getElementById('studentnameinput');
let korInput = document.getElementById('kor');
let engInput = document.getElementById('eng');
let mathInput = document.getElementById('math');


//-------------------------------------
let studentnamevalue = null
let ssninputValue = null
let korInputValue = null
let engInputValue = null
let mathInputValue = null
//변수 선언 여기까지====================

//윈도우창 로딩되자마자 선언할 초기화함수
window.addEventListener("load", function () {
    //내림차순으로 자동적으로 정렬해놓음
    studentManager.sortinfo();
})

/**
 * 
 * @param {*} obj -입력받을 student 객체
 * @param {*} trchild -tr의 childElement 인덱스값을 받기 위한 인수
 * 
 * 1.입력받은 student의 ssn, name값 등을 Display 배열에 정리해서 순차적으러 넣어줌
 * 2.Display를 forEach 함수로 돌리면서 element, index 값을 인수로 전달해줌.
 * **{ tr[trchild].children[index + 1].textContent = element }
 * --> tr의[몇번째 인덱스]에 있는 childElement[index값+1].textContent = Display의 원소값
 * 
 */
function DisplayShow(obj, trchild) {
    let Display = [obj.ssn, obj.name, obj.kor, obj.eng, obj.math]
    Display.forEach((element, index) => { tr[trchild].children[index + 1].textContent = element })
}

//td의 앞에 순위 지정
function tdRank() {
    for (let i = 0; i <= tr.length; i++) {
        tr[i].children[0].textContent = i + 1;
    }
}

/** tr 추가 함수
 * 
 * @param {*} number - 몇개의 tr을 추가해줄 것인지 결정해주는 인수
 * number만큼 반복 실행하기 위한 for문
 * tr[0] -tr들의 첫번째 tr은 항상 디폴트로 존재하기 만들었기 때문에 해당 tr을 복수함
 * 자녀노드들까지 전부 복사해야하기 때문에 true값
 * tr[0]의 부모인자에 appendChild(복사한값)
 */
function addtr(number) {
    for (let i = 0; i < number; i++) {
        let clone = tr[0].cloneNode(true);
        tr[0].parentElement.appendChild(clone);
    }
}
/** tr 제거함수
 * 
 * @param {*} number - 몇개의 tr을 제거해줄 것인지 결정해주는 인수
 * number만큼 반복 실행하기 위한 for문
 * tr[tr.length - 1] --> tr들의 마지막 tr을 제거해주어야 하기때문에
 * tr들의 길이에서 -1을 해준 값을 removeChild()에 넣어줌
 */
function deletr(number) {
    for (let i = 0; i < number; i++) {
        tr[0].parentElement.removeChild(tr[tr.length - 1]);
    }
}


/**
 * addtr과 deletr을 이용하여 상황에따라 동적으로 tr수를 컨트롤할 수 있는 함수
 *
 * @param {*} Arr -어떤 배열의 길이를 기준으로 잡을것인가? 와 HTML에 출력해줄 변수를 위해서
 * inputSearchvalue에 해당 배열의 값들을 HTML에 출력해줌
 */
function CtrTr(Arr) {
    if (Arr.length > tr.length) {
        addtr(Arr.length - tr.length)
        inputSearchvalue(Arr);
    }
    if (Arr.length < tr.length) {
        deletr(tr.length - Arr.length)
        inputSearchvalue(Arr);
    }
}


function statusreset() {
    status.textContent = '';
}


//입력받은 값들을 불러오는 함수
//한번에 모든 값을 불러오기 위해 묶어서 함수로 만듦..
function regitinfo() {
    studentnamevalue = studentnameinput.value;
    ssninputValue = ssninput.value;
    korInputValue = korInput.value;
    engInputValue = engInput.value;
    mathInputValue = mathInput.value;

}
/**
 * HTML 테이블 화면에 학생의 정보들을 입력해주는 함수
 *student 객체를 인자로 받아서 해당 인자의 ssn,name등의 정보를 각 테이블 위치에 입력해서 화면으로 보여줌
 * @param {*} Objs 
 */
function inputSearchvalue(Objs) {
    for (let i = 0; i < tr.length; i++) {
        DisplayShow(Objs[i], i)
    }
}

//더이상 HTML에 출력해줄 수 있는 student 객체가 없다면 상태창에 문구를 출력하고, 모든 셀을 지워버리는 함수
function Noinfo() {
    if (studentManager.listAll().length === 0) {
        status.textContent = "학생 정보가 아무것도 없습니다."
        deletr(tr.length)
    }
}

/** 목록 전부 찾아오기
 * 
 *  만약 검색되는 학생정보의 값이 현재 설정되어있는 테이블의 개수보다 많다면 테이블의 개수를 그만큼 늘려줘야한다.
 * 
 *  CtrTr함수를 이용하여 tr의 개수를 동적으로 조정해줌.
 * 받는 인자는 입력받은 값을 찾아서 HTML에 입력해주는 inputSearchvalue()-콜백 함수와
 * 배열- studentManager.listAll()를 입력해준다.(모든 값을 찾기 위하여) 
 */
FunctionDic.searchAll = function () {
    statusreset();
    Noinfo();
    CtrTr(studentManager.listAll())
    //else의 경우
    inputSearchvalue(studentManager.listAll())
    tdRank();
}

/**
 * /** -----학생명 검색버튼으로 성적 정보 찾기
 *  1. 입력받을 value 값들을 한번 세팅 해줌 - regitinfo();
 * 입력받는 학생명이 '없는'경우에는 상태창에 알림 문구 출력해주는 제어문 if (studentnamevalue === '')...
 *  2. HTML에 출력해주어야 하는 셀의 숫자에 따라 능동적으로 조절해줄 수 있는 CtrTr() 함수를 호출해서 아래와같은 인자값 입력
 * 인자값1.inputSearchvalue- 검색한 값을 HTML에 입력해주는 함수
 * 인자값2. findname - 원하는 값을 찾아서 배열로 리턴받은 변수
 * else inputSearchvalue(findname) 출력
 */
FunctionDic.searchName = function () {
    regitinfo()
    let findname = studentManager.findnames(studentnamevalue);
    if (studentnamevalue === '') {
        status.textContent = "이름을 입력해주세요"
    }
    CtrTr(findname)
    inputSearchvalue(findname);
    tdRank();
}



/** ----학번 검색버튼으로 성적 정보 찾기
 *  1. 알림창을 한번 초기화해서 깨끗하게 만들어 줌 -statusreset();
 *  2. 입력받을 value 값들을 한번 세팅 해줌 - regitinfo();
 *  3.studentManager.findssns로 해당하는 학번 값을 배열로 받아서 찾아옴
 *  3-1. 만약 입력받아온 배열이 없으면 상태창에 없는 학번임을 알려줌
 *  4. CtrTr()을 이용하여 유동적으로 tr들의 수를 제어
 */
FunctionDic.searchSSN = function () {
    statusreset();
    regitinfo()
    let findssns = studentManager.findssns(ssninputValue);
    if (findssns === 0) {
        status.textContent = "없는학번 입니다.";
    }

    CtrTr(findssns);
    //else
    inputSearchvalue(findssns);
    tdRank();

}


/** ----StudentManager에 student객체를 생성해서 등록해주는 함수
 *  1. 알림창을 한번 초기화해서 깨끗하게 만들어 줌 -statusreset();
 *  2. 입력받을 value 값들을 한번 세팅 해줌 - regitinfo();
 *  3. //입력되는 ssn값이 없거나 학생명이 없을때 상태창에 출력해줄 문구를 출력하는 제어문
 *  if (ssninputValue === '' || studentnamevalue === '')...
 * 3-1. 그외의 경우에는 정상출력해줄 else 제어문 - else {.....
 * 4. 등록되는 학생 성적들을 바로 성적으로 나열해주기 위해서 studentManager.sortinfo(); 입력
 */
FunctionDic.enrollment = function () {
    statusreset();
    regitinfo();
    //해당 정보들을 입력받아 새로운 정보를 studentManager에 추가해준다. 그리고 상태창 문구로 표시해준다.
    if (Validator.isNumber(ssninputValue, korInputValue, engInputValue, mathInputValue) && Validator.isAvailable(studentnamevalue)) {
        let student = new Student(ssninputValue, studentnamevalue, korInputValue, engInputValue, mathInputValue)
        studentManager.addStudent(student);
        status.textContent = studentnamevalue + " 학생의 성적 정보 추가 완료"
    } else {
        status.textContent = "학번, 성적은 숫자여야 하며, 학생명은 숫자 및 특수문자 사용이 불가능합니다."
    }

    studentManager.sortinfo();
}

console.log();

/**------학번을 기준으로 정보를 삭제하는 함수
 * 
 * 1.상태창 문구를 한번 초기화해준다.  -statusreset()
 * 2.입력받은 밸류값들을 불러낸다  - regitinfo();
 * 3.입력받은 값이 0이라는 건 학번이 없다는 뜻이므로 아래의 경고창을 출력
 * deletessn === 0 ? status.textContent = "없는학번 입니다." : status.textContent = "학번:" + ssninputValue + "삭제 완료"
 * 4. 더이상 삭제할 수 있는 정보가 없을 경우에 출력하는 함수
 * Noinfo();
 */

FunctionDic.DeleteSsn = function () {
    statusreset()
    regitinfo();
    let deletessn = studentManager.deletessn(ssninputValue);
    deletessn === 0 ? status.textContent = "없는학번 입니다." : status.textContent = "학번:" + ssninputValue + "삭제 완료"

    Noinfo();
    tdRank(); //순위 지정 함수
}

/**------학번을 기준으로 정보를 삭제하는 함수
 * 
 * 1.상태창 문구를 한번 초기화해준다.  -statusreset()
 * 2.입력받은 밸류값들을 불러낸다  - regitinfo();
 * 3.입력받은 값이 0이라는 건 학번이 없다는 뜻이므로 아래의 경고창을 출력
 * findname === 0 ? status.textContent = "없는학번 입니다." : status.textContent = "이름:" + studentnamevalue + "학생 삭제 완료"
 * 4. 더이상 삭제할 수 있는 정보가 없을 경우에 출력하는 제어문
 * if (studentManager.listAll().length === 0)~~
 */
FunctionDic.DeleteName = function () {
    statusreset()
    regitinfo();
    let findname = studentManager.Deletenames(studentnamevalue);
    findname === 0 ? status.textContent = "없는학번 입니다." : status.textContent = "이름:" + studentnamevalue + "학생 삭제 완료"

    Noinfo();
    tdRank();
}

export { FunctionDic }