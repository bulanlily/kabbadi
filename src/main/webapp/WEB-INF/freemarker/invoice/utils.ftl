<#macro template role>
<form action="#" class="span3" align="left">
    <input name="search" id="${role}_search" type="text" placeholder="Search...">
    <span style="display: none;" class="loading">Loading...</span>
</form>

<div class="page-header" align="right">
    <div class="btn-toolbar">
        <div class="btn-group">
            <a href="<@spring.url "/invoice/create#${role}"/>" class="btn btn-inverse" id="${role}_add_invoice">Add New</a>
        </div>
        <div class="btn-group">
            <a class="btn dropdown-toggle btn-inverse" data-toggle="dropdown" href="#">
                Generate Report
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <#list locations as location>
                    <li>
                        <a href="<@spring.url '/invoice/report/admin?location=${location}'/>">${location.getLocation()}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </div>

</div>
</#macro>