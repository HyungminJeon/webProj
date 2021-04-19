//선택자

var ps = document.querySelector('div>p');
ps.textContent = '<h1>hello</h1>';
ps.style.backgroundColor = 'yellow';




// var ps = document.querySelectorAll('div>p');   //div 밑의 모든 p를 가져오겠다
// console.log(ps);
// ps.forEach(function (val){
//     console.log(val);
//     val.innerText = '<h1>hello</h1>';
//     val.textContent = '<h1>hello</h1>';
//     val.innerHTML = '<h1>hello</h1>';  //html형식으로 입력
//     val.style.backgroundColor = 'green';
// });





//numbers => 1~ 10
//filter, map, forEach => filter로 짝수 걸러내고 -> evenVal이라는 변수에 담는다.
//evenVal로 리턴된 값을 세배로 곱해서 리턴 n*3 : mapVal;
//mapVal -> console.log( forEach로 각각 출력);
var numbers = [1,2,3,4,5,6,7,8,9,10];

var evenVal = numbers.filter(function (val, idx, ary) { //filter 메서드는 함수를 매개변수로 가진다.
    return val % 2 == 0;
});

var mapVal = evenVal.map(function (val, idx, ary) {
    var multiple = {};
    multiple.val = val*3;
    multiple.idx = idx;
    multiple.ary = ary;
    return multiple;
});

mapVal.forEach(function(val,idx,ary) {
    console.log(val);
});


// => arrow function :람다 표현식
// 람다 표현식으로 변수 설정안하고 function의 매개값으로 계속 이어나가기
// numbers.filter(function(val, idx, ary) =>  (val % 2 == 0)
// .map(function (val, idx, ary) => multiple.val = val*3)
// .forEach(function(val,idx,ary) => console.log(val)
// );


function sum(a,b) {
    return a +b;
}

var sum = (a,b) => {
    return a +b;
}

var sum = (a,b) => a +b;


sum(10,20);


