package com.xyzgaming.JobAppSpringReact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzgaming.JobAppSpringReact.model.JobPost;
import com.xyzgaming.JobAppSpringReact.service.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

	JobService service;

	@GetMapping("jobposts")
	public List<JobPost> viewAllJobs() {
		return service.getAllJobs();
	}

	@GetMapping("jobpost/{postId}")
	public JobPost viewJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}

	@PostMapping("jobpost")
	public JobPost addJob(@RequestBody JobPost jobPost) {

		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}

	@PutMapping("jobpost")
	public List<JobPost> updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getAllJobs();

	}

	@DeleteMapping("jobpost/{postId}")
	public String deleteJob(@PathVariable("postId") int postId) {
		service.deleteJob(postId);
		return "deleted";
	}

	// ---------getter setters--------------
	public JobService getService() {
		return service;
	}

	@Autowired
	public void setService(JobService service) {
		this.service = service;
	}

}
