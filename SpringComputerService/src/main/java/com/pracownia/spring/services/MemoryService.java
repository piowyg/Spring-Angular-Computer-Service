package com.pracownia.spring.services;

import com.pracownia.spring.entities.Memory;

import java.util.List;
import java.util.Optional;

public interface MemoryService {

    Iterable<Memory> listAllMemories();

    List<Memory> getMemoryById(Integer id);

    long getNumberOfMemories();

    List<Memory> getByName(String name);

    List<Memory> getByPrice(Integer price);

    Boolean checkIfExist(Integer id);

    Memory saveMemory(Memory memory);

    void deleteAllMemories();

    void deleteMemory(Integer id);

    void editMemoryName(Integer id, String name);

    void editMemoryPrice(Integer id, Integer price);

    void setMemoryInComputer(Integer idMemory, Integer idComputer);

    void removeMemoryFromComputer(Integer idMemory, Integer idComputer);

}
