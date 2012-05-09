$(function() {
    var hash = window.location.hash;
    if(hash) {
        $("a[href='" +hash+ "']").tab("show");
        window.location.hash = "#";
    }
    else {
        $('.tabs').tab('show');
    }
});