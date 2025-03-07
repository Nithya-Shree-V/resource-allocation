package com.estuate.resourceallocation.dto;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int experience;

	
	@ElementCollection
	@CollectionTable(name = "resource_skills", joinColumns = @JoinColumn(name = "id")) 
	@Column(name = "skill")
	private List<String> skills;


	
	
}
