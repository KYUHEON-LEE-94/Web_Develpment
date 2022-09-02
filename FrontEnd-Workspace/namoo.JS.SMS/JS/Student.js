       //학생을 추상화한 클래스
        class Student{

            //static 프로퍼티
            static schoolname = "Korea IT School"

            constructor(ssn, name, kor, eng, math){
                this.ssn = ssn
                this.name = name
                this.kor = kor
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

            set kor(kor){
            this._kor = kor;
            }
            get kor(){
            return this._kor
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
                return `학번: ${this.ssn},  이름: ${this.name}, 국어: ${this.korean}점/ 영어: ${this.eng}점/ 수학: ${this.math}점`
            }
        }

export{Student};

