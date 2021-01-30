package com.pracownia.spring.services;

import com.pracownia.spring.entities.Memory;
import com.pracownia.spring.repositories.ComputerRepository;
import com.pracownia.spring.repositories.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoryServiceImpl implements MemoryService{

    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public Iterable<Memory> listAllMemories() {
        return memoryRepository.findAll();
    }

    @Override
    public List<Memory> getMemoryById(Integer id) {
        return memoryRepository.getMemoriesById(id);
    }

    @Override
    public long getNumberOfMemories() {
        return memoryRepository.count();
    }

    @Override
    public List<Memory> getByName(String name) {
        return memoryRepository.findByName(name);
    }

    @Override
    public List<Memory> getByPrice(Integer price) {
        return memoryRepository.getMemoriesByPrice(price);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (memoryRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Memory saveMemory(Memory memory) {
        return memoryRepository.save(memory);
    }

    @Override
    public void deleteAllMemories() {
        memoryRepository.deleteAll();
    }

    @Override
    public void deleteMemory(Integer id) {
        memoryRepository.deleteById(id);

    }

    @Override
    public void editMemoryName(Integer id, String name) {
        memoryRepository.findById(id).get().setName(name);
    }

    @Override
    public void editMemoryPrice(Integer id, Integer price) {
        memoryRepository.findById(id).get().setPrice(price);
    }

    @Override
    public void setMemoryInComputer(Integer idMemory, Integer idComputer) {
        memoryRepository.findById(idMemory).get().setComputer(computerRepository.getComputerById(idComputer).get(0));
        computerRepository.findById(idComputer).get().getMemory().add(memoryRepository.findById(idMemory).get());
    }

    @Override
    public void removeMemoryFromComputer(Integer idMemory, Integer idComputer) {
        memoryRepository.findById(idMemory).get().setComputer(null);
        computerRepository.getComputerById(idComputer).get(0).getMemory().remove(memoryRepository.findById(idMemory).get());
    }
}
