package com.itc.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Jobs;
import com.itc.main.repository.JobsRepository;

@Service
public class JobsService {
	@Autowired

	private JobsRepository jobsRepository;
	public void savejob(Jobs j1) {
		this.jobsRepository.save(j1);
		
	}
	public List<Jobs> getAllJobs(){
		List<Jobs> l1 = this.jobsRepository.findAll();
		return l1;
	}
	public List<Jobs> getJobsByLocation(String Location){
		List<Jobs> l1 = this.jobsRepository.findJobsByLocation(Location);
		return l1;
	}
	public Jobs getJobsById(int JobId){
		Optional<Jobs> l1 = this.jobsRepository.findById(JobId);
		if(l1.isPresent()) {
			return l1.get();
		}
		else 
				return null;
		
	}
	public boolean DeleteJobs(int JobId) {
		this.jobsRepository.deleteById(JobId);
		return true;
	}
	

}
