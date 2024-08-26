package com.rahul.jobapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rahul.jobapp.jobService.JobService;



@SpringBootApplication
public class JobAppApplication{
	
	@Autowired
	JobService jobService;

	public static void main(String[] args) {
		SpringApplication.run(JobAppApplication.class, args);
		
	}

}