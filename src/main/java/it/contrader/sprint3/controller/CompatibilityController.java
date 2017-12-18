package it.contrader.sprint3.controller;

import it.contrader.sprint3.service.CompatibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/compatibility")
public class CompatibilityController
{
    private CompatibilityService compatibilityService;

    @Autowired
    public CompatibilityController(CompatibilityService compatibilityService)
    {
        this.compatibilityService = compatibilityService;
    }

    @RequestMapping(value="/idgommeForVehicle", method = RequestMethod.GET)
    public  String  getAllGommeForSize(Model model,RedirectAttributes redirectAttrs)
    {
       Object x= model.asMap().get("id_vehicle");
       int idVehicle= (int) x;
       List<Integer> listIdGomme=compatibilityService.getAllIdGommeForIdVehicle(idVehicle);
       model.addAttribute("listIdGomme",listIdGomme);
       redirectAttrs.addFlashAttribute("listIdGomme",listIdGomme);
       return  "redirect:/gomme/gommeForVehicle";
    }
}
