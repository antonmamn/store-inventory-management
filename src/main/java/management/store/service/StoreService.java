package management.store.service;

import management.store.model.Store;

import java.util.List;

public interface StoreService {

    List<Store> getAllStores();

    Store getStoreById( Long id);

    Long saveNewStore( Store store);

    void deleteStoreById( Long id);

    void updateStore( Store store);
}
