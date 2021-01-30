package com.pracownia.spring.repositories;


import com.pracownia.spring.entities.RamMemory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RamRepository extends CrudRepository<RamMemory, Integer> {

    List<RamMemory> findByName(String name);

    List<RamMemory> getRamMemoriesByPrice(Integer price);

    List<RamMemory> getRamMemoriesById(Integer id);

    @Query("select count(*) from RamMemory p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
