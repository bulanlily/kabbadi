package builder;

import forms.AssetForm;

import java.util.HashMap;
import java.util.Map;

public class AssetTestBuilder {

    private String modelName = "modelName1234";
    private String serialNumber = "serialNumber123";
    private String registeredTo = "registeredTo123";
    private String status = "status123";
    private String maintenanceExpiration  = "13/12/2012";
    private String leasingExpiration = "12/12/2012";
    private String leasingCompany = "leasingCompany123";
    
    public AssetTestBuilder withModelName(String modelName){
        this.modelName = modelName;
        return this;
    }

    public AssetTestBuilder withSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
        return this;
    }

    public AssetTestBuilder withRegisteredTo(String registeredTo){
        this.registeredTo = registeredTo;
        return this;
    }

    public AssetTestBuilder withStatus(String status){
        this.status = status;
        return this;
    }

    public AssetTestBuilder withMaintenanceExpiration(String maintenanceExpiration){
        this.maintenanceExpiration = maintenanceExpiration;
        return this;
    }

    public AssetTestBuilder withLeasingExpiration(String leasingExpiration){
        this.leasingExpiration = leasingExpiration;
        return this;
    }

    public AssetTestBuilder withLeasingCompany(String leasingCompany){
        this.leasingCompany = leasingCompany;
        return this;
    }

    public AssetForm buildAsset() {
        Map<String, Object> fields = new HashMap<String, Object>();

        fields.put("modelName",modelName);
        fields.put("serialNumber", serialNumber);
        fields.put("registeredTo", registeredTo);
        fields.put("status", status);
        fields.put("maintenanceExpiration", maintenanceExpiration);
        fields.put("leasingExpiration", leasingExpiration);
        fields.put("leasingCompany", leasingCompany);

        return new AssetForm(fields);
    }
}
