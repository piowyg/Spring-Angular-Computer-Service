package com.pracownia.spring.services;

import com.pracownia.spring.entities.GPU;

import com.pracownia.spring.repositories.GPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GPUServiceImpl implements GPUService{

    @Autowired
    private GPURepository gpuRepository;

    @Override
    public Iterable<GPU> listAllGPUs() {
        return gpuRepository.findAll();
    }

    @Override
    public List<GPU> getGPUById(Integer id) {
        return gpuRepository.getGPUById(id);
    }

    @Override
    public long getNumberOfGPUs() {
        return gpuRepository.count();
    }

    @Override
    public List<GPU> getByName(String name) {
        return gpuRepository.findByName(name);
    }

    @Override
    public List<GPU> getByPrice(Integer price) {
        return gpuRepository.getGPUSByPrice(price);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (gpuRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public GPU saveGPU(GPU gpu) {
        return gpuRepository.save(gpu);
    }

    @Override
    public void deleteGPU(Integer id) {
        gpuRepository.deleteById(id);
    }

    @Override
    public void deleteAllGPU() {
        gpuRepository.deleteAll();
    }

    @Override
    public void editGPUName(Integer id, String name) {
            gpuRepository.findById(id).get().setName(name);
    }

    @Override
    public void editGPUPrice(Integer id, Integer price) {
        gpuRepository.findById(id).get().setPrice(price);
    }
}
