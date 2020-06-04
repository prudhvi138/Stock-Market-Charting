package com.cts.training.sectorservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*")
public class SectorRestServiceController {
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SectorRepo sectorRepo;
	
	@Autowired
	private UserServiceProxy proxy;
	@Autowired
	SectorService sectorService;
	
	@GetMapping(value="/sector",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Sector> findAll(){
		return sectorService.getAllSectors();
	}
	@RequestMapping(value="/sector/{id}", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Sector findone(@PathVariable int id){
		Sector sector = sectorService.getSectorById(id);
		return sector;
		 
	}
	@RequestMapping(value="/sector", method= RequestMethod.POST)
	public Sector save(@RequestBody Sector sector){
		Sector sec = sectorRepo.save(sector);
		return sec;
	}
	@RequestMapping(value="/sector/{id}", method= RequestMethod.DELETE)
	public void    delete(@PathVariable int id){
		sectorRepo.deleteById(id);
	}
	@RequestMapping(value = "/sector", method = RequestMethod.PUT)
	public Sector update(@RequestBody Sector sector) {
		Sector sect = sectorRepo.save(sector);
		return sect;
	}
	
	@GetMapping(value = "/users-by-sector")
	public ResponseEntity<?>getAllUsersBySector()
	{	
		logger.info("Get All Users Invoked");
		ResponseEntity<?> users =  proxy.getallusers();
		logger.info("Information --> {}", users);
		return users;
	
	}

}
