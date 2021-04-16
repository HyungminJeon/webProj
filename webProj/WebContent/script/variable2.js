/**
 *  variable2.js
 */

var tOn = document.getElementById('turnOn');
tOn.onmouseover = function() {
	document.getElementById('show').src = 'http://www.w3schools.com/js/pic_bulbon.gif';
}

var tOff = document.getElementById('turnOff');
tOff.onclick = function() {
	document.getElementById('show').src = 'http://www.w3schools.com/js/pic_bulboff.gif';
}

var light = document.getElementById('show');
light.onmouseover = function() {
	document.getElementById('show').src = 'http://www.w3schools.com/js/pic_bulbon.gif';
	}

var light = document.getElementById('show');
light.onmouseout = function() {
	document.getElementById('show').src = 'http://www.w3schools.com/js/pic_bulboff.gif';
	}
