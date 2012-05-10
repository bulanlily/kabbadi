var kabbadi = window.kabbadi || {};
kabbadi.invoice = kabbadi.invoice || {};
window.kabbadi = kabbadi;

kabbadi.invoice.edit = {
    routeResponse : function(redirectTo, cancelButton, tab) {
        var originalCancelURL = cancelButton.attr("href");
        var incomingTab = ($("a", tab.parent(".active")).attr("href") + "");

        redirectTo.val(incomingTab.replace("#", ""));
        cancelButton.attr("href", originalCancelURL + incomingTab);

        tab.on('shown', function (e) {
            var targetTab = $(e.target).attr("href") + "";
            redirectTo.val(targetTab.replace("#", ""));
            cancelButton.attr("href", originalCancelURL + targetTab);
        });
    },
    editValidator : function() {

        $.validator.addMethod("customDate", function(value,element){
           return this.optional(element) || (/[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}$/).test(value);
        }, "Please enter a valid date");

        $.validator.addMethod("customBondNumber", function(value,element){
           return this.optional(element) || (/[0-9]{2}\/[0-9]{2}-[0-9]{2}$/).test(value);
        }, "eg. 41/11-12");



        $('#newInvoiceForm').validate({
            rules : {
                bondNumber : { customBondNumber : true },
                dateOfInvoice : { customDate : true },
                dateOfCommissioning : { customDate : true },
                bondDate : { customDate : true },
                billOfEntryDate : { customDate : true },
                dateOfArrival : { customDate : true },
                dateOfCommissioning : { customDate : true },
                invoiceNumber : { required : true },
                "foreignValue.amount" : { number : true },
                amountSTPIApproval : { number : true },
                assessableValueInINR : { number : true },
                CIFValueInINR : { number : true },
                cgApprovedInINR : { number : true },
                dutyExempt : { number : true },
                twentyFivePercentDF : { number : true },
                dutyForgone : { number : true },
                quantity : { number : true },
                openingPurchaseValueAsOnApril01 : { number : true },
                additionsDuringTheYear : { number : true },
                deletionsDuringTheYear : { number : true }
            },
            invalidHandler : function() {
                $("#form_errors_msg").show();
            },
            submitHandler : function(form) {
              var currentInvoiceNumber = $("input[name='invoiceNumber']").val();
              if(kabbadi.invoice.edit.previousInvoiceNumber != currentInvoiceNumber){
                $('#myModal').modal('show');
                $("#submit-modal").click(function(e) {form.submit(); });
              }
              else {
                  form.submit();
              }
            }
        });

    },

    fetchInvoiceNumber : function(baseUrl) {
            var showDuplicateInvoiceAlert = function() {

                $("#invoiceNumber_error_alert").show();

            }
            var removeDuplicateInvoiceAlert = function() {
                $("#invoiceNumber_error_alert").hide();
            }

            $("input[name='invoiceNumber']").blur(function() {
                var $this = $(this);
                $.getJSON(baseUrl + "/invoice/checkInvoiceNumber",
                {
                    invoiceNumber : $this.val(),
                },
                function(invoice) {
                   if(invoice.exists) {
                         var currentInvoiceNumber = $("input[name='invoiceNumber']").val();
                         if(kabbadi.invoice.edit.previousInvoiceNumber != currentInvoiceNumber){
                           showDuplicateInvoiceAlert();
                       }
                   }
                   else {
                       removeDuplicateInvoiceAlert();
                   }
                });

            });

        },

    fetchPreviousRunningBalance : function() {
        var current_bond_number = $("input[name='bondNumber']").val();
        if(current_bond_number.match(/\d+\/\d{2}-\d{2}/)) {
            var location = $("#location").val();
            $.getJSON("previousRunningBalance",
            {
                bondNumber : current_bond_number,
                location   : location
            },
            function(previousInvoice) {
                if(previousInvoice.bondNumber) {
                     $("#previous_bond_number").html(previousInvoice.bondNumber);
                     $("#previous_bond_value").html(+previousInvoice.runningBalance);
                     kabbadi.invoice.edit.calculateCurrentRunningBalance();
                     $("#previous_matched_bond_number").show();
                }
                else {
                    kabbadi.invoice.edit.removePreviousInvoice();
                }
            });
        }
    },

    removePreviousInvoice : function() {
        $("#previous_matched_bond_number").hide();
        $("#previous_bond_value").text(0);
        kabbadi.invoice.edit.calculateCurrentRunningBalance();
    },

    calculateCurrentRunningBalance : function() {
        var prevRunningBalance = +$("#previous_bond_value").text();
        var CIFValueInINR = +$("input[name='CIFValueInINR']").val();
        var cgApprovedInINR = +$("input[name='cgApprovedInINR']").val();

        $("#runningBalance").val(prevRunningBalance - CIFValueInINR + cgApprovedInINR);
    },


    initialize : function(baseUrl) {

        $(function () {
            kabbadi.invoice.edit.routeResponse($("#redirectToTab"),$("#cancelButton"), $('a[data-toggle="tab"]'));
            kabbadi.invoice.edit.editValidator();
            kabbadi.invoice.edit.fetchInvoiceNumber(baseUrl);
            kabbadi.invoice.edit.previousInvoiceNumber = $("input[name='invoiceNumber']").val();

            $.datepicker.setDefaults({
                dateFormat: 'dd/mm/yy'
            });
            $(".defaultDatepicker").datepicker( );
            $("#remove_previous_bond_number").click(kabbadi.invoice.edit.removePreviousInvoice);
            $("input[name='bondNumber']").blur(kabbadi.invoice.edit.fetchPreviousRunningBalance);
            $("#location").change(kabbadi.invoice.edit.fetchPreviousRunningBalance);
            $("input[name='amountSTPIApproval'],input[name='cgApprovedInINR']").blur(kabbadi.invoice.edit.calculateCurrentRunningBalance);

        });

    }
}