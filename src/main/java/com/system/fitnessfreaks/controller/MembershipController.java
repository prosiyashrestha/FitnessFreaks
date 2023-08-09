package com.system.fitnessfreaks.controller;

import com.system.fitnessfreaks.Entity.Admin;
import com.system.fitnessfreaks.Entity.Category;
import com.system.fitnessfreaks.Entity.SignUp;
import com.system.fitnessfreaks.pojo.MembershipPojo;
import com.system.fitnessfreaks.repo.MembershipRepo;
import com.system.fitnessfreaks.services.AdminService;
import com.system.fitnessfreaks.services.CategoryService;
import com.system.fitnessfreaks.services.MembershipService;
import com.system.fitnessfreaks.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class MembershipController {
    private final MembershipService membershipService;
    private final CategoryService categoryService;
    private final AdminService adminService;
    private final SignUpService signUpService;
    private final MembershipRepo membershipRepo;



    @GetMapping("/membership/{id}")
    public  String getWeightlifting(@PathVariable("id") Integer id, Model model){

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);
        model.addAttribute("tab3Active", false);
        SignUp signUp = signUpService.fetchById(id);


        model.addAttribute("userdata",signUpService.fetchById(id));
//        model.addAttribute("up",membershipService.fetchById(id));

        List<Admin> admins = adminService.fetchAll();
        List<Category> categories = categoryService.fetchAll();
        model.addAttribute("priceTable", admins);
        model.addAttribute("categories",categories);

        model.addAttribute("member", new MembershipPojo());
        return "User/weightlifting";
    }

    @PostMapping("/saveMembership")
    public String saveUser(@Valid MembershipPojo membershipPojo)throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }
    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        membershipRepo.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/homepage";
    }

}
