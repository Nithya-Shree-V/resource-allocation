package com.estuate.resourceallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estuate.resourceallocation.dto.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
	
	  @Query("SELECT DISTINCT r FROM Resource r JOIN r.skills s WHERE s IN :skills AND r.experience BETWEEN :minexperience AND :maxexperience")
	    List<Resource> findBySkillsAndExperienceRange(@Param("skills") List<String> skills, @Param("minexperience") int minexperience, @Param("maxexperience") int maxexperience);
}
