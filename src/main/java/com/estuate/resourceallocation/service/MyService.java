package com.estuate.resourceallocation.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import com.estuate.resourceallocation.dto.Resource;
import com.estuate.resourceallocation.repository.ResourceRepository;

@Service
public class MyService {
	@Autowired
	ResourceRepository repository;

	public String searchData(String skills, int minexperience,int maxexperience, ModelMap map) {
		List<Resource> resources = repository.findBySkillsAndExperienceRange(skills, minexperience, maxexperience);
		map.put("resources", resources);
		return  "result.html";
		
	}

	public String savedata(Resource resource) {
		repository.save(resource);
		return "data.html";
	}



	

}
