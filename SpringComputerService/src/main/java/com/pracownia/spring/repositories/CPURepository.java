package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.CPU;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CPURepository extends CrudRepository<CPU, Integer> {

    List<CPU> findByName(String name);

    List<CPU> getCPUById(Integer id);

    List<CPU> getCPUSByPrice(Integer price);

    @Query("select count(*) from CPU p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
