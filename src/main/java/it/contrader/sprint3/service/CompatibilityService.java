package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.CompatibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompatibilityService
{
    private CompatibilityRepository compatibilityRepository;

    @Autowired
    public CompatibilityService(CompatibilityRepository compatibilityRepository)
    {
        this.compatibilityRepository = compatibilityRepository;
    }
    public List<Integer> getAllIdGommeForIdVehicle(int id_vehicle){ return this.compatibilityRepository.getAllIdGommeForIdVehicle(id_vehicle);}
}
