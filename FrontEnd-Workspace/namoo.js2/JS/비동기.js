
function loginUser(id, wd , onSucess, OnError){
    setTimeout(()=>{
        if(id === "bang" && wd === '1111'){
            onSucess(id);
        }else{
            OnError(new Error("정보 확인"))
        }
    })
}

function getRole(id,onSucess,OnError){
    setTimeout(() =>{
        if(id === "bang"){
            onSucess({id:id, role:"teacher"})
        }else{
            OnError(new Error('정보 접근 불가'))
        }
    })
}

const id = 'bang';
const wd = '1111'

loginUser(id,wd, function(loginid){
    getRole(
        loginid,
        function(user){
            alert(`아이디${user.id}, 업무${user.role}`)
        },
        function(error){
            alert(error)
        }
    )
},
function(error){
    alert(error)
}
)