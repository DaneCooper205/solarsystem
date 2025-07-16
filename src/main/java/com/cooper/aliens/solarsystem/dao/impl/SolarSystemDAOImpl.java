package com.cooper.aliens.solarsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cooper.aliens.solarsystem.dao.SolarSystemDAO;
import com.cooper.aliens.solarsystem.entity.SolarSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class SolarSystemDAOImpl implements SolarSystemDAO {
	private EntityManager entityManager;
	
	
	@Autowired  // not needed bit here or clarity
	public SolarSystemDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<SolarSystem> findAll() {
		TypedQuery<SolarSystem> theQuery = this.entityManager.createQuery("FROM SolarSystem", SolarSystem.class);
		return theQuery.getResultList();
	}

	@Override
	public SolarSystem save(SolarSystem theSolarSystem) {
		return this.entityManager.merge(theSolarSystem);
	}

	@Override
	public SolarSystem findById(int theId) {
		return this.entityManager.find( SolarSystem.class, theId);
	}

	@Override
	public void deleteById(int theId) {
		SolarSystem theSolarSystem = this.findById(theId);
		this.entityManager.remove(theSolarSystem);

	}

}
