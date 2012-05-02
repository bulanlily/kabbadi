package builder;

import forms.AssetForm;

import java.util.HashMap;

public class AssetTestBuilder {


    public AssetForm buildAsset() {
        return new AssetForm(new HashMap<String, Object>() {{
            put("modelName", "modelName1");
            put("serialNumber", "serialNumber123");
            put("registeredTo", "registeredTo123");
            put("status", "status123");
            put("maintenanceExpiration", "13/12/2012");
            put("leasingExpiration", "12/12/2012");
            put("leasingCompany", "leasingCompany123");

        }});
    }
}
