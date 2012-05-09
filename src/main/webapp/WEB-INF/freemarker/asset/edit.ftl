<#import "/application.ftl" as layout />
<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy">
<#setting number_format="computer">

<@layout.template 'Add/Edit asset' >

<h1>Add/Edit Asset of Invoice ${asset.invoice.invoiceNumber!}</h1>
<#if asset.assetNumber??>
<h2>Asset Number: ${"${asset.assetNumber!}"?left_pad(4,'0')}</h2>
        </#if>


<p>* indicates mandatory fields</p>
<br/>

<hr/>
<form action="<@spring.url '/invoice/${asset.invoice.invoice_id!}/asset/save'/>" name="newAssetForm" id="newAssetForm" method="POST">
<input name="assetNumber" type="hidden" value="${asset.assetNumber!}"/>
<br/>
<div class="row">
    <div class="span3">
        <label for="serialNumber">Serial Number</label>
        <input name="serialNumber" value="${asset.serialNumber!}"/>
    </div>
    <div class="span3">
        <label for="registeredTo">Registered To</label>
        <input name="registeredTo" value="${asset.registeredTo!}"/>
    </div>


</div>
<div class="row">
    <div class="span3">
        <label for="modelName">Model Name</label>
        <input name="modelName" type="text" class="typeahead" value="${asset.modelName!}">

    </div>
    <div class="span3">
        <label for="status">Status</label>
        <input name="status"  value="${asset.status!}"/>
    </div>
</div>

<div class="row" style="position:relative;">

    <div class="span3">
        <label for="leasingCompany">Leasing Company</label>
        <input  name="leasingCompany" value="${asset.leasingCompany!}"/>
    </div>
    <div class="span3">
        <label for="leasingExpiration">Leasing Expiration</label>
        <input id="leasingExpiration" name="leasingExpiration" class="defaultDatepicker" value="${asset.leasingExpiration!}"/>
    </div>

</div>

<div class="row">
    <div class="span3">
        <label for="maintenanceExpiration">Maintenance Expiration</label>
        <input name="maintenanceExpiration" class="defaultDatepicker" value="${asset.maintenanceExpiration!}"/>
    </div>
</div>

<div class="row">
    <div class="span3">
        <br/>
        <input type="submit" name="submit" value="Submit" class="btn btn-primary"/>
        <a href="<@spring.url '/invoice/list#is'/>"><input class="btn" type="button" value="Cancel"/></a>
    </div>
</div>

<br/>
</form>

<script type="text/javascript">

</script>


<script src="/kabbadi/static/js/asset/edit.js" ></script>
<script src="/kabbadi/static/js/bootstrap-typeahead.js" ></script>

<script>kabbadi.asset.initialize();</script>
        </@layout.template>
