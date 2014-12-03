$(document).ready(function($){
    $("#bretonHover").mouseover(function(){
        $(this).attr("src","/magasin/resources/images/bretonR.jpg");
    }).mouseout(function(){
        $(this).attr("src","/magasin/resources/images/breton.jpg");
    });
});

    $(".delete").click(function(event){
    	event.preventDefault();
    	 var href = $(this).attr("href");
    	 var ligne = $(this).parent().parent();
    	 
    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:160,
        width:500,
        modal: true,
        buttons: {
            "Oui": function() {
                $.get( href, function( data ){
                	ligne.remove();
            });
                $(this).dialog("close");
            },
            "Annuler": function() {
                $( this ).dialog( "close" );
            }
         }
    });
});
    $('table').DataTable();

