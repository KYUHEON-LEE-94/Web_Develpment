        /*
        은행 계좌 추상화한 클래스
        */
        class Account{

            //static 프로퍼티
            static BankName = "Korea IT Bank"


            constructor(accountNum, accountOwner, passwd, restMoney){
                this.accountNum = accountNum
                this.accountOwner = accountOwner
                this.passwd = passwd
                this.restMoney = restMoney
            }

            //getter, setter
            set accountNum(accountNum){
            this._accountNum = accountNum;
            }
            get accountNum(){
                return this._accountNum
            }

            set accountOwner(accountOwner){
                if(accountOwner === undefined){
                    throw new Error("이름 미입력!");
                }
            this._accountOwner = accountOwner;
            }
            get accountOwner(){
            return this._accountOwner
            }

            set passwd(passwd){
            this._passwd = passwd;
            }
            get passwd(){
            return this._passwd
            }    


            set restMoney(restMoney){
            this._restMoney = restMoney;
            }
            get restMoney(){
            return this._restMoney
            }  
            
            //기능함수

            getRestMoney(){
                return this.restMoney;
            }

            deposit(money){
                if(money <= 0){
                    throw new Error("입금액을 확인해주세요")
                }
                return this.restMoney += money;
            }
            
            withdraw(money){
                return this.restMoney -= money
            }

            checkPasswd(passwd){
                this.passwd === passwd;
            }
            toString(){
                console.log(`${this.accountNum}, ${this.accountOwner}, ****, ${this.restMoney}`);
            }
        }

