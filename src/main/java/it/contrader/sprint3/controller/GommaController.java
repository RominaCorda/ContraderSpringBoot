package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.GommaEntity;
import it.contrader.sprint3.service.GommaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value="/insert", method = RequestMethod.GET)
    public String insert ()
    {
        //gommaService.insert(new GommaEntity("Pirelli-Soft","Pirelli",230));
        return "insertGomma";
    }

    @RequestMapping(value="/allgommeManufacturer", method = RequestMethod.GET)
    public String gommeByManufacturer(Model model,@RequestParam("manufacturer") String manufacturer)
    {
        List<GommaEntity> gomme = gommaService.findByManufacturer(manufacturer);
        model.addAttribute("listgomme", gomme);
        return "gommeByManufacturer";
    }

    @RequestMapping(value="/trelleborg", method = RequestMethod.GET)
    public String gommeByTrelleborg (Model model)
    {
        List<GommaEntity> gommeByTrelleborg = gommaService.findByManufacturer("Trelleborg");
        model.addAttribute("gommeByTrelleborg", gommeByTrelleborg);
        return "gommeByTrelleborg";
    }


}