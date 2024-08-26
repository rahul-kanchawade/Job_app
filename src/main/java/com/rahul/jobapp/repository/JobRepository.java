package com.rahul.jobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jobapp.model.JobPost;

@Repository
public interface JobRepository extends  JpaRepository<JobPost, Integer> {

}
