

//Array를 이용한 학생 성정 관리
class StudentManager {

    //static 프로퍼티
    static schoolname = "Korea IT School"



    constructor() {
        //this ={}가 존재하는 상황
        this.students = [];
    }

    //배열에 학생 등록 기능
    addStudent(student) {
        this.students.push(student);
    }

    //배열에 저장된 정체 학생 목록 반환
    listAll() {
        return this.students
    }

    //학생이름으로 찾아오기
    findnames(name) {
        const findnames = this.students.filter(student => student.name === name)
        if (findnames === undefined) {
            return 0
        } else {
            return findnames
        }

    }
    //학번으로 삭제하기
    deletessn(ssn) {
        //1. 입력받은 ssn가 포함되지 않는 배열을 리턴받는다.
        const deletessn = this.students.filter(student => student.ssn != parseInt(ssn))
        //*일치하는 학번이 없으면 this.students.length 전체를 반환해버림
        if (deletessn.length === this.students.length) {
            return 0
        }else if(deletessn.length === 0){
            this.students.length = 0;
            return 1;
        }else {
            //2.새롭게 배열을 구성해주기 위하여 this.students를 초기화해준다.
            this.students.length = 0;
            //3. forEach를 사용하여 위에서 리턴받는 값을 다시 입력해준다.
            deletessn.forEach((array) => { this.students.push(array) })
        }
    }

    //학번으로 찾기
    findssns(ssn) {
        const findssn = this.students.filter(student => student.ssn === parseInt(ssn))
        if (findssn.length === 0) {
            return 0
        } else {
            return findssn
        }
    }

    toString() {
        return `${this.ssn}  ${this.name} ${this.korean} ${this.eng} ${this.math}`
    }
}

export { StudentManager }
