console.log('실행1');

const promise = new Promise((resolve, reject) => {
    console.log("서버와의 통신 등 오랜 시간이 걸린다고 가정하는 중...");
    let id = prompt();    
    setTimeout(() => {
        //성공시
        id ==="bang"? resolve(id):reject(new Error('네트워크 오류'))
    }, 2000);
})

promise
//resolve면
//아이디에 문자열 하나 추가요~
.then(value => (value += "(이규헌)")) 
// promise.then은 다시 promise를 return하기 떄문에 계속해서 연결이 가능
//다음에 또 수신 문자열 추가~
.then(value =>{
    return new Promise((resolve, reject) => {
        setTimeout(()=> {resolve(value +": 서버에서 추가 데이터 수신")
        }, 2000);
    });
})
//추가된 문자열들 consloe.log해주고~
.then(value => console.log(value))
.catch(error => console.log("에러발생"+error))
.finally(() => console.log("에러가 있든 없든 알빠노~"))
console.log("동기실행");

