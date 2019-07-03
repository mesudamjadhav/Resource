package com.yash.test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.services.FileUploadService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class MachineLearningTest {

    @Autowired
	private FileUploadService fileUploadService;
    
    @Test
    public void test_ml_always_return_true() {
    	System.out.println(fileUploadService.getAllEmployee());
        assertThat(fileUploadService.getAllEmployee(), instanceOf(List.class));


    }
}