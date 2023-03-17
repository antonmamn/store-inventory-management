package management.store.repository;

import management.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepositoryJPA extends JpaRepository<Store,Long > {
    @Modifying(clearAutomatically = true)
    @Query("update Store s set s.status= :status where s.id= :id")
    void updateStatusById(Long id,int status);
}
