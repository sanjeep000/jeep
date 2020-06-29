package com.example.vision.pathology_service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vision.pathology_service.model.Disease;
import com.example.vision.pathology_service.model.DiseaseList;

@RestController
@RequestMapping("/rest")
public class DiseaseResource {
	
	List<Disease>diseases=Arrays.asList(new Disease("A","tylenol","Its hurt"),new Disease("B","acetamorphon","healthy"));
   
	@RequestMapping("/diseases")
	 DiseaseList diseaseList() {
		 DiseaseList list=new DiseaseList();
		 list.setDiseases(diseases);
		 return list;
	 }
	 
	
	@RequestMapping("/disease")
	public List<Disease>getAllDisease(){
		return diseases;
	}
	
	@RequestMapping("/disease/{id}")
	public Disease getDiseaseById(@PathVariable("id") final String id) {
		Disease di=diseases.stream().filter(disease->id.equals(disease.getId())).findAny().orElse(null);
		return di;
	}
}
