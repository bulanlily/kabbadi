require("../spec_helper.js")

describe("redirecting to the right tabs",function(){

    var redirectInput;
    var cancelButton;
    var tab;


    beforeEach(function(){
        redirectInput = $("<input />");
        cancelButton = $("<a href='list' />");
        tab = $('<a href="#admin" />');
    });

    describe("cancel", function() {
        it("should change the location to the right tab", function(){
            kabbadi.invoice.edit.routeResponse(redirectInput,cancelButton, tab);
            tab.trigger("shown");
            expect(cancelButton.attr("href")).toContain("#admin");
        })
    })

    describe("submit", function() {
        it("should change the location to the right tab", function(){
            kabbadi.invoice.edit.routeResponse(redirectInput,cancelButton, tab);
            tab.trigger("shown");
            expect(redirectInput.val()).toContain("admin");
        })
    })
})

describe("validations", function() {
    it("should show a error message for all the tabs when it is invalid", function() {
        setFixtures("<form id='newInvoiceForm' ><input name='invoiceNumber' /> <div style='display:none' id='form_errors_msg'></div></form>")

        kabbadi.invoice.edit.editValidator();
        $("#newInvoiceForm").submit();

        expect($("#form_errors_msg")).toBeVisible();
    })
})