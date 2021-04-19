
        var buttons = document.getElementsByTagName('button');  //html collection 여러개의 동일한 태그 변수들을 array로 만든다
        console.log(buttons);
        for(var i = 0; i <buttons.length; i++) {
        buttons[i].setAttribute('onclick','showTable()');
    }
        
        var p1 = {
            name: '성진아',
            score: 80,
            gender : '여'
        }

        var p2 = {
            name: '김수민',
            score: 83,
            gender : '여'
        }
        var p3 = {
            name: '장재우',
            score: 85,
            gender : '남'
        }

        var persons = [p1, p2, p3];

        // for (var field in p3) { //p3가 가지고 있는 필드개수만큼
        //     console.log(field, p3[field]);
        // }

        // for (var p of persons) {  //배열의 개수만큼 반복
        //     for (var field in p) {  //필드의 개수만큼 반복

        //     }
        // }

        // for (var p of persons) { 
        //    console.log(`name 요소: ${p.name}`);
        //    console.log(`score 요소:  ${p.score}`);
        // }


        //<table border ='1'><tr><td>성진아</td><td>80</td> <tr>...      setelment 로 테이블 setattri tr과 td appendchild
    

    //-------------------------첫시도----------------------------------- 


        // var tableTag =  document.createElement('table');
        // tableTag.setAttribute('border','1');
        
        // for (var i = 0; i < persons.length; i ++) {

        //     var tr = document.createElement('tr');

        //     for (var j = 0; j < 2; j ++) {
        //     var td = document.createElement('td');

        //     td.innerHTML = persons[j].name
        //     td.innerHTML = persons[j].score;

        //     tr.appendChild(td);
        //     }

        //     tableTag.appendChild(tr);
        //     }

        

        // var show = document.getElementById('show');
        // show.appendChild(tableTag);
            
//------------------------------------------------------------

        // var tableTag =  document.createElement('table');
        // tableTag.setAttribute('border','1');
        
        // for (var person of persons) {
        //     var tr1 = document.createElement('tr');

        //     var td1 = document.createElement('td');
        //     td1.innerHTML = person.name;
        //     var td2 = document.createElement('td');
        //     td2.innerHTML = person.score;
            

        //     tableTag.appendChild(tr1);
        //     tr1.appendChild(td1);
        //     tr1.appendChild(td2);

        // }

        
        // var show = document.getElementById('show');
        // show.appendChild(tableTag);
        
    

//------------------------------------------------------------

function showTable () {
        var tableTag =  document.createElement('table');
        tableTag.setAttribute('border','1');
        
        for (var person of persons) {  //배열에서 반복
            var tr1 = document.createElement('tr');

            for (var field in person) {  //person이 가지고 있는 필드만큼 반복하고싶다.

            var td1 = document.createElement('td');
            td1.innerHTML = person[field];
            tr1.appendChild(td1);
            }

            tableTag.appendChild(tr1);

        }
        
        var show = document.getElementById('show');
        show.appendChild(tableTag);
    }
