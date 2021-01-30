package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Computer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComputerRepository extends CrudRepository<Computer, Integer> {

    List<Computer> findByName(String name);

    List<Computer> getComputersByPrice(Integer price);

    @Query("select count(*) from Computer p where p.id = ?1")
    Integer checkIfExist(Integer id);

    List<Computer> getComputerById(Integer id);
}
