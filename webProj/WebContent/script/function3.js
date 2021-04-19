

var sum = function(a,b) {

var num1 = 10;
var num2 = 20;
console.log( a + (num1 +num2) + b);
return a + (num1 +num2) + b;
}


var a = sum('결과는','입니다.');

document.write(a);

//console.log(sum);


var factorial = function fac(n) {
    
    if(n ==1 ) {
        return 1;
    } 

    return n * fac(n-1);
}


var result = factorial(3);
console.log(result);
document.write(result);


function sumVal (a,b) {
    return a+b;
}

function mulVal (a,b) {
    return a*b;
}

function executeFunc (callBack, num1, num2) {
    var result =  callBack(num1, num2);
    return result;
}


result = executeFunc(sumVal, 3, 5);
console.log(result); 

document.write(''  + result);