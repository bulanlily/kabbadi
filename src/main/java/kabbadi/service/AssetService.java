package kabbadi.service;

import kabbadi.domain.Asset;
import kabbadi.domain.db.GenericRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class AssetService {
    private GenericRepository<Asset> assetRepository;


    @Autowired
    public AssetService(@Qualifier("assetRepository")GenericRepository<Asset> assetRepository){
        this.assetRepository = assetRepository;
    }

    @Transactional
    public Asset findBy(String assetNumber) {
        return assetRepository.findBy(Asset.ASSET_NUMBER, assetNumber);
    }

    @Transactional
    public void saveOrUpdate(Asset asset) {
        assetRepository.saveOrUpdate(asset);
    }

    @Transactional
    public List<Asset> list() {
        return assetRepository.list();
    }

    @Transactional(readOnly = true)
    public Asset get(Integer id) {
        return assetRepository.get(id);
    }


}
