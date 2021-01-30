package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Memory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemoryRepository extends CrudRepository<Memory, Integer> {

    List<Memory> findByName(String name);

    List<Memory> getMemoriesById(Integer id);

    List<Memory> getMemoriesByPrice(Integer price);

    @Query("select count(*) from Memory p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
