$(document).ready(function() {
    $('#exporta').on('click', function(e){
        e.preventDefault();
        ResultsToTable();
    });

    function ResultsToTable(){    
        $("#tabela").table2excel({
            exclude: ".noExl",
            name:"funcionarios",
    		filename: "funcionarios",
    		
        });
    }
});
