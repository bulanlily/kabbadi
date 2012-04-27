<form action="<@spring.url '/invoice/${asset.invoice.id!}/asset/save'/>" method="POST">
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
        <div class="span3">
            <label for="registeredTo">Registered to</label>
            <input name="registeredTo" value="${asset.registeredTo!}"/>
        </div>
        <div class="span3">
            <label for="registeredOffice">Registered Office</label>
            <input name="registeredOffice" value="${asset.registeredOffice!}"/>
        </div>

    </div>
    <div class="row">
        <div class="span3">
            <label for="status">Status</label>
            <input name="status"  value="${asset.status!}"/>
        </div>

        <div class="span3" class="radio">
            <label for="isLeased">Serial number</label>
            <div class="row">
                <div class="span1">
                    <input  type="radio" name="isLeased" value="true"/>Y
                </div>
                <div class="span1">
                    <input  type="radio" name="isLeased" value="false"/>N
                </div>

            </div>

        </div>
        <div class="span3">
            <label for="leasingExpiration">Leasing Expiration</label>
            <input name="leasingExpiration" value="${asset.leasingExpiration!}"/>
        </div>
        <div class="span3">
            <label for="maintenanceExpiration">Maintenance Expiration</label>
            <input name="maintenanceExpiration" value="${asset.maintenanceExpiration!}"/>
        </div>

    </div>

    <div class="row">
        <div class="span3">
            <label for="modelName">Model Name</label>
            <input name="modelName"  value="${asset.modelName!}"/>
        </div>

        <div class="span6">
            <label for="leasingCompany">Serial number</label>

            <input  name="leasingCompany" value="${asset.leasingCompany!}"/>

        </div>

        <div class="span3">
            <br/>
            <input type="submit" name="submit" value="Add" class="btn btn-primary"/>
            <a href="<@spring.url '/asset/list'/>"><input class="btn" type="button" value="Cancel"/></a>
        </div>
    </div>

    <br/>
</form>