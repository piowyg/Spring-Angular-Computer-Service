package com.pracownia.spring;

import com.pracownia.spring.controllers.ComputerController;
import com.pracownia.spring.controllers.IndexController;
import com.pracownia.spring.entities.Computer;
import com.pracownia.spring.services.ComputerService;
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
public class WebAppApplicationTests {

	@Autowired
	ComputerService computerService;

	@Autowired
	IndexController indexController;

	@Test
	public void contextLoads() {

		computerService.deleteAllComputers();
		indexController.test();
		Iterable<Computer> list = computerService.getComputerById(1);
		List<Computer> computerList = new ArrayList<>();
		for(Computer computer : list)
		{
			computerList.add(computer);
		}
		Assert.assertEquals(computerList.get(0).getName(),"Gaming computer");
		Assert.assertEquals(computerList.get(0).getPrice(),3500);
		Assert.assertEquals(computerList.get(0).getId(),1);
	}
}
