package com.estuate.resourceallocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.estuate.resourceallocation.dto.Resource;
import com.estuate.resourceallocation.service.MyService;

@Controller
public class MyController {

	@Autowired
	MyService service;

	@GetMapping("/save")
	public String saveData(Resource resource, ModelMap map) {
		map.put("resource", resource);
		return "data.html";
	}

	@PostMapping("/save")
	public String saveData(Resource resource) {
		return service.savedata(resource);
	}

	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}

	@PostMapping("/search")
	public String search(@RequestParam String skills, @RequestParam int minexperience, @RequestParam int maxexperience,Resource resource, ModelMap map) {
		return service.searchData(skills, minexperience, maxexperience, map);
	}
}
