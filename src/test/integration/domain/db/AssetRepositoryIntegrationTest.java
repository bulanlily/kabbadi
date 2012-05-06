package domain.db;

import integration.IntegrationTest;
import kabbadi.domain.Asset;
import kabbadi.domain.db.GenericRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AssetRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private GenericRepository<Asset> assetRepository;



    @Test
    public void should_generate_asset_number_for_new_asset_on_save() {
        Asset asset = new Asset();
        assetRepository.saveOrUpdate(asset);
        assertThat(asset.getAssetNumber(), notNullValue());
    }

    @Test
    public void should_retain_asset_number_for_existing_asset_on_save() {
        Asset asset = new Asset();
        assetRepository.saveOrUpdate(asset);
        Integer assetNumber = asset.getAssetNumber();
        assetRepository.saveOrUpdate(asset);
        assertThat(asset.getAssetNumber(), equalTo(assetNumber));
    }

    @Test
    public void should_not_generate_duplicate_asset_numbers(){
        executeSQL("TRUNCATE asset");
        executeSQL("INSERT INTO asset(assetNumber) VALUES(1)");
        Asset asset = new Asset();
        assetRepository.saveOrUpdate(asset);
        assertThat(assetRepository.list().size(), equalTo(2));
        assertThat(asset.getAssetNumber(), not(equalTo(1)));
    }

    private void executeSQL(String query){
        sessionFactory.getCurrentSession().createSQLQuery(query).executeUpdate();
    }

}
