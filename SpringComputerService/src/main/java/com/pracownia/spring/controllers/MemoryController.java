package com.pracownia.spring.controllers;


import com.pracownia.spring.entities.Memory;
import com.pracownia.spring.services.MemoryService;
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
public class MemoryController {

    @Autowired
    private MemoryService memoryService;


    @CrossOrigin
    @RequestMapping(value = "/memories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Memory> list()
    {
        return memoryService.listAllMemories();
    }


    @CrossOrigin
    @RequestMapping(value = "/memory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Memory> getByPublicId(@PathVariable("id") Integer publicId) {
        return memoryService.getMemoryById(publicId);
    }


    @CrossOrigin
    @RequestMapping(value = "/memory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Memory> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return memoryService.getMemoryById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/memory", method = RequestMethod.POST)
    public ResponseEntity<Memory> create(@RequestBody @Valid @NotNull Memory memory) {
        memoryService.saveMemory(memory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/memory", method = RequestMethod.PUT)
    public Iterable<Memory> edit(@RequestBody @Valid @NotNull Memory memory) {
        if(!memoryService.checkIfExist(memory.getId()))
            return null;
        else {
            memoryService.saveMemory(memory);
            return memoryService.getMemoryById(memory.getId());
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/memories", method = RequestMethod.DELETE)
    public RedirectView deleteAll() {
        memoryService.deleteAllMemories();
        return new RedirectView("/api/memories", true);
    }


    @CrossOrigin
    @RequestMapping(value = "/memory/{id}", method = RequestMethod.DELETE)
    public Iterable<Memory> delete(@PathVariable Integer id) {
        memoryService.deleteMemory(id);
        return memoryService.listAllMemories();
    }

    @CrossOrigin
    @RequestMapping(value = "/memoryAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long amount()
    {
        return memoryService.getNumberOfMemories();
    }
}
