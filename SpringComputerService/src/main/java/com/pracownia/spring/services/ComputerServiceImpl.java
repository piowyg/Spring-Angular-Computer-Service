package com.pracownia.spring.services;

import com.pracownia.spring.entities.Computer;
import com.pracownia.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private RamRepository ramRepository;

    @Override
    public Iterable<Computer> listAllComputers() {
        return computerRepository.findAll();
    }

    @Override
    public Iterable<Computer> getComputerById(Integer id) {
        return computerRepository.getComputerById(id);
    }

    @Override
    public long getNumberOfComputers() {
        return computerRepository.count();
    }

    @Override
    public List<Computer> getByName(String name) {
        return computerRepository.findByName(name);
    }

    @Override
    public List<Computer> getByPrice(Integer price) {
        return computerRepository.getComputersByPrice(price);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (computerRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


    @Override
    public Computer saveComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public void deleteComputer(Integer id) {
        computerRepository.deleteById(id);
    }

    @Override
    public void deleteAllComputers() {
        computerRepository.deleteAll();
    }

    @Override
    public void editComputerName(Integer id, String name) {
        computerRepository.findById(id).get().setName(name);
    }

    @Override
    public void editComputerPrice(Integer id, Integer price) {
        computerRepository.findById(id).get().setPrice(price);
    }

    @Override
    public void changeComputerCPU(Integer id, Integer idCPU) {
        computerRepository.findById(id).get().setCpu_id(cpuRepository.findById(idCPU).get());
    }

    @Override
    public void changeComputerGPU(Integer id, Integer idGPU) {
        computerRepository.findById(id).get().setGpu_id(gpuRepository.findById(idGPU).get());
    }

    @Override
    public void removeComputerRam(Integer id, Integer idRam) {
        computerRepository.findById(id).get().getRamMemory().remove(ramRepository.findById(idRam).get());
        ramRepository.findById(idRam).get().setComputer(null);
    }

    @Override
    public void addComputerRam(Integer id, Integer idRam) {
        computerRepository.findById(id).get().getRamMemory().add(ramRepository.findById(idRam).get());
        ramRepository.findById(idRam).get().setComputer(computerRepository.findById(id).get());
    }

    @Override
    public void removeComputerMemory(Integer id, Integer idMemory) {
        computerRepository.findById(id).get().getMemory().remove(memoryRepository.findById(idMemory).get());
        memoryRepository.findById(idMemory).get().setComputer(null);
    }

    @Override
    public void addComputerMemory(Integer id, Integer idMemory) {
        computerRepository.findById(id).get().getMemory().add(memoryRepository.findById(idMemory).get());
        memoryRepository.findById(idMemory).get().setComputer(computerRepository.findById(id).get());
    }
}
