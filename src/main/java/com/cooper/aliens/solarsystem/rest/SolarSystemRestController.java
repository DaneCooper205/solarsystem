package com.cooper.aliens.solarsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.aliens.solarsystem.service.SolarSystemService;
import com.cooper.aliens.solarsystem.entity.SolarSystem;

@RestController
@RequestMapping("/api")
public class SolarSystemRestController {
	private SolarSystemService solarSystemService;

	@Autowired
	public SolarSystemRestController(SolarSystemService solarSystemService) {
		super();
		this.solarSystemService = solarSystemService;
	}
	
	@GetMapping("/solarsystems")
	public List<SolarSystem> findAll(){
		return this.solarSystemService.findAll();
	}

	@GetMapping("solarsystems/{solarsystemId}")
	public SolarSystem getSolarSystem(@PathVariable int solarsystemId ) {
		
		SolarSystem theSolarSystem =this.solarSystemService.findById(solarsystemId);
		if( theSolarSystem == null) {
			throw new RuntimeException( "Solar System id not found - "+ solarsystemId);
		}
		
		return theSolarSystem;
	}
	
	@PostMapping( "/solarsystems")
	public SolarSystem addSolarSystem( @RequestBody SolarSystem theSolarSystem) {
		theSolarSystem.setId(0); // Forces an insert
		SolarSystem dbSolarSystem = this.solarSystemService.save(theSolarSystem);
		
		
		return dbSolarSystem;
	}
	
	@PutMapping( "/solarsystems")
	public SolarSystem updateSolarSystem( @RequestBody SolarSystem theSolarSystem) {
		SolarSystem dbSolarSystem = this.solarSystemService.save(theSolarSystem);
		
		
		return dbSolarSystem;
	}
	
	@DeleteMapping("solarsystems/{SolarSystemId}")
	public void deleteSolarSystem(@PathVariable int SolarSystemId ) {
		
		this.solarSystemService.deleteById(SolarSystemId);
		
	}
	
}
