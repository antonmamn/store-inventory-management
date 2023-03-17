package management.store.service;

import management.store.model.Store;
import management.store.model.StoreStatus;
import management.store.repository.StoreRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{
    private StoreRepositoryJPA storeRepository;
@Autowired
    public StoreServiceImpl(StoreRepositoryJPA storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store getStoreById(Long id) {
        Optional<Store> storeById = storeRepository.findById(id);
        return storeById.orElse(null);
    }

    @Override
    public Long saveNewStore(Store store) {
        return storeRepository.save(store).getId();
    }

    @Override
    public void deleteStoreById(Long id) {
        storeRepository.updateStatusById(id, StoreStatus.DISABLED);
    }

    @Override
    public void updateStore(Store store) {
        storeRepository.save(store);
    }
}
