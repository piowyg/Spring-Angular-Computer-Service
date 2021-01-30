package com.pracownia.spring.controllers;


import com.pracownia.spring.entities.RamMemory;
import com.pracownia.spring.services.RamMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class RamMemoryController {

    @Autowired
    private RamMemoryService ramMemoryService;


    @CrossOrigin
    @RequestMapping(value = "/ramMemories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RamMemory> list()
    {
        return ramMemoryService.listAllRamMemories();
    }


    @CrossOrigin
    @RequestMapping(value = "/ramMemory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RamMemory> getByPublicId(@PathVariable("id") Integer publicId) {
        return ramMemoryService.getRamMemoryById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/ramMemory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<RamMemory> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return ramMemoryService.getRamMemoryById(publicId);
    }


    @CrossOrigin
    @RequestMapping(value = "/ramMemory", method = RequestMethod.POST)
    public ResponseEntity<RamMemory> create(@RequestBody @Valid @NotNull RamMemory ramMemory) {
        ramMemoryService.saveRamMemory(ramMemory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @CrossOrigin
    @RequestMapping(value = "/ramMemory", method = RequestMethod.PUT)
    public Iterable<RamMemory> edit(@RequestBody @Valid @NotNull RamMemory ramMemory) {
        if(!ramMemoryService.checkIfExist(ramMemory.getId()))
            return null;
        else {
            ramMemoryService.saveRamMemory(ramMemory);
            return ramMemoryService.getRamMemoryById(ramMemory.getId());
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/ramMemories", method = RequestMethod.DELETE)
    public RedirectView deleteAll() {
        ramMemoryService.deleteAllRamMemories();
        return new RedirectView("/api/ramMemories", true);
    }


    @CrossOrigin
    @RequestMapping(value = "/ramMemory/{id}", method = RequestMethod.DELETE)
    public Iterable<RamMemory> delete(@PathVariable Integer id) {
        ramMemoryService.deleteRamMemory(id);
        return ramMemoryService.listAllRamMemories();
    }

    @CrossOrigin
    @RequestMapping(value = "/ramMemoryAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long amount()
    {
        return ramMemoryService.getNumberOfRamMemories();
    }
}
