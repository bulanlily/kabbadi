<#import "/application.ftl" as layout />
<#import "/spring.ftl" as spring />
<#setting datetime_format="dd/MM/yyyy" />
<#setting number_format="computer" />

<@layout.template 'View an Asset' >

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
            <td>${"${asset.assetNumber!}"?left_pad(4,'0')}</td>

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
            <td>Location</td>
            <td>${asset.invoice.location!}</td>

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
</@layout.template>