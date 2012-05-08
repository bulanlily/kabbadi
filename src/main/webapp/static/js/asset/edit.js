var kabbadi = window.kabbadi || {};
kabbadi.asset = kabbadi.asset || {};
window.kabbadi = kabbadi;

(function($){
    kabbadi.asset = {
    editValidator : function() {

        $.validator.addMethod("customDate", function(value,element){
           return this.optional(element) || (/[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}$/).test(value);
        }, "Please enter a valid date");

        $('#newAssetForm').validate({
            rules : {
                leasingExpiration : { customDate : true },
                maintenanceExpiration : { customDate : true }
            }
        });


    },

    initialize : function() {
        $(function() {
            kabbadi.asset.editValidator();
            kabbadi.asset.selectModel();

            var redirectTo = $("#redirectToTab");
            redirectTo.val((window.location.hash + "").replace("#", ""));

            $('a[data-toggle="tab"]').on('shown', function (e) {
                redirectTo.val($(e.target).attr("href").replace("#", ""));
            });

            $.datepicker.setDefaults({
                dateFormat: 'dd/mm/yy'
            });

            $(".defaultDatepicker").datepicker();

        });
    },
    selectModel : function(){
               $('.typeahead').typeahead({
                   source: [
                       "MacBook Pro 15inch",
                       "MacBook Air 13inch",
                       "Dell E6520",
                       "Dell E6420",
                       "Dell E6320",
                       "Dell E6220"
                   ]
               });
    }
 }
})(jQuery);