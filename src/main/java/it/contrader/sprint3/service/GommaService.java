package it.contrader.sprint3.service;

import it.contrader.sprint3.dao.GommaRepository;
import it.contrader.sprint3.model.GommaSize;
import it.contrader.sprint3.model.GommaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GommaService {

    private GommaRepository gommaRepository;

    @Autowired
    public GommaService(GommaRepository gommaRepository) {
        this.gommaRepository = gommaRepository;
    }

    public List<GommaEntity> getAllGomme() {
        return this.gommaRepository.findAll();
    }

    public List<GommaEntity> findByManufacturer(String manufacturer) {
        return this.gommaRepository.findByManufacturer(manufacturer);
    }

    public GommaEntity insertGomma(GommaEntity gomma) {
        return this.gommaRepository.save(gomma);
    }

    public List<String> getAllManufacturerForTypeVehicle(String type)
    {
        return this.gommaRepository.getAllManufacturerForTypeVehicle(type);
    }
    public List<GommaEntity> getAllGommeForSize(GommaSize gomma)
    {
        double width=gomma.getWidth();
        double height=gomma.getHeight();
        double diameter=gomma.getDiameter();
        double weight=gomma.getWeight();
        String speed=gomma.getSpeed();
        String season=gomma.getSeason();
        String typeVehicle=gomma.getTypeVehicle();
        return this.gommaRepository.findByWidthAndHeightAndDiameterAndWeightAndSpeedAndSeasonAndTypeVehicle(width, height, diameter, weight, speed, season, typeVehicle);
    }
    public GommaEntity findById(long id){ return this.gommaRepository.findById(id);}

}
