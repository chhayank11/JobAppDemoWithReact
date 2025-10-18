package com.xyzgaming.JobAppSpringReact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzgaming.JobAppSpringReact.dao.JobRepo;
import com.xyzgaming.JobAppSpringReact.model.JobPost;

@Service
public class JobService {

	JobRepo jobRepo;

	public void addJob(JobPost jobPost) {
		jobRepo.addJob(jobPost);
	}

	public List<JobPost> getAllJobs() {
		return jobRepo.getAllJobs();
	}

	public JobPost getJob(int postID) {
		return jobRepo.getJob(postID);
	}

	public void updateJob(JobPost jobPost) {
		jobRepo.update(jobPost);

	}

	public void deleteJob(int postId) {
		jobRepo.deleteJob(postId);

	}

	// --------------------------
	public JobRepo getJobRepo() {
		return jobRepo;
	}

	@Autowired
	public void setJobRepo(JobRepo jobRepo) {
		this.jobRepo = jobRepo;
	}

}
