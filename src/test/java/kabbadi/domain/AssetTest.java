package kabbadi.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AssetTest {

    private Asset asset;

    @Before
    public void setUp() throws Exception {
        asset = new Asset();
    }

    @Test
    public void should_be_not_leased_by_default() {
        assertThat(asset.isLeased(), equalTo(false));
    }

    @Test
    public void should_be_leased_if_company_is_set() {
        asset.setLeasingCompany("some company");
        assertThat(asset.isLeased(), equalTo(true));
    }

    @Test
    public void should_not_be_leased_if_company_is_set_as_empty_string() {
        asset.setLeasingCompany("");
        assertThat(asset.isLeased(), equalTo(false));
    }

    @Test
    public void should_be_leased_if_expiration_is_set(){
        asset.setLeasingExpiration(new Date());
        assertThat(asset.isLeased(), equalTo(true));
    }
}
