package it.contrader.sprint3.dao;

import it.contrader.sprint3.model.GommaEntity;
import it.contrader.sprint3.model.VehicleEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {

    List<VehicleEntity> findAll();
    List<VehicleEntity> findByBrand(String brand);

    VehicleEntity findByBrandAndModelAndFuelAndVersionAndCapacity(String brand, String model, String fuel, String version, String capacity);
}
