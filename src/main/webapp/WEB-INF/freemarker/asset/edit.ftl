<#import "/spring.ftl" as spring/>
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">
<!DOCTYPE html>
<html>
<head>
    <title>Add/Edit invoice | Kabbadi</title>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/gen_validatorv4.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/jquery.datePicker.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/jquery.ui.datepicker.validation.min.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
    <script type="text/javascript">
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
        });

    </script>
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }

        div.error_div{
        color: red;
        margin-bottom:5px;
        }

    </style>

</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">

            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="<@spring.url '/invoice/list'/>">Kabbadi</a>

        </div>
    </div>
</div>




<div class="container" position="relative">
<h1>Add/Edit Asset of Invoice ${asset.invoice.invoiceNumber!}</h1>

<p>* indicates mandatory fields</p>
<br/>

    <hr/>
    <form action="<@spring.url '/invoice/${asset.invoice.invoice_id!}/asset/save'/>" name="newAssetForm" id="newAssetForm" method="POST">
        <input name="assetNumber" type="hidden" value="${asset.assetNumber!}"/>
        <br/>
        <div class="row">
            <div class="span3">
                <label for="serialNumber">Serial number</label>
                <input name="serialNumber" value="${asset.serialNumber!}"/>
            </div>

            <div class="span3">
                <label for="modelName">Model Name</label>
                <input name="modelName"  value="${asset.modelName!}"/>
            </div>

        </div>
        <div class="row">
            <div class="span3">
                <label for="registeredTo">Registered to</label>
                <input name="registeredTo" value="${asset.registeredTo!}"/>
            </div>
            <div class="span3">
                <label for="status">Status</label>
                <input name="status"  value="${asset.status!}"/>
            </div>
        </div>

        <div class="row">

            <div class="span3">
                <label for="leasingCompany">Leasing Company</label>
                <input  name="leasingCompany" value="${asset.leasingCompany!}"/>
            </div>
            <div class="span3">
                <label for="leasingExpiration">Leasing Expiration</label>
                <input  name="leasingExpiration" class="defaultDatepicker" type="date" value="${asset.leasingExpiration!}"/>
                <div class='error_div' id='newAssetForm_leasingExpiration_errorloc'></div>
            </div>

        </div>

        <div class="row">
            <div class="span3">
                <label for="maintenanceExpiration">Maintenance Expiration</label>
                <input name="maintenanceExpiration" class="defaultDatepicker" type="date" value="${asset.maintenanceExpiration!}"/>
                <div class='error_div' id='newAssetForm_maintenanceExpiration_errorloc'></div>
            </div>
            <div class="span3">
                <br/>
                <input type="submit" name="submit" value="Submit" class="btn btn-primary"/>
                <a href="<@spring.url '/invoice/list#is'/>"><input class="btn" type="button" value="Cancel"/></a>
            </div>

        </div>

        <br/>
    </form>
    <script type="text/javascript">
        var frmValidator = new Validator("newAssetForm");
        frmValidator.addValidation("leasingExpiration","regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
        frmValidator.addValidation("maintenanceExpiration","regexp=[0-3][0-9]\/[0-1][0-9]\/[0-9]{4}", "Please enter a valid date");
        frmValidator.EnableFocusOnError(true);
        frmValidator.EnableOnPageErrorDisplay();
        frmValidator.EnableMsgsTogether();

    </script>
</div>
</body>
</html>