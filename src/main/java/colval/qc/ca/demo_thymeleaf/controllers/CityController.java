package colval.qc.ca.demo_thymeleaf.controllers;

import colval.qc.ca.demo_thymeleaf.services.impl.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {
    CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public String city(Model model){
        model.addAttribute("allCity", cityService.readAll());
        return "city/city";
    }
}
