//设置一个全局变量，false代表未选中，true代表选中
var flag = true
function selectAll(){
	var che =  document.getElementsByName("aaa")
	for(var arr in che){
		console.log(che[arr])
	}
	if(flag){
		//设置当前选框的状态
		che[1].setAttribute("checked","checked")
		che[2].setAttribute("checked","checked")
		flag = false
	}else{
		che[1].removeAttribute("checked")
		che[2].removeAttribute("checked")
		flag = true
	}
}


