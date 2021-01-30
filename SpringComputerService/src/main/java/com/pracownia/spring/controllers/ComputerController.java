package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Computer;
import com.pracownia.spring.services.ComputerService;
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
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @CrossOrigin
    @RequestMapping(value = "/computers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Computer> list2()
    {
        return computerService.listAllComputers();
    }

    @CrossOrigin
    @RequestMapping(value = "/computer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Computer> getComputerById(@PathVariable("id") Integer publicId) {
        return computerService.getComputerById(publicId);
    }

    @CrossOrigin
    @RequestMapping(value = "/computer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Computer> getByParamPublicId(@RequestParam("id") Integer publicId) {
        return computerService.getComputerById(publicId);
    }


    @CrossOrigin
    @RequestMapping(value = "/computer", method = RequestMethod.POST)
    public ResponseEntity<Computer> create(@RequestBody @Valid @NotNull Computer computer) {
        computerService.saveComputer(computer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/computer", method = RequestMethod.PUT)
    public Iterable<Computer> edit(@RequestBody @Valid @NotNull Computer computer) {
        if(!computerService.checkIfExist(computer.getId()))
            return null;
        else {
            computerService.saveComputer(computer);
            return computerService.getComputerById(computer.getId());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/computers", method = RequestMethod.DELETE)
    public RedirectView deleteAll() {
        computerService.deleteAllComputers();
        return new RedirectView("/api/computers", true);
    }


    @CrossOrigin
    @RequestMapping(value = "/computer/{id}", method = RequestMethod.DELETE)
    public Iterable<Computer> delete(@PathVariable Integer id) {
        computerService.deleteComputer(id);
        return computerService.listAllComputers();
    }


    @CrossOrigin
    @RequestMapping(value = "/computerAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long amount()
    {
        return computerService.getNumberOfComputers();
    }
}
