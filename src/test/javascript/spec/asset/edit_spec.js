require("../spec_helper.js")


describe("kabbadi.asset.editValidator",function(){

    beforeEach(function() {
        setFixtures('<form id="newAssetForm" name="newAssetForm"> <input id="leasingExpiration"  class="defaultDatepicker" name="leasingExpiration" /> <div class="error_div"  class="defaultDatepicker" id="newAssetForm_leasingExpiration_errorloc"></div> <input id="maintenanceExpiration" name="maintenanceExpiration" /> <div class="error_div" id="newAssetForm_maintenanceExpiration_errorloc"></div> </form>');
    });


    it("fails when the date is not in the correct format",function(){
        kabbadi.asset.editValidator();
        $("#maintenanceExpiration").val("2323423423");
        $("#maintenanceExpiration").submit();

        expect($("label.error[for='maintenanceExpiration']")).toHaveText("Please enter a valid date");
    });

    it("allows the form to submit when the date is in the correct form", function() {
        kabbadi.asset.editValidator();
        $("#leasingExpiration").val("12/12/2022");
        $("#leasingExpiration").submit();

        expect($("label.error[for='leasingExpiration']")).toHaveText("");
    });

    it("should not require date fields for form submission", function() {
        kabbadi.asset.editValidator();
        $("#newAssetForm").submit();
        expect($("label.error")).toHaveText("");
    });

});