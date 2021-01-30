package com.pracownia.spring.services;

import com.pracownia.spring.entities.GPU;

import java.util.List;
import java.util.Optional;

public interface GPUService {

    Iterable<GPU> listAllGPUs();

    List<GPU> getGPUById(Integer id);

    long getNumberOfGPUs();

    List<GPU> getByName(String name);

    List<GPU> getByPrice(Integer price);

    Boolean checkIfExist(Integer id);

    GPU saveGPU(GPU gpu);

    void deleteGPU(Integer id);

    void deleteAllGPU();

    void editGPUName(Integer id, String name);

    void editGPUPrice(Integer id, Integer price);
}
