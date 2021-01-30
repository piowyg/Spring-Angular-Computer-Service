package com.pracownia.spring;

import com.pracownia.spring.controllers.ComputerController;
import com.pracownia.spring.controllers.IndexController;
import com.pracownia.spring.entities.Computer;
import com.pracownia.spring.services.ComputerService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addingTest {
    @Autowired
    ComputerService computerService;

    @Autowired
    IndexController indexController;
    @Ignore
    @Test
    public void addingTest()
    {
        computerService.deleteAllComputers();
        indexController.test();
        Iterable<Computer> list = computerService.listAllComputers();
        List<Computer> computerList = new ArrayList<>();
        for(Computer computer : list)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(1,computerList.size());

        indexController.test();
        Iterable<Computer> list2 = computerService.listAllComputers();
        computerList.clear();
        for(Computer computer : list2)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(2,computerList.size());
    }
}
