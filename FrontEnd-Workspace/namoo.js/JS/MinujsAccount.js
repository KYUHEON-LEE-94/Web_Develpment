        /*
        은행 계좌 추상화한 클래스
        */
        class MinusAccount extends Account{

            constructor(accountNum, accountOwner, passwd, restMoney, borrowMoney){
                super(accountNum, accountOwner, passwd, restMoney)
                this.borrowMoney = borrowMoney;
            }


            getBorrowMoney(){
                return this.borrowMoney;
            }
            
            
            //오버라이딩
            getRestMoney(){
                return super.getRestMoney() - this.getBorrowMoney()
            }
            

            toString(){
                super.toString() + `, ${this.borrowMoney}`
            }
        }

