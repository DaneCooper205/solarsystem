package com.cooper.aliens.solarsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.aliens.solarsystem.dao.SolarSystemDAO;
import com.cooper.aliens.solarsystem.entity.SolarSystem;

import jakarta.transaction.Transactional;
@Service
public class SolarSystemServiceImpl implements SolarSystemService {
	
	private SolarSystemDAO solarSystemDAO;
	
	
	@Autowired
	public SolarSystemServiceImpl(SolarSystemDAO solarSystemDAO) {
		super();
		this.solarSystemDAO = solarSystemDAO;
	}

	@Override
	public List<SolarSystem> findAll() {
		
		return this.solarSystemDAO.findAll();
	}

	@Override
	@Transactional
	public SolarSystem save(SolarSystem theSolarSystem) {
		return this.solarSystemDAO.save(theSolarSystem);
	}

	@Override
	public SolarSystem findById(int theId) {
		
		return this.solarSystemDAO.findById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		this.solarSystemDAO.deleteById(theId);

	}

}
