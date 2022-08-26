       //학생을 추상화한 생성자 함수
        function Student(ssn, name, korean, eng, math){
            //this = {} 자동 생성
            this. ssn = ssn
            this.name = name
            this.korean = korean
            this.eng = eng
            this.math = math
            // console.dir(this);
            //return this 도 자동

            //생성자 함수 안에서는 arrow함수 사용못함..

        }

//Student가 참조하고 있는 prototype 객체에 함수 ㅈ저장
//Student를 객체화할때 자동으로 생성되는 student의 프로토타입 객체에 넣어놓는다는 개념

Student.prototype.getsum = function(){
    return this.korean + this.eng + this.math

}
Student.prototype.getAverage = function(){
    return this.getsum()/3
}
// Student.prototype.toString = function(){
//     return `${this.ssn}  ${this.name} ${this.korean} ${this.eng} ${this.math}`
// }

