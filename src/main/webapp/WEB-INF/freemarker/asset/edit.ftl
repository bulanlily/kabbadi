<form action="<@spring.url '/invoice/${asset.invoice.invoice_id!}/asset/save'/>" method="POST">
    <input name="asset_id" type="hidden" value="${asset.asset_id!}"/>
    <br/>
    <div class="row">
        <div class="span3">
            <label for="assetNumber">Asset number *</label>
            <input name="assetNumber" required="true" value="${asset.assetNumber!}"/>
        </div>
        <div class="span3">
            <label for="serialNumber">Serial number</label>
            <input name="serialNumber" value="${asset.serialNumber!}"/>
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
        <div class="span3">
            <label for="modelName">Model Name</label>
            <input name="modelName"  value="${asset.modelName!}"/>
        </div>
    </div>

    <div class="row">

        <div class="span3">
            <label for="leasingCompany">Leasing Company</label>
            <input  name="leasingCompany" value="${asset.leasingCompany!}"/>
        </div>
        <div class="span3">
            <label for="leasingExpiration">Leasing Expiration</label>
            <input  name="leasingExpiration" value="${asset.leasingExpiration!}"/>
        </div>


    </div>

    <div class="row">
        <div class="span3">
            <label for="maintenanceExpiration">Maintenance Expiration</label>
            <input name="maintenanceExpiration" value="${asset.maintenanceExpiration!}"/>
        </div>
        <div class="span3">
            <br/>
            <input type="submit" name="submit" value="Submit" class="btn btn-primary"/>
            <a href="<@spring.url '/invoice/list#is'/>"><input class="btn" type="button" value="Cancel"/></a>
        </div>

    </div>

    <br/>
</form>