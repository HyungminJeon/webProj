var names = []; //new Array();
names[0] = 'Hong';
names[1] = 'Hwang';
names[2] = 'Park';
names[3] = 'Choi';


for (var i = 0; i < names.length; i++) {
    document.write('<h2>' + names[i] + '</h2>')
}


console.log('-------------');


// <table border="1"></table>
var tableTag = "<table border= '1'>";
tableTag += "<tr><th>이름</th><th>나이</th></tr>";



var persons = [obj, obj2, obj3];
for (var i = 0; i < persons.length; i++) {

    //persons[i].showInfo(); //콘솔에 출력


    if (persons[i].age < 20) {

        tableTag += '<tr><td style = "color: red">' + persons[i].name +
            '</td><td style = "color: red">' + persons[i].age + '</td></tr>';

    } else {


        tableTag += '<tr><td>' + persons[i].name +
            '</td><td>' + persons[i].age + '</td></tr>';

        //loop 돌때마다 tableTag에 행 추가
    }
}

tableTag += "</table>";


document.write(tableTag);