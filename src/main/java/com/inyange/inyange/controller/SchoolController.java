package com.inyange.inyange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inyange.inyange.model.School;
import com.inyange.inyange.model.User;
import com.inyange.inyange.service.SchoolService;
import com.inyange.inyange.service.UserService;

@Controller
@RequestMapping("/api/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public String findAllSchool(Model model,Authentication authentication) {
        model.addAttribute("listschools", schoolService.findAllSchool());
        String findUsername=authentication.getName();
        User user=userService.findByEmail(findUsername);
        model.addAttribute("userLogged", user);
        return "viewSchool";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/addNewSchool")
    public String addNewSchool(Model model,Authentication authentication) {
        model.addAttribute("school", new School());
        String findUsername=authentication.getName();
        User user=userService.findByEmail(findUsername);
        model.addAttribute("userLogged", user);
        return "addNewSchool";

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveSchool")
    public String saveSchool(@ModelAttribute("school") School school) {
        schoolService.saveSchool(school);
        return "redirect:/api/school/all";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/updateSchoolById/{id}")
    public String updateSchoolById(@PathVariable(value = "id") long id, Model model,Authentication authentication) {
        String findUsername=authentication.getName();
        User user=userService.findByEmail(findUsername);
        model.addAttribute("userLogged", user);
        School school = schoolService.findSchoolById(id);
        model.addAttribute("school", school);
        return "updateSchool";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/deleteSchoolById/{id}")
    public String deleteSchoolById(@PathVariable(value = "id") long id) {
        this.schoolService.deleteSchool(id);
        return "redirect:/api/school/all";
    }
}
