package com.itc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.main.entity.Jobs;
@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {

	List<Jobs> findJobsByLocation(String location);

}
