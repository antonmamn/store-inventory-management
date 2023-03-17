package management.store.controller;

import management.store.model.Store;
import management.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store")
@RestController
public class StoreREST {
private StoreService storeService;
@Autowired
    public StoreREST(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> allStores = storeService.getAllStores();
        return ResponseEntity.ok(allStores);
    }
    @GetMapping(path="/getbyid/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id){
        Store storeById = storeService.getStoreById(id);
            return ResponseEntity.ok(storeById);
    }

    @PostMapping(path = "/post")
    public ResponseEntity<Long> saveNewStore(@RequestBody Store store){
        Long aLong = storeService.saveNewStore(store);
        return ResponseEntity.ok(aLong);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteStoreById(@PathVariable Long id){
        storeService.deleteStoreById(id);
        return ResponseEntity.ok().build();
}

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateStore(@RequestBody Store store){
        storeService.updateStore(store);
        return ResponseEntity.ok().build();
    }

}
