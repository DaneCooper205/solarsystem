package com.cooper.aliens.solarsystem.interfaces;

import java.util.List;

import com.cooper.aliens.solarsystem.entity.SolarSystem;

public interface SolarSystemCrudInterface {
	List<SolarSystem> findAll();
	SolarSystem save(SolarSystem theSolarSystem);
	SolarSystem findById ( int theId);
	void deleteById( int theId);

}
