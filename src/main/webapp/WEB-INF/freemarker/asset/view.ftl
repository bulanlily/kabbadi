<#import "/spring.ftl" as spring/>
<#setting datetime_format="dd/MM/yyyy">
<!DOCTYPE html>
<html>
<head>
    <title>View an Asset | Kabbadi</title>
    <script src="/kabbadi/static/js/jquery.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="/kabbadi/static/js/custom-tabs.js" type="text/javascript"></script>
    <link href="/kabbadi/static/css/bootstrap.css" rel="stylesheet">
    <link href="/kabbadi/static/css/kabbadi.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
        .table th, .table td {
        padding: 3px;
        }
        th.name {
        width: 20%;
        }
    </style>
    <link href="/kabbadi/static/css/bootstrap-responsive.css" rel="stylesheet">

</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="<@spring.url '/'/>">Kabbadi</a>

        </div>
    </div>
</div>


<div class="container" position="relative">
<h1>Asset # ${asset.assetNumber}</h1>
<br>

<div class="tabbable">



    <table class="table table-striped">
        <thead>
        <tr>
            <th class="name">NAME</th>
            <th class="value">VALUE</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Asset No</td>
            <td>${asset.assetNumber!}</td>

        </tr>
        <tr>
            <td>PO#</td>
            <td>${asset.invoice.purchaseOrderNumber!}</td>

        </tr>
        <tr>
            <td>Invoice#</td>
            <td>${asset.invoice.invoiceNumber!}</td>
        </tr>
        <tr>
            <td>Serial No</td>
            <td>${asset.serialNumber!}</td>

        </tr>
        <tr>

        <tr>
            <td>Registered to</td>
            <td>${asset.registeredTo!}</td>
        </tr>

        <tr>
            <td>Region</td>
            <td>${asset.registeredOffice!}</td>

        </tr>

        <tr>
            <td>Office Registered to</td>
            <td>${asset.registeredTo!}</td>

        </tr>
        <tr>
            <td>Status</td>
            <td>${asset.status!}</td>

        </tr>
        <td>Is leased (Y/N)</td>
        <#if asset.leased!>
            <td>Yes</td>
            <#else>
                <td>No</td>
        </#if>
        </tr>
        <tr>
            <td>Lease Company</td>
            <td>${asset.leasingCompany}</td>
        </tr>
        <tr>
            <td>Leasing Expiration</td>
            <td>${asset.leasingExpiration!}</td>
        </tr>
        <tr>
            <td>model name</td>
            <td>${asset.modelName!}</td>

        </tr>
        <tr>
            <td>Maintenance Expiration</td>
            <td>${asset.maintenanceExpiration!}</td>
        </tr>

        </tbody>
    </table>
</div>

</div>
</body>
</html>