package com.codeburps.repository;

import com.codeburps.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Set<Item> findByIdIn(Set<Integer> ids);

    @Modifying
    @Query("update Item i set i.availableQuantity = :availableQuantity where i.itemId = :itemId")
    int updateAvailableQuantity(@Param("itemId") int itemId, @Param("availableQuantity") int availableQuantity);
}
