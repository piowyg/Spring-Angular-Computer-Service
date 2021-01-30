package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.GPU;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GPURepository extends CrudRepository<GPU, Integer> {

    List<GPU> findByName(String name);

    List<GPU> getGPUSByPrice(Integer price);

    List<GPU> getGPUById(Integer price);

    @Query("select count(*) from GPU p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
