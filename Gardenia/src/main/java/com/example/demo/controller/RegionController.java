package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.State;
import com.example.demo.repository.RegionRepository;
import com.example.demo.repository.StateRepository;
import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import com.example.demo.service.StateService;

@Controller
public class RegionController {
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private StateService stateService;

	public RegionController(RegionService regionService) {
		super();
		this.regionService = regionService;
	}
	
	@GetMapping("/region")
	public String listRegion(Model model){
		model.addAttribute("region",regionService.getAllRegion());
		return "region";
	}
	
	@GetMapping("/region/new")
	public String CreateNewForm(Model model){
		//Create student object to hold student form data
		Region region = new Region();
		List<State> state_code = stateService.getAllState();
		List<State> state_name = stateService.getAllState();
		model.addAttribute("region",region);
		model.addAttribute("state_code",state_code);
		model.addAttribute("state_name",state_name);
		return "create_region";
	}
	
	@PostMapping("/region")
	public String saveRegion(@ModelAttribute("region") Region region) {
		String sId = region.getState_code();
		System.out.println(sId);
		String name = regionRepository.findByStateName(Long.parseLong(sId));
		System.out.println(name);
		region.setState_name(name);
		regionService.saveRegion(region);
		return "redirect:/region";
	}
	
	@GetMapping("/region/edit/{id}")
	public String editRegion(@PathVariable Long id, Model model) {
		List<State> state_code = stateService.getAllState();
		List<State> state_name = stateService.getAllState();
		model.addAttribute("state_code",state_code);
		model.addAttribute("state_name",state_name);
		model.addAttribute("region", regionService.getRegionById(id));
		return "edit_region";
	}
	
	@PostMapping("/region/{id}")
	public String updateRegion(@PathVariable Long id,
			@ModelAttribute("region") Region region,
			Model model) {
		
		//Get Existing Region
		Region existingRegion = regionService.getRegionById(id);
		String sId = region.getState_code();
		System.out.println(sId);
		String name = regionRepository.findByStateName(Long.parseLong(sId));
		System.out.println(name);
		region.setState_name(name);
		
		//Save Region
		regionService.editRegion(region);
		return "redirect:/region";
	}
	
	@GetMapping("/region/{id}")
	public String deleteRegion(@PathVariable Long id) {
		regionService.deleteRegionById(id);
		return "redirect:/region";
	}
}

