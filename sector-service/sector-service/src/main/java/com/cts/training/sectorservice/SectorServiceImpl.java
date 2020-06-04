package com.cts.training.sectorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorServiceImpl implements SectorService{
	
	@Autowired
	SectorRepo sectorRepo;
	
	
	@Override
	public Sector addSector(Sector sector) {
		sectorRepo.save(sector);
	    return sector;
	}
	@Override
	public List<Sector> getAllSectors(){
		List<Sector> entities = sectorRepo.findAll();
		List<Sector> sectors = new ArrayList<Sector>();
		for(Sector entity: entities) {
			Sector sector = new Sector();
			BeanUtils.copyProperties(entity, sector);
			sectors.add(sector);
		}
		System.out.println("Entity: "+entities);
		System.out.println("DTO: "+sectors);
		return sectors;
	}
	@Override
	public void deleteSector(int id) {
		sectorRepo.deleteById(id);
	}
	@Override
	public Sector getSectorById(int id){
		Optional<Sector> sectors = sectorRepo.findById(id);
		Sector sector = new Sector();
		BeanUtils.copyProperties(sectors.orElse(new Sector()), sector);
		return sector;
	}
	@Override
	public Sector updateSector(Sector sector) {
		sectorRepo.save(sector);
		return sector;
	}


}
