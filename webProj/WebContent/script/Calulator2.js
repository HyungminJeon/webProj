



var tableTag = "<table border= '1'>";
tableTag += "<tr ><th colspan = '3'>구구단</th></tr>";


for (var j = 1; j < 10; j++) {

    tableTag += '<tr><td width = "20px" style = "text-align = center">' + 3 + '*' + j +
        '</td><td width = "20px">=</td><td>'+ 3*j+'</td></tr>';
    
}


tableTag += "</table>";



document.write(tableTag);