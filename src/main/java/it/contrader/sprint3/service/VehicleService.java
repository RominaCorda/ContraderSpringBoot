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
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        }

        public List<VehicleEntity> findByBrand (String brand) {
        return this.vehicleRepository.findByBrand(brand);
        }

        public VehicleEntity insert(VehicleEntity vehicle) {
        return this.vehicleRepository.save(vehicle);
        }
}
