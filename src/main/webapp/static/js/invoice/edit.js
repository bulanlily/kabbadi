$(function () {
    var redirectTo = $("#redirectToTab");
    redirectTo.val((window.location.hash + "").replace("#", ""));

    $('a[data-toggle="tab"]').on('shown', function (e) {
        redirectTo.val($(e.target).attr("href").replace("#", ""));
    });

    $.datepicker.setDefaults({
        dateFormat: 'dd/mm/yy'
    });

    $(".defaultDatepicker").datepicker( );

    $("#remove_previous_bond_number").click(removePreviousInvoice);

    $("input[name='bondNumber']").blur(function() {
        var current_bond_number = $(this).val();
        if(current_bond_number.match(/\d+\/\d{2}-\d{2}/)) {
            $.getJSON("previousRunningBalance",
            {bondNumber : current_bond_number},
            function(previousInvoice) {
                if(previousInvoice.bondNumber) {
                     $("#previous_bond_number").html(previousInvoice.bondNumber);
                     $("#previous_bond_value").html(+previousInvoice.runningBalance);
                     calculateCurrentRunningBalance();
                     $("#previous_matched_bond_number").show();
                }
                else {
                    removePreviousInvoice();
                }
            });
        }
        });
        $("input[name='amountSTPIApproval'],input[name='cgApprovedInINR']").blur(calculateCurrentRunningBalance);
        var frmValidator = new Validator("newInvoiceForm");
            frmValidator.addValidation("invoiceNumber", "req", "Please enter the invoice number");
            var numericFields = ["foreignValue.amount",
                                 "amountSTPIApproval",
                                 "assessableValueInINR",
                                 "CIFValueInINR",
                                 "cgApprovedInINR",
                                 "dutyExempt",
                                 "twentyFivePercentDF",
                                 "dutyForgone",
                                 "quantity",
                                 "openingPurchaseValueAsOnApril01",
                                 "additionsDuringTheYear",
                                 "deletionsDuringTheYear"];
            var dateFields = ["dateOfInvoice",
                              "dateOfCommissioning",
                              "bondDate",
                              "billOfEntryDate",
                              "dateOfArrival"];
            for (var i = 0; i<numericFields.length; i++)
                frmValidator.addValidation(numericFields[i],"numeric","Please enter a number");
            for (var i = 0; i<dateFields.length; i++)
                frmValidator.addValidation(dateFields[i], "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
            frmValidator.EnableFocusOnError(true);
            frmValidator.EnableOnPageErrorDisplay();
            frmValidator.EnableMsgsTogether();

            $("form").submit(function() {
                if($(".error_div:not(:empty)").length > 0) {
                    $("#form_errors_msg").show();
                };
            });

});


var removePreviousInvoice = function() {
    $("#previous_matched_bond_number").hide();
    $("#previous_bond_value").text(0);
    calculateCurrentRunningBalance();
};

var calculateCurrentRunningBalance = function() {
    var prevRunningBalance = +$("#previous_bond_value").text();
    var amountSTPIApproval = +$("input[name='amountSTPIApproval']").val();
    var cgApprovedInINR = +$("input[name='cgApprovedInINR']").val();

    $("input[name='runningBalance']").val(prevRunningBalance - amountSTPIApproval + cgApprovedInINR);
};






