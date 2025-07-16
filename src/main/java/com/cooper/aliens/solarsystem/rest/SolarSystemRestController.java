package com.cooper.aliens.solarsystem.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.aliens.solarsystem.service.SolarSystemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.cooper.aliens.solarsystem.entity.SolarSystem;

@RestController
@RequestMapping("/api")
public class SolarSystemRestController {
	private SolarSystemService solarSystemService;
	private ObjectMapper objectMapper;

	@Autowired
	public SolarSystemRestController(SolarSystemService solarSystemService, ObjectMapper theObjectMapper) {
		super();
		this.solarSystemService = solarSystemService;
		this.objectMapper=theObjectMapper;
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
	public String deleteSolarSystem(@PathVariable int solarSystemId ) {
		SolarSystem tempSolarSystem = this.solarSystemService.findById(solarSystemId);
		
		if (tempSolarSystem == null) {
			throw new RuntimeException("SolarSystemId not found - " + solarSystemId);
		}
		
		this.solarSystemService.deleteById(solarSystemId);
		return "Deleted SolarSystemId = " + solarSystemId;
		
	}

	@PatchMapping("solarsystems/{solarSystemId}")
	public SolarSystem patchSolarSystem( @PathVariable int solarSystemId, @RequestBody Map<String, Object> patchPayload) {
		SolarSystem tempSolarSystem = this.solarSystemService.findById(solarSystemId);
		
		if (tempSolarSystem == null) {
			throw new RuntimeException("SolorSystem id not found - " + solarSystemId);
			
		}
		
		if ( patchPayload.containsKey("id")) {
			throw new RuntimeException("SolarSystem id not allowed in the request body - " + solarSystemId);
		}
		
		SolarSystem patchedSolarSystem = apply( patchPayload, tempSolarSystem);
		
		SolarSystem dbSolarSystem = this.solarSystemService.save(patchedSolarSystem);
		
		return  dbSolarSystem;
	}
	
	private SolarSystem apply(Map<String, Object> patchPayload, SolarSystem tempSolarSystem) {
		ObjectNode solarSystemNode = this.objectMapper.convertValue( tempSolarSystem,  ObjectNode.class);
		
		ObjectNode patchNode = this.objectMapper.convertValue( patchPayload,  ObjectNode.class);
		
		solarSystemNode.setAll( patchNode);
		
		return this.objectMapper.convertValue(solarSystemNode, SolarSystem.class);
	}
	
}
