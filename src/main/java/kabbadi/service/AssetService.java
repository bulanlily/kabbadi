package kabbadi.service;

import kabbadi.domain.Asset;
import kabbadi.domain.db.GenericRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AssetService extends GenericService<Asset>{

    @Autowired
    public AssetService(@Qualifier("repository")GenericRepository<Asset> assetRepository){
        super(assetRepository);
    }

}
