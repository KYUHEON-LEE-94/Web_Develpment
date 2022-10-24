/**
 * recipeForm 추가 버튼을 누르면 추가하는 기능
 */
 
 let tr = document.querySelector('.form-control');
 let btn = document.querySelector('.btn');
 
 function addtr() {   
        tr.parentElement.appendChild(tr);
}

btn.addEventListener('clikc', function(){
	addtr()
})