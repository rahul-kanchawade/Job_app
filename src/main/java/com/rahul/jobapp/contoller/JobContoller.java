package com.rahul.jobapp.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.jobapp.jobService.JobService;
import com.rahul.jobapp.model.JobPost;

@RestController
public class JobContoller {
	@Autowired
	JobService jobService;

	@GetMapping({"/","home"})
	public String home() {
		return "Welcome to Job App";
	}
	
	@PostMapping("/add-job")
	public ResponseEntity<JobPost> addJobPost(@RequestBody JobPost jobPost) {
		JobPost jobPost1 = jobService.addJobPost(jobPost);
		
		return new ResponseEntity<>(jobPost1, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<JobPost> findJobById(@PathVariable int id) {
		JobPost jobPost = jobService.getJobById(id);
		if(jobPost != null) {
			return new ResponseEntity<>(jobPost, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all-jobs")
	public List<JobPost> getAllJobs() {
		return jobService.getAllJobs();
	}
	
	@PutMapping("/updateJob/{id}")
	public ResponseEntity<JobPost> updateJobPost(@PathVariable int id, @RequestBody JobPost UpdatedJobPost) {
		JobPost updatedJobPost = jobService.updateJobPost(id, UpdatedJobPost);
		if(updatedJobPost!=null) {
			return new ResponseEntity<>(updatedJobPost, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	@DeleteMapping("/delete-job/{id}")
	public ResponseEntity<Void> deleteJobById(@PathVariable int id) {
		 if (jobService.getJobById(id) != null) {
			 jobService.deletJobById(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
		 else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 }
	}

}
