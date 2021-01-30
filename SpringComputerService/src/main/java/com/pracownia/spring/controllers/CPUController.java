package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.CPU;
import com.pracownia.spring.services.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class CPUController {

    @Autowired
    private CPUService cpuService;

    @CrossOrigin
    @RequestMapping(value = "/cpus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CPU> list()
    {
        return cpuService.listAllCPUs();
    }

    @CrossOrigin
    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CPU> getByPublicId(@PathVariable("id") Integer publicId) {
        return cpuService.getCPUById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/cpu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CPU> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return cpuService.getCPUById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/cpu", method = RequestMethod.POST)
    public ResponseEntity<CPU> create(@RequestBody @Valid @NotNull CPU cpu) {
        cpuService.saveCPU(cpu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/cpu", method = RequestMethod.PUT)
    public Iterable<CPU> edit(@RequestBody @Valid @NotNull CPU cpu) {
        if(!cpuService.checkIfExist(cpu.getId()))
            return null;
        else {
            cpuService.saveCPU(cpu);
            return cpuService.getCPUById(cpu.getId());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/cpus", method = RequestMethod.DELETE)
    public RedirectView deleteAll() {
        cpuService.deleteAllCPU();
        return new RedirectView("/api/cpus", true);
    }


    @CrossOrigin
    @RequestMapping(value = "/cpu/{id}", method = RequestMethod.DELETE)
    public Iterable<CPU> delete(@PathVariable Integer id) {
        cpuService.deleteCPU(id);
        return cpuService.listAllCPUs();
    }

    @CrossOrigin
    @RequestMapping(value = "/cpuAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long amount()
    {
        return cpuService.getNumberOfCPUs();
    }
}
