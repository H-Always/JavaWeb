function world() {
    alert("调用");
}

function test() {
    console.log("再次调用")
}

function input() {
    var num = 1;
    alert(typeof num);
}

var foo = 1;
function test1(){
    var num = 30;
    var str = "30";
    console.log(foo);
}

function showWin() {
    //先获取对象
    const win = document.getElementById("win");

    win.style.display = "block";
    const row = parseInt(rows.value);

    let str = "";

    for (let i = 1; i <= row; i++) {
        for (let j = 1; j<= i; j++){
            str+=j+"*"+i+"="+j*i+"&nbsp;&nbsp;"
        }
        str+="<br>";
    }

    content.innerHTML = str;


}


function closeWin() {
    var win = document.getElementById("win");
    win.style.display = "none";
}









