       //학생을 추상화한 클래스
        class Student2{

            //static 프로퍼티
            static schoolname = "Korea IT School"

            //static 함수
            static study(){
                console.log("모든 학생은 열심히 공부할까?");
            }

            //static은 this클래스의 constructor에 생성됨 -> 프로토타입에 생성되는게 아님, 인스턴스 객체에서 이용이 안됨

            constructor(ssn, name, korean, eng, math){
                this.ssn = ssn
                this.name = name
                this.korean = korean
                this.eng = eng
                this.math = math
            }

            set ssn(ssn){
            this._ssn = ssn;
            }
            get ssn(){
                return this._ssn
            }

            set name(name){
                if(name === undefined){
                    throw new Error("이름 미입력!");
                }
            this._name = name;
            }
            get name(){
            return this._name
            }

            set korean(korean){
            this._korean = korean;
            }
            get korean(){
            return this._korean
            }    


            set eng(eng){
            this._eng = eng;
            }
            get eng(){
            return this._eng
            }  
            
            set math(math){
            this._math = math;
            }
            get math(){
            return this._math
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

