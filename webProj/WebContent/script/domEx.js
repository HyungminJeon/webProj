//console.log(arguments); 매개변수 개수만큼 실제 호출된 변수들을 보여줌

function createTitle(t1, t2, t3, t4, t5) {

    var trTag = document.createElement('tr');
    for (var i = 0; i < arguments.length; i++) {
        var th1 = document.createElement('th');
        th1.innerHTML = arguments[i]; //들어온 매개변수만큼 입력
        trTag.appendChild(th1);
    }
    // var td2 = document.createElement('th');
    // td2.innerHTML = t2;
    // var td3 = document.createElement('th');
    // td3.innerHTML = t3;
    // var td4 = document.createElement('th');
    // td4.innerHTML = t4;
    // var td5 = document.createElement('th');
    // td5.innerHTML = t5;

    // trTag.appendChild(td2);
    // trTag.appendChild(td3);
    // trTag.appendChild(td4);
    // trTag.appendChild(td5);

    tbl.appendChild(trTag);
}

function createData() {

    for (var person of persons) { //persons 배열안 요소갯수만큼 loop 반복
        var trTag = document.createElement('tr');
        trTag.setAttribute('id', person.id);
        trTag.onmouseover = mouseOverFunc; //마우스 올릴때 색깔 변경
        trTag.onmouseout = mouseOutFunc; //마우스 안올릴때 색상 복구
        for (var field in person) { //in 필드(ex.p1)안 요소갯수만큼 반복

            if (field == 'id') { // 필드값이 id일 때, (id를 클릭할때 수정할 수 있도록 하기위해)
                var tdTag = document.createElement('td');


                tdTag.onclick = function () { //id를 클릭했을때 
                    //modifyfunction();
                    // console.log(this);

                    var idVal = this.innerHTML; //해당 필드의 id값
                    var nameVal = this.previousSibling.innerHTML; //해당 필드의 name값
                    var scoreVal = this.nextSibling.innerHTML; //해당 필드의 score값
                    var genVal = this.parentNode.childNodes[3].innerHTML; //해당 필드의 gender값

                    // console.log(idVal, nameVal, scoreVal, genVal);

                    document.getElementById('name').value = nameVal; //input입력란의 name값을 nameVal(해당 필드의 id값)으로 변경
                    document.getElementById('id').value = idVal;
                    document.getElementById('score').value = scoreVal;
                    var genders = document.querySelectorAll('input[name="gender"]');

                    for (var i = 0; i < genders.length; i++) {

                        if (genders[i].value == genVal) {
                            genders[i].checked = true;
                        }
                    }
                }

                var text = document.createTextNode(person[field]);
                trTag.appendChild(tdTag);
                tdTag.appendChild(text);

            } else if (field == 'name') {

                var tdTag = document.createElement('td');
                var link = document.createElement('a');
                link.setAttribute('href', 'dom.jsp?name=' + person.name  +  '&id=' + person.id + '&score=' + person.score +'&gender=' + person.score);
                link.innerHTML = person.name;


                tdTag.appendChild(link);
                trTag.appendChild(tdTag);

            } else {
                var tdTag = document.createElement('td');
                var text = document.createTextNode(person[field]);
                trTag.appendChild(tdTag);
                tdTag.appendChild(text);
            }
        }

        var btn = document.createElement('button');
        btn.innerHTML = '삭제';
        btn.onclick = deleteRow;

        var tdTag = document.createElement('td');
        tdTag.appendChild(btn);
        trTag.appendChild(tdTag);
        tbl.appendChild(trTag);
    }
}

function mouseOverFunc() {
    this.style.backgroundColor = "yellow";
}

function mouseOutFunc() {
    this.style.backgroundColor = "";
}

function deleteRow() {

    this.parentNode.parentNode.remove();
}



var iName = document.getElementById('name');
var iId = document.querySelector('input[name="id"]');
var iScore = document.getElementsByTagName('input')[2];
var iGender = document.querySelector('input[name="gender"]:checked');

// console.log(iGender.value);

var trTag = document.createElement('tr');


trTag.onmouseover = mouseOverFunc;
trTag.onmouseout = mouseOutFunc;



function saveBtnFnc() {

    var iName = document.getElementById('name');
    var iId = document.querySelector('input[name="id"]');
    var iScore = document.getElementsByTagName('input')[2];
    var iGender = document.querySelector('input[name="gender"]:checked');

    var tdTag = document.createElement('td');
    var trTag = document.createElement('tr');

    //name
    tdTag.innerHTML = iName.value;
    trTag.appendChild(tdTag);
    //id
    tdTag = document.createElement('td');
    tdTag.innerHTML = iId.value;
    trTag.appendChild(tdTag);
    tbl.appendChild(trTag);
    //score
    tdTag = document.createElement('td');
    tdTag.innerHTML = iScore.value;
    trTag.appendChild(tdTag);
    tbl.appendChild(trTag);
    //gender
    tdTag = document.createElement('td');
    tdTag.innerHTML = iGender.value;
    trTag.appendChild(tdTag);

    //button
    tdTag = document.createElement('td');
    var btn = document.createElement('button');
    btn.innerHTML = '삭제';
    btn.onclick = deleteRow;
    tdTag.appendChild(btn);
    trTag.appendChild(tdTag);


    tbl.appendChild(trTag);

}

function modifyBtnFnc() {
    var id = document.getElementById('id').value; //id 변수에 현재 input입력란에 입력된 value 넣기
    var targetTr = document.getElementById(id); //
    console.log(targetTr);
    targetTr.children[0].innerHTML = document.getElementById('name').value;
    targetTr.children[2].innerHTML = document.getElementById('score').value;
    targetTr.children[3].innerHTML = document.querySelector('input[name="gender"]:checked').value;
}























































// <!-- <script>
// var p1 = { //p1 : object
//     name: 'Hong',
//     id: 'user1',
//     score: 80,
//     gender: '남'
// }
// var p2 = {
//     name: 'Hwang',
//     id: 'user2',
//     score: 86,
//     gender: '여'
// }
// var p3 = {
//     name: 'Park',
//     id: 'user3',
//     score: 86,
//     gender: '여'
// }
// var p4 = {
//     name: 'Choi',
//     id: 'user4',
//     score: 82,
//     gender: '여'
// }
// var persons = [p1, p2, p3, p4];


// var tableTag = document.createElement('table');
// tableTag.setAttribute('border', '1');

// for (var person of persons) { //배열에서 반복
//     var tr1 = document.createElement('tr');

//     for (var field in person) { //person이 가지고 있는 필드만큼 반복하고싶다.

//         var td1 = document.createElement('td');
//         td1.innerHTML = person[field];

//         tr1.appendChild(td1);

//     }
//     var btn1 = document.createElement('button');
//     btn1.innerHTML = "삭제";
//     tr1.appendChild(btn1);


//     tableTag.appendChild(tr1);

// }
// console.log(btn1.parentNode);
// console.log(btn1.parentNode.childNodes[0].firstChild.nodeValue);
// console.log(btns);


// var btns = document.querySelectorAll('btn1'); //특정한 위치에 정의한 버튼만 가져오고 싶을때
// for (var i = 0; i < btns.length; i++) {
//     btns[i].onclick = function () {


//         var delVal = this.parentNode.childNodes[1].firstChild.nodeValue;
//         delFunc(delVal); //데이터베이스에서 데이터 삭제기능 만들 수 있음  //.previousSibling
//         this.parentNode.remove();
//     }
// }

// function delFunc(val) {
//     //removeAll;
//     console.log(`${val} 삭제됨`);
// }


// var show = document.getElementById('show');
// show.appendChild(tableTag);
// </script> -->