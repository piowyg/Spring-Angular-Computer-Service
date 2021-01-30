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
public class removingTest {
    @Autowired
    ComputerService computerService;

    @Autowired
    IndexController indexController;
    @Ignore
    @Test
    public void removingTest()
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

        computerService.deleteComputer(2);

        Iterable<Computer> list3 = computerService.listAllComputers();
        computerList.clear();
        for(Computer computer : list3)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(1,computerList.size());

        computerService.deleteComputer(1);

        Iterable<Computer> list4 = computerService.listAllComputers();
        computerList.clear();
        for(Computer computer : list4)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(0,computerList.size());

        indexController.test();
        indexController.test();

        Iterable<Computer> list5 = computerService.listAllComputers();
        computerList.clear();
        for(Computer computer : list5)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(2,computerList.size());
        computerService.deleteAllComputers();

        Iterable<Computer> list6 = computerService.listAllComputers();
        computerList.clear();
        for(Computer computer : list6)
        {
            computerList.add(computer);
        }
        Assert.assertEquals(computerService.getNumberOfComputers(),computerList.size());
        Assert.assertEquals(0,computerList.size());

    }
}
