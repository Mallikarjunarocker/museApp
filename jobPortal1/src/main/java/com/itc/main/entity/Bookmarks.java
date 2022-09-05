package com.itc.main.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bookMarks")
public class Bookmarks {
	@Id
	int jobId;
	String jobName;
	String url;
	String location;
	LocalDateTime createdAt = LocalDateTime.now();
	public Bookmarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookmarks(int jobId, String jobName, String url, String location, LocalDateTime createdAt) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.url = url;
		this.location = location;
		this.createdAt = createdAt;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Bookmarks [jobId=" + jobId + ", jobName=" + jobName + ", url=" + url + ", location=" + location
				+ ", createdAt=" + createdAt + "]";
	}
	

}
