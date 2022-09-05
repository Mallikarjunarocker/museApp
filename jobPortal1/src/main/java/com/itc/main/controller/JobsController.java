package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.Jobs;
import com.itc.main.services.JobsService;

@RestController
@RequestMapping("/api/")
public class JobsController {
	@Autowired
	private JobsService jobsService;
	
	@PostMapping("save")
	public ResponseEntity saveJobs(@RequestBody Jobs job) {
		this.jobsService.savejob(job);
		return new ResponseEntity("SUCESSFULLY CREATED", HttpStatus.OK);
	}
	
	@GetMapping("jobs")
	public ResponseEntity getJobs() {
		List<Jobs> li = this.jobsService.getAllJobs();
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("getjobs/{location}")
	public ResponseEntity getJobsByLocation(@PathVariable String location) {
		List<Jobs> li = this.jobsService.getJobsByLocation(location);
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("jobs/{id}")
	public ResponseEntity getJobsById(@PathVariable int id) {
		Jobs li = this.jobsService.getJobsById(id);
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("jobs/{id}")
	public ResponseEntity deleteJobs(@PathVariable int id) {
		boolean b = this.jobsService.DeleteJobs(id);
		if(b) {
			return new ResponseEntity("DELETED SUCCESFULLY",HttpStatus.OK);
			
		}
		else 
			return new ResponseEntity("NOT_FOUND",HttpStatus.NOT_FOUND);
	}
	
	

}
