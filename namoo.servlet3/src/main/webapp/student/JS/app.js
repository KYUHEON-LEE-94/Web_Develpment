// 애플리케이션 엔트리 포인트
import { Student } from "./Student.js"
import { FunctionDic } from "./FunctionDic.js"

//변수 선언---------------------
//타이틀
let h2 = document.getElementById('title');


//input 분류------------
//input의 밸류값 받아오기
let ssninput = document.getElementById('ssninput');
let studentnameinput = document.getElementById('studentnameinput');

//버튼 분류-----------------------------
//학생명 검색 버튼
let stNameBtn = document.getElementById('stNameBtn');
let stNameDelete = document.getElementById('stNameDelete');
let ssnBtnSearch = document.getElementById('ssnBtnSearch');
let ssnBtnDelete = document.getElementById('ssnBtnDelete');

//등록 버튼
let enrollBtn = document.getElementById('enroll');

//전체 검색 버튼
let SearchAll = document.getElementById('SearchAll');
//-------------------------------------

//변수 선언 여기까지====================




//--------------아래는 버튼 이벤트 모임-------------------

//<----이벤트 함수------>
/**
 * 엔터키를 누르면 이벤트가 발생하는 함수 기능
 * @param {*} target -이벤트 대상이 되는 상대
 * @param {*} eventfuntion  - ex) searchAll(), enrollment()....
 */

function Enterkey(target, eventfuntion) {
    target.onkeyup = function (event) {
        if (event.keyCode === 13) {
            eventfuntion();
        }
    }
}
//=============

//h2 타이틀 적어주기
h2.innerText = Student.schoolname + " 학생 성적 관리"


//전체검색 버튼을 누르면 전체 목록을 불러오기
SearchAll.onclick = FunctionDic.searchAll;
//등록 버튼을 누르면 해당 정보가 등록됨
enrollBtn.onclick = FunctionDic.enrollment;
//학번 검색 버튼을 누르면 해당 학번으로 검색 함수가 실행됨
ssnBtnSearch.onclick = FunctionDic.searchSSN;
Enterkey(ssninput, FunctionDic.searchSSN)

//학번으로 정보 삭제하기
ssnBtnDelete.onclick = FunctionDic.DeleteSsn;

//학생 이름으로 검색해서 찾기
stNameBtn.onclick = FunctionDic.searchName;
Enterkey(studentnameinput, FunctionDic.searchName)

//학생이름으로 삭제하기
stNameDelete.onclick = FunctionDic.DeleteName;
