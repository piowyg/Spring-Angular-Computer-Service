package com.pracownia.spring.services;

import com.pracownia.spring.entities.CPU;

import java.util.List;
import java.util.Optional;

public interface CPUService {

    Iterable<CPU> listAllCPUs();

    List<CPU> getCPUById(Integer id);

    long getNumberOfCPUs();

    List<CPU> getByName(String name);

    List<CPU> getByPrice(Integer price);

    Boolean checkIfExist(Integer id);

    CPU saveCPU(CPU cpu);

    void deleteCPU(Integer id);

    void deleteAllCPU();

    void editCPUName(Integer id, String name);

    void editCPUPrice(Integer id, Integer price);
}
