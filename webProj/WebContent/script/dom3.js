
        var names = [];
        names[0] = '유정모';
        names.push('구자혁'); //제일 마지막 위치에 추가
        names.push('석정원');
        names.pop(); //마지막 위치에 있는 요소 제거
        delete names[0]; //해당되는 요소정보만 삭제 (배열위치는 삭제되지 않음)
        names.shift(); // 처음 위치에 있는 요소 제거
        names.unshift('김이담'); //제일 앞쪽에 추가  
        names.push('공도현');
        names.push('소국진');
        names.push('전형민');



        // map : 배열(names)에 있는 변수들을 map으로 묶을 수 있다. 
        var returnVal = names.map(function(val, idx, ary) {
            var person = {};
            person.name = val;
            person.num = idx;

            return person;
        });

        console.log(returnVal);
        document.write(returnVal);
        console.log('-------------');
        //return되는 값이 참인 값들만 반환해줌
        var returnFil = returnVal.filter(function (val,idx,ary) {
            return idx % 2 == 0;

        });
        console.log(returnFil);


        var i = 0;
        //배열에 있는 각각의 요소에 function을 실행하라
        names.forEach(function () {

            console.log(`names 요소: ${i++}`); //i를 증가시키면서 출력시킨다.
            //console.log('names 요소: ' +i);

        });


        var show = document.getElementById('show');
        var ulTag = document.createElement('ul');
        show.appendChild(ulTag);
        


        // for(var i =0; i <names.length; i++) { 
            // : 함수를 매개변수로 받기 어렵다.
        // }



        //foreach 반복문은 callback 함수를 매개변수로 받을 수 있다.
        names.forEach(function (val, idx, ary) {

            // call back 함수의 첫번째 요소는 배열 names의 첫벗째 값 두번째 요소는 인덱스값 세번째는 배열 그 자체 (a :배열 names의 첫벗째 값 b:인덱스 값 c:배열 그 자체)        
            //    console.log(`names 요소: ${val},${idx},${ary}`);   
            var liTag = document.createElement('li');
            liTag.innerHTML = val; //<li>김이담</li>
            ulTag.appendChild(liTag);

            //console.log('names 요소: ' +i);
        });

        console.log(names);