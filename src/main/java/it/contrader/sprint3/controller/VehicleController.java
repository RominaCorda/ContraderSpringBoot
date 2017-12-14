package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.VehicleEntity;
import it.contrader.sprint3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;


    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @RequestMapping(value="/allvehicles", method = RequestMethod.GET)
    public String getAllVehicles (Model model)
    {
        List<VehicleEntity> allVehicles = vehicleService.getAllVehicles();
        model.addAttribute("allVehicles", allVehicles);
        return "allVehicles";
    }


    @RequestMapping(value="/newVehicle", method = RequestMethod.GET)
    public String newVehicle () {
        vehicleService.insert(new VehicleEntity("ciao", "prpr", "aaaa", "qwerty", "zizi"));
        return "vehicle";
    }

}