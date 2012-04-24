$(function() {
    var hash = window.location.hash;
    if(hash) {
        $("a[href='" +hash+ "']").tab("show");
    }
    else {
        $('.tabs').tab('show');
    }
});