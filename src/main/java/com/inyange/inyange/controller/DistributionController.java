package com.inyange.inyange.controller;

import com.inyange.inyange.repository.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inyange.inyange.model.Distribution;
import com.inyange.inyange.model.User;
import com.inyange.inyange.service.DistributionService;
import com.inyange.inyange.service.SchoolService;
import com.inyange.inyange.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/api/distribution")
public class DistributionController {
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private UserService userService;
    @Autowired
    private DistributionRepository distributionRepository;
    @GetMapping("/all")
    public String findAllDistribution(Model model,Authentication authentication) {
        String findUserName=authentication.getName();
        User user=userService.findByEmail(findUserName);
        model.addAttribute("userLogged", user);
        model.addAttribute("listdistributions", distributionService.findAllDistribution());
        return "distribution";
    }

    @GetMapping("/addNewDistribution")
    public String addNewDistribution(Model model,Authentication authentication) {
        String findUserName=authentication.getName();
        User user=userService.findByEmail(findUserName);
        model.addAttribute("userLogged", user);
        model.addAttribute("distribution", new Distribution());
        model.addAttribute("listschools", schoolService.findAllSchool());

        return "newDistributor";
    }

    @PostMapping("/saveDistribution")
    public String saveDistribution(@ModelAttribute("distribution") Distribution distribution) {
        distributionService.saveDistribution(distribution);
        return "redirect:/api/distribution/all";
    }

    @GetMapping("/updateDistributionById/{id}")
    public String updateDistributionById(@PathVariable(value = "id") long id, Model model,Authentication authentication) {
        Distribution distribution = distributionService.findDistributionById(id);
        String findUserName=authentication.getName();
        User user=userService.findByEmail(findUserName);
        model.addAttribute("userLogged", user);
        model.addAttribute("distribution", distribution);
        model.addAttribute("listschools", schoolService.findAllSchool());
        return "updateDistributor";
    }

    @GetMapping("/deleteDistributionById/{id}")
    public String deleteDistributionById(@PathVariable(value = "id") long id,Authentication authentication) {
        this.distributionService.deleteDistribution(id);
        return "redirect:/api/distribution/all";
    }



}
