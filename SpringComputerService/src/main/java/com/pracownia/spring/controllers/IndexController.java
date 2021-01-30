package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.*;
import com.pracownia.spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
public class IndexController {


    @CrossOrigin
    @RequestMapping(value = "")
    String index() {
        return "Welcome on my Webstie <br> Here is heart for u <br> <3";
    }

    @Autowired
    private ComputerService computerService;

    @Autowired
    private CPUService cpuService;

    @Autowired
    private GPUService gpuService;

    @Autowired
    private RamMemoryService ramMemoryService;

    @Autowired
    private MemoryService memoryService;

    @CrossOrigin
    @RequestMapping(value="test",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE)
    public String test()
    {
        Computer computer = new Computer();
        GPU gpu = new GPU();
        CPU cpu = new CPU();
        cpu.setPrice(2000);
        cpu.setName("intel");
        gpu.setName("rtx");
        gpu.setPrice(1000);

        Memory memory = new Memory();
        memory.setPrice(100);
        memory.setComputer(computer);
        memory.setName("1Tb");

        Memory memory1 = new Memory();
        memory1.setPrice(299);
        memory1.setComputer(computer);
        memory1.setName("500Gb");

        RamMemory ramMemory = new RamMemory();
        ramMemory.setComputer(computer);
        ramMemory.setPrice(150);
        ramMemory.setName("HyperX 16Gb");

        RamMemory ramMemory1= new RamMemory();
        ramMemory1.setComputer(computer);
        ramMemory1.setPrice(250);
        ramMemory1.setName("HyperX 16Gb");

        computer.setName("Gaming computer");
        computer.setPrice(3500);
        computer.setGpu_id(gpu);
        computer.setCpu_id(cpu);
        computer.setMemory(Arrays.asList(memory,memory1).stream().collect(Collectors.toList()));
        computer.setRamMemory(Arrays.asList(ramMemory,ramMemory1).stream().collect(Collectors.toList()));
        computerService.saveComputer(computer);
        gpuService.saveGPU(gpu);
        cpuService.saveCPU(cpu);
        ramMemoryService.saveRamMemory(ramMemory);
        ramMemoryService.saveRamMemory(ramMemory1);
        memoryService.saveMemory(memory);
        memoryService.saveMemory(memory1);

        return "test";
    }

}