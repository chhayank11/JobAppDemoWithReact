package com.xyzgaming.JobAppSpringReact.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xyzgaming.JobAppSpringReact.model.JobPost;

@Repository
public class JobRepo {

	// arrayList to store store JobPost objects
	List<JobPost> jobs = new ArrayList<>();

	// ****************************************************************************

	// constructor->injecting objects into ArrayList defined above.
	public JobRepo() {

		// Java Developer Job Post
		jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
				List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

		// FrontEnd Developer Job Post
		jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
				3, List.of("HTML", "CSS", "JavaScript", "React")));

		// Data Scientist Job Post
		jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
				List.of("Python", "Machine Learning", "Data Analysis")));

		// Network Engineer Job Post
		jobs.add(new JobPost(4, "Network Engineer",
				"Design and implement computer networks for efficient data communication", 5,
				List.of("Networking", "Cisco", "Routing", "Switching")));

		// Mobile APP Developer Job Post
		jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
				List.of("iOS Development", "Android Development", "Mobile App")));

	}

	public void addJob(JobPost jobPost) {
		jobs.add(jobPost);

	}

	public List<JobPost> getAllJobs() {
		return jobs;
	}

	public JobPost getJob(int postID) {

		for (JobPost job : jobs) {
			if (job.getPostId() == postID) {
				return job;
			}
		}

		return null;
	}

	public void update(JobPost jobPost) {

		for (JobPost job : jobs) {
			if (jobPost.getPostId() == job.getPostId()) {
				job.setPostId(jobPost.getPostId());
				job.setPostDesc(jobPost.getPostDesc());
				job.setPostProfile(jobPost.getPostProfile());
				job.setReqExperience(jobPost.getReqExperience());
				job.setPostTechStack(jobPost.getPostTechStack());
				break;
			}
		}
	}

	public void deleteJob(int postId) {

		for (JobPost job : jobs) {
			if (postId == job.getPostId()) {
				jobs.remove(job);
			}
		}
	}

}
