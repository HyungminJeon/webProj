/**
 * 
 */

		var num1, num2,result;
		num1 = 25;
		num2 = 2;
		result = num1 /num2;
		result = num1 % num2;
		
		var num3 ='25';
		
		console.log (num1 == num3);    //==값만 비교
 		console.log (num1 === num3);   //===타입만 비교
		console.log('결과값:'+ result);
	
 		var obj = {};  //new Object(); 오브젝트를 만들어서 여러 타입을 담는다.
 		obj.name = 'Hong';
 		obj.age = 20;
 		obj.showInfo = function() { //오브젝트 안에 있는 showinfo라는 메서드 호출 
 			console.log('이름 : ' + obj.name + ', 나이 : ' + obj.age);
 		}
 		//console.log (obj);
 		obj.showInfo();
 		
 		var obj2 = {
 			name : 'Hwang',
 			age : 22,
 			showInfo: function() {
 				console.log('이름 ' + this.name + '나이: ' + this.age);
 			}
 		}
 		obj2['name'] = 'Jeon';   //오브젝트 안의 필드 내용을 변경할 때
 		obj2.name = 'kim';
 		obj2['age'] = 29;
 		obj2.showInfo();


         var obj3 = {
             name: 'Kang',
             age : 15,
             showInfo: function() {
                console.log('이름 ' + this.name + '나이: ' + this.age);
         }
        }
         obj3.showInfo();
 		
         //라이브서버 플러그인 설치