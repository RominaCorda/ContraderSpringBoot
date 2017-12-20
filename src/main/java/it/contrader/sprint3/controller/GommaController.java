package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.GommaSize;
import it.contrader.sprint3.model.GommaEntity;
import it.contrader.sprint3.service.GommaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gomme")
public class GommaController
{

    private GommaService gommaService;

    @Autowired
    public GommaController (GommaService gommaService)
    {
        this.gommaService = gommaService;
    }

    @RequestMapping(value="/allgomme",method = RequestMethod.GET)
    public String getAllGomme(Model model)
    {
        List<GommaEntity> gomme=gommaService.getAllGomme();
        model.addAttribute("listgomme",gomme);
        return "allGomme";
    }

    @RequestMapping(value="/insertGomme", method = RequestMethod.POST)
    public String insert (@ModelAttribute GommaEntity gomma,Model model)
    {
        List<GommaEntity> gomme=gommaService.getAllGomme();
        for (GommaEntity g:gomme)
        {
            if(g.equals(gomma))
            {
                model.addAttribute("msg","Pneumatico gi&agrave presente");
                return "insertGomma";
            }
        }
        gommaService.insertGomma(gomma);
        model.addAttribute("msg","Pneumatico aggiunta");
        return "menuAdmin";
    }

    @RequestMapping(value="/allgommeManufacturer", method = RequestMethod.GET)
    public String gommeByManufacturer(Model model,@RequestParam("manufacturer") String manufacturer,@RequestParam("typeVehicle") String typeVehicle)
    {
        List<GommaEntity> gomme = gommaService.findByManufacturer(manufacturer,typeVehicle);
        model.addAttribute("listgomme", gomme);
        return "allGommeUser";
    }

    @RequestMapping(value="/manufacturerForVehicle", method = RequestMethod.GET)
    public  String  getAllManufacturerForTypeVehicle(Model model,@RequestParam("type") String type)
    {
        List<String> manufactures=gommaService.getAllManufacturerForTypeVehicle(type);
        model.addAttribute("listmanufactures",manufactures);
        return  "prova";
    }

    @RequestMapping(value="/gommeForSize", method = RequestMethod.GET)
    public  String  getAllGommeForSize(@ModelAttribute GommaSize gomma, Model model)
    {
        List<GommaEntity> gomme=gommaService.getAllGommeForSize(gomma);
        model.addAttribute("listgomme",gomme);
        return  "allGommeUser";
    }
    @RequestMapping(value="/gommeForSizeAuto", method = RequestMethod.GET)
    public  String  getAllGommeForSizeAuto(@ModelAttribute GommaSize gomma, Model model)
    {
        List<GommaEntity> gomme=gommaService.getAllGommeForSizeAuto(gomma);
        model.addAttribute("listgomme",gomme);
        return  "allGommeUser";
    }
    @RequestMapping(value="/gommeForVehicle", method = RequestMethod.GET)
    public  String  getAllGommeForVehicle(@ModelAttribute GommaSize gomma, Model model)
    {
        List<GommaEntity> listgomme= new ArrayList<GommaEntity>();
        List<Integer> listIdGomme= (List<Integer>) model.asMap().get("listIdGomme");
        for (Integer idGomma:listIdGomme)
        {
            int id=idGomma.intValue();
            listgomme.add(gommaService.findById(id));
        }
        model.addAttribute("listgomme",listgomme);
        return  "allGommeUser";
    }

}