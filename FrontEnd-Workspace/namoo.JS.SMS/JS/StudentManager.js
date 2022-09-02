

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
        const findnames = this.students.find(student => student.name === name)
        if (findnames === undefined) {
            return 0
        } else {
            return findnames
        }

    }

    //학번으로 찾기
    findssn(ssn) {
        const findssn = this.students.find(student => student.ssn === parseInt(ssn))
        if (findssn === undefined) {
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
