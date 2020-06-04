package com.cts.training.sectorservice;

import java.util.List;


public interface SectorService {
	
	public Sector addSector(Sector sector);
    public void deleteSector(int id);
    public Sector updateSector(Sector sector);
    public List<Sector> getAllSectors();
    public Sector getSectorById(int id);

}
