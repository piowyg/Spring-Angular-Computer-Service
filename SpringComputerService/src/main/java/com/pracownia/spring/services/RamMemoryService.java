package com.pracownia.spring.services;

import com.pracownia.spring.entities.RamMemory;

import java.util.List;
import java.util.Optional;

public interface RamMemoryService {

    Iterable<RamMemory> listAllRamMemories();

    List<RamMemory> getRamMemoryById(Integer id);

    long getNumberOfRamMemories();

    List<RamMemory> getByName(String name);

    List<RamMemory> getByPrice(Integer price);

    Boolean checkIfExist(Integer id);

    RamMemory saveRamMemory(RamMemory RamMemory);

    void deleteRamMemory(Integer id);

    void deleteAllRamMemories();

    void editRamMemoryName(Integer id, String name);

    void editRamMemoryPrice(Integer id, Integer price);

    void setRamMemoryInComputer(Integer idRamMemory, Integer idComputer);

    void removeRamMemoryFromComputer(Integer idRamMemory, Integer idComputer);
}
