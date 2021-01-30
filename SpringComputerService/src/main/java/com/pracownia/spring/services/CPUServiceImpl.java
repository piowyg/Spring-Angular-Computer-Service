package com.pracownia.spring.services;

import com.pracownia.spring.entities.CPU;
import com.pracownia.spring.repositories.CPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CPUServiceImpl implements CPUService {

    @Autowired
    private CPURepository cpuRepository;

    @Override
    public Iterable<CPU> listAllCPUs() {
        return cpuRepository.findAll();
    }

    @Override
    public List<CPU> getCPUById(Integer id) {
        return cpuRepository.getCPUById(id);
    }

    @Override
    public long getNumberOfCPUs() {
        return cpuRepository.count();
    }

    @Override
    public List<CPU> getByName(String name) {
        return cpuRepository.findByName(name);
    }

    @Override
    public List<CPU> getByPrice(Integer price) {
        return cpuRepository.getCPUSByPrice(price);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (cpuRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public CPU saveCPU(CPU cpu) {
        return cpuRepository.save(cpu);
    }

    @Override
    public void deleteCPU(Integer id) {
        cpuRepository.deleteById(id);
    }

    @Override
    public void deleteAllCPU() {
        cpuRepository.deleteAll();
    }

    @Override
    public void editCPUName(Integer id, String name) {
        cpuRepository.findById(id).get().setName(name);
    }

    @Override
    public void editCPUPrice(Integer id, Integer price) {
        cpuRepository.findById(id).get().setPrice(price);
    }
}
