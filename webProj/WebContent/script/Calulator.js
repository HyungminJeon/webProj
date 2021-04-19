


var tableTag = "<table border= '1' >";
tableTag += "<tr ><th colspan = '3'>구구단</th></tr>";


/*
for (var i = 2; i < 10; i++) {
    for (var j = 1; j < 10; j++) {

        tableTag += '<tr><td width = "100px" style = "text-align = center">' + i + '*' + j +
            '</td><td width = "20px">=</td><td>'+ i*j+'</td></tr>';
        
    }
}  
*/

    for (var j = 1; j < 10; j++) {

        tableTag += '<tr><td width = "20px" style = "text-align = center">' + 2 + '*' + j +
            '</td><td width = "20px">=</td><td>'+ 2*j+'</td></tr>';
        
    }


tableTag += "</table>";


document.write(tableTag);
