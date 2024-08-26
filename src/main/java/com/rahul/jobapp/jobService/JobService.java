package com.rahul.jobapp.jobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.jobapp.model.JobPost;
import com.rahul.jobapp.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository jobRepo;
	
	public JobPost addJobPost(JobPost jobpost) {
        return jobRepo.save(jobpost);
    }
	
	public JobPost getJobById(int id) {
		// TODO Auto-generated method stub
		return jobRepo.findById(id).orElse(null);
	}
	
	public List<JobPost> getAllJobs() {
		return jobRepo.findAll();
	}
	
	public JobPost updateJobPost(int id, JobPost updatedJobPost) {
		if(jobRepo.existsById(id)) {
			updatedJobPost.setPostId(id);
			return jobRepo.save(updatedJobPost);
		}
		else{
			return null;
		}
	}
	

	public void deletJobById(int id) {
		if(jobRepo.existsById(id)) {
			jobRepo.deleteById(id);
		}
	}


	
	
	
	

}
