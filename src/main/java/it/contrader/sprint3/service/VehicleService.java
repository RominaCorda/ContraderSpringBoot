package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.VehicleRepository;
import it.contrader.sprint3.model.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }

        public List<VehicleEntity> getAllVehicles ()
        {
        return this.vehicleRepository.findAll();
        }

        public VehicleEntity insert(VehicleEntity vehicle)
        {
        return this.vehicleRepository.save(vehicle);
        }

        public VehicleEntity findByBrandAndModelAndFuelAndVersionAndCapacity(VehicleEntity vehicle)
        {
            String brand = vehicle.getBrand();
            String  model = vehicle.getModel();
            String fuel = vehicle.getFuel();
            String version = vehicle.getVersion();
            String capacity =vehicle.getCapacity();
            return this.vehicleRepository.findByBrandAndModelAndFuelAndVersionAndCapacity(brand, model, fuel, version, capacity);
        }
}

