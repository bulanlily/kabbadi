package kabbadi.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Asset")
@Getter
@Setter
public class Asset {

    final static public String ASSET_NUMBER = "assetNumber";
    @Id
    @GenericGenerator(name="auto-increment", strategy = "increment")
    @GeneratedValue(generator = "auto-increment")
    private Integer assetNumber;

    private String modelName;
    private String serialNumber;
    private String registeredTo;
    private String status;
    private Date maintenanceExpiration;
    private Date leasingExpiration;
    private String leasingCompany;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    public boolean isLeased() {
        return !(StringUtils.isEmpty(leasingCompany) && leasingExpiration == null);
    }
}
