package it.contrader.sprint3.controller;

import it.contrader.sprint3.model.GommaEntity;
import it.contrader.sprint3.model.GommaSize;
import it.contrader.sprint3.service.CompatibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/gomme")
public class CompatibilityController
{
    private CompatibilityService compatibilityService;

    @Autowired
    public CompatibilityController(CompatibilityService compatibilityService)
    {
        this.compatibilityService = compatibilityService;
    }

    @RequestMapping(value="/idgommeForVehicle", method = RequestMethod.GET)
    public  String  getAllGommeForSize(Model model,@RequestParam("idVehicle") int idVehicle,RedirectAttributes redirectAttrs)
    {
       List<Integer> listIdGomme=compatibilityService.getAllIdGommeForIdVehicle(idVehicle);
       model.addAttribute("listIdGomme",listIdGomme);
       redirectAttrs.addFlashAttribute("listIdGomme",listIdGomme);
       return  "redirect:gommeForVehicle";
    }
}
