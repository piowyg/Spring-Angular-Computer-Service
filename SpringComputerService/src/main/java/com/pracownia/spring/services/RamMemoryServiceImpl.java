package com.pracownia.spring.services;


import com.pracownia.spring.entities.RamMemory;
import com.pracownia.spring.repositories.ComputerRepository;
import com.pracownia.spring.repositories.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RamMemoryServiceImpl implements RamMemoryService {

    @Autowired
    private RamRepository ramRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public Iterable<RamMemory> listAllRamMemories() {
        return ramRepository.findAll();
    }

    @Override
    public List<RamMemory> getRamMemoryById(Integer id) {
        return ramRepository.getRamMemoriesById(id);
    }

    @Override
    public long getNumberOfRamMemories() {
        return ramRepository.count();
    }

    @Override
    public List<RamMemory> getByName(String name) {
        return ramRepository.findByName(name);
    }

    @Override
    public List<RamMemory> getByPrice(Integer price) {
        return ramRepository.getRamMemoriesByPrice(price);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (ramRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public RamMemory saveRamMemory(RamMemory RamMemory) {
        return ramRepository.save(RamMemory);
    }

    @Override
    public void deleteRamMemory(Integer id) {
        ramRepository.deleteById(id);
    }

    @Override
    public void deleteAllRamMemories() {
        ramRepository.deleteAll();
    }

    @Override
    public void editRamMemoryName(Integer id, String name) {
        ramRepository.findById(id).get().setName(name);
    }

    @Override
    public void editRamMemoryPrice(Integer id, Integer price) {
        ramRepository.findById(id).get().setPrice(price);
    }

    @Override
    public void setRamMemoryInComputer(Integer idRamMemory, Integer idComputer) {
        ramRepository.findById(idRamMemory).get().setComputer(computerRepository.getComputerById(idComputer).get(0));
        computerRepository.findById(idComputer).get().getRamMemory().add(ramRepository.findById(idRamMemory).get());
    }

    @Override
    public void removeRamMemoryFromComputer(Integer idRamMemory, Integer idComputer) {
        ramRepository.findById(idRamMemory).get().setComputer(null);
        computerRepository.getComputerById(idComputer).get(0).getRamMemory().remove(ramRepository.findById(idRamMemory).get());
    }
}
