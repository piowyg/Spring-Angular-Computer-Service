package com.pracownia.spring.services;

import com.pracownia.spring.entities.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerService {

    Iterable<Computer> listAllComputers();

    Iterable<Computer> getComputerById(Integer id);

    long getNumberOfComputers();

    List<Computer> getByName(String name);

    List<Computer> getByPrice(Integer price);

    Boolean checkIfExist(Integer id);



    Computer saveComputer(Computer computer);

    void deleteComputer(Integer id);

    void deleteAllComputers();

    void editComputerName(Integer id,String name);

    void editComputerPrice(Integer id, Integer price);

    void changeComputerCPU(Integer id, Integer idCPU); // bedziemy tu zmieniac na inne CPU

    void changeComputerGPU(Integer id, Integer idGPU); // bedziemy tu zmieniac GPU na inne

    void removeComputerRam(Integer id, Integer idRam); // usuwamy dany Ram

    void addComputerRam(Integer id, Integer idRam);   // dodajemy nowy Ram

    void removeComputerMemory(Integer id, Integer idMemory); // usuwamy dany Memory

    void addComputerMemory(Integer id, Integer idMemory);   // dodajemy nowy Memory
}
