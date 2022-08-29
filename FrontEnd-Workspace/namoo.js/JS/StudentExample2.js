       //학생을 추상화한 클래스
        class Student2{
            constructor(ssn, name, korean, eng, math){
                this. ssn = ssn
                this.name = name
                this.korean = korean
                this.eng = eng
                this.math = math
            }

            getsum(){
                return this.korean + this.eng + this.math
            }
            
            getAverage(){
                return this.getsum()/3
            }
            toString(){
                return `${this.ssn}  ${this.name} ${this.korean} ${this.eng} ${this.math}`
            }
        }

