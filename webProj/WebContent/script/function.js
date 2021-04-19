//function.js
function sum(num3, num4) {
    var num1 = 10;
    var num2 = 20;
    console.log(num1 + num2 + num3 + num4);
    return num1 + num2 + num3 + num4;
}

//var result = sum(30, 40, 50);



var numAry = [3,5,1,8,9];

function arySum(ary) {
    var sum =0;
    for (var i =0; i < ary.length; i++) {
        if(ary[i]%2 == 1) {
        sum += ary[i];
    }
}
    return sum;
}


var result = arySum(numAry);
document.write('결과값은: ' + result);




function multi(grade) {

    var tableTag = "<table border= '1'>";
    tableTag += "<tr ><th colspan = '3'>구구단</th></tr>";

    for (var j = 1; j < 10; j++) {

        tableTag += '<tr><td style = "text-align : center" width = "100px" >' + grade + '*' + j +
            '</td><td width = "20px">=</td><td>' + grade * j + '</td></tr>';

    }
    tableTag += "</table>";
    document.write(tableTag);
}


multi(4);