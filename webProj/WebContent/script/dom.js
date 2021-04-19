
// 예제-
// <!-- <form action ='login.jsp' method ='get'>
//     id : <input type = 'text' name = 'id'>
//     passwd : <input type="password" name = 'passwd'>
//     <input type= "submit" value="Send">
//     <input type = "reset" value="Cancel">
// </form> -->


// <!-- <div id = 'show'> </div>
// <script>
//     var h1Tag = document.createElement('h1');
//     h1Tag.innerHTML = "Hello";
//     console.log(h1Tag);
//     var aTag = document.createElement('a');
//     aTag.setAttribute('href', 'https://www.daum.net');
//     //aTag.innerHTML = '다음페이지';
//     var text = document.createTextNode('다음 사이트');
//     aTag.appendChild(text);
    
//     console.log(aTag);

//     // document.body.appendChild(h1Tag);
//     // document.body.appendChild(aTag);

//     var show = document.getElementById('show');
//     show.setAttribute('style','background-color:red');
//     show.appendChild(h1Tag);
//     show.appendChild(aTag); -->



var form = document.createElement('form');
form.setAttribute('action', 'login.jsp');
form.setAttribute('method', 'get');



var id = document.createElement('input');
id.setAttribute('type', 'text');
id.setAttribute('name', 'id');

var passwd = document.createElement('input');
passwd.setAttribute('type', 'password');
passwd.setAttribute('name', 'passwd');
passwd.setAttribute('style', 'display: block');

var submit = document.createElement('input');
submit.setAttribute('type', 'submit');
submit.setAttribute('value', 'Send');

var reset = document.createElement('input');
reset.setAttribute('type', 'reset');
reset.setAttribute('value', 'Cancel');


var br = document.createElement('br');


var idText = document.createTextNode('Id : ');
var passwdText = document.createTextNode('Password : ');
var space = document.createTextNode(' ');



form.appendChild(idText);
form.appendChild(id);
form.appendChild(space);
form.appendChild(passwdText);
form.appendChild(passwd);
form.appendChild(submit);
form.appendChild(reset);


var show = document.getElementById('show');
show.setAttribute('style', 'background-color:pink');
show.appendChild(form);


// var aTag = document.createElement('a');
// aTag.setAttribute('href', 'https://www.daum.net');
//aTag.innerHTML = '다음페이지';
// var text = document.createTextNode('다음 사이트');
// aTag.appendChild(text);

// console.log(aTag);

// document.body.appendChild(h1Tag);
// document.body.appendChild(aTag);