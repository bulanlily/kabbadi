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
            frmValidator.addValidation("foreignValue.amount","numeric","Please enter a number");
            frmValidator.addValidation("amountSTPIApproval","numeric","Please enter a number");
            frmValidator.addValidation("assessableValueInINR","numeric","Please enter a number");
            frmValidator.addValidation("CIFValueInINR","numeric","Please enter a number");
            frmValidator.addValidation("cgApprovedInINR","numeric","Please enter a number");
            frmValidator.addValidation("dutyExempt","numeric","Please enter a number");
            frmValidator.addValidation("twentyFivePercentDF","numeric","Please enter a number");
            frmValidator.addValidation("dutyForgone","numeric","Please enter a number");
            frmValidator.addValidation("quantity","numeric","Please enter a number");
            frmValidator.addValidation("openingPurchaseValueAsOnApril01","numeric","Please enter a number");
            frmValidator.addValidation("additionsDuringTheYear","numeric","Please enter a number");
            frmValidator.addValidation("deletionsDuringTheYear","numeric","Please enter a number");
            frmValidator.addValidation("dateOfInvoice", "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
            frmValidator.addValidation("dateOfCommissioning", "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid  date");
            frmValidator.addValidation("bondDate", "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
            frmValidator.addValidation("billOfEntryDate", "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
            frmValidator.addValidation("dateOfArrival", "regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
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






