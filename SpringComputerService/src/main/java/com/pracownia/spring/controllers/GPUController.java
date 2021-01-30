package com.pracownia.spring.controllers;


import com.pracownia.spring.entities.GPU;
import com.pracownia.spring.services.GPUService;
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

public class GPUController {

    @Autowired
    private GPUService gpuService;

    @CrossOrigin
    @RequestMapping(value = "/gpus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GPU> list()
    {
        return gpuService.listAllGPUs();
    }


    @CrossOrigin
    @RequestMapping(value = "/gpu/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GPU> getByPublicId(@PathVariable("id") Integer publicId) {
        return gpuService.getGPUById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/gpu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GPU> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return gpuService.getGPUById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/gpu", method = RequestMethod.POST)
    public ResponseEntity<GPU> create(@RequestBody @Valid @NotNull GPU gpu) {
        gpuService.saveGPU(gpu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @CrossOrigin
    @RequestMapping(value = "/gpu", method = RequestMethod.PUT)
    public Iterable<GPU> edit(@RequestBody @Valid @NotNull GPU gpu) {
        if(!gpuService.checkIfExist(gpu.getId()))
            return null;
        else {
            gpuService.saveGPU(gpu);
            return gpuService.getGPUById(gpu.getId());
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/gpus", method = RequestMethod.DELETE)
    public RedirectView deleteAll() {
        gpuService.deleteAllGPU();
        return new RedirectView("/api/gpus", true);
    }


    @CrossOrigin
    @RequestMapping(value = "/gpu/{id}", method = RequestMethod.DELETE)
    public Iterable<GPU> delete(@PathVariable Integer id) {
        gpuService.deleteGPU(id);
        return gpuService.listAllGPUs();
    }

    @CrossOrigin
    @RequestMapping(value = "/gpuAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long amount()
    {
        return gpuService.getNumberOfGPUs();
    }
}
