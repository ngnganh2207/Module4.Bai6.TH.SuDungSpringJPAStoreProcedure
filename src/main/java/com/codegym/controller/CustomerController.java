package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;



    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("listCustomer",customerService.findAll());
        return "customer/list";
    }
    @GetMapping("/create/customer")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer() );
        return "customer/create";
    }

    @PostMapping("/create/customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer,Model model){
//        customerService.insertWithStoredProcedure(customer);
//        ModelAndView modelAndView= new ModelAndView("customer/list");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message","New Create Customer Successfully");
//        return modelAndView;
        customerService.insertWithStoredProcedure(customer);
        model.addAttribute("message", "Successfully");
        return "redirect:/home";
    }
}
