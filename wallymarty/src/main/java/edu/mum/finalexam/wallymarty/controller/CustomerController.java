package edu.mum.finalexam.wallymarty.controller;

import edu.mum.finalexam.wallymarty.model.Customer;
import edu.mum.finalexam.wallymarty.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
 @Autowired
 private ICustomerService customerService;

    @GetMapping(value = "/customers/list")
    public ModelAndView customers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("customers/display");
        return modelAndView;
    }

    @GetMapping(value = "/primecustomers/list")
    public ModelAndView primecustomers() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.findAll();
        List<Customer> primecustomers=new ArrayList<Customer>();
        LocalDate currentdate= LocalDate.now();
        for(Customer c: customers){
                   int diff=Period.between(c.getDateOfBirth(),currentdate).getYears();
            System.out.println("normal+"+ diff);
                   if(diff>40){
                System.out.println("hello+"+ diff);
                primecustomers.add(c);
            }

        }
        System.out.println("LISTS  "+primecustomers.toString());
        modelAndView.addObject("primecustomers", primecustomers);
        modelAndView.setViewName("primecustomers/display");
        return modelAndView;
    }
//
    @GetMapping(value = "/customer/newItem")
    public String newProductForm(Model model) {
        model.addAttribute("customer", new Customer());

      // model.addAttribute("primecustomers", primecustomers);
        return "customers/new";
    }
//
    @PostMapping(value = "/customer/save")
    public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customers/new";
        }
        customer = customerService.save(customer);
        return "redirect:/customers/list";
    }
//
//    @GetMapping(value = "/customers/update/{productId}")
//    public String editProduct(@PathVariable Long productId, Model model) {
//        Product product = productService.findById(productId);
//        if (product != null) {
//            model.addAttribute("product", product);
//            return "customers/update";
//        }
//        return "customers/display";
//    }
//
//    @PostMapping(value = "/customers/update")
//    public String updateProduct(@Valid @ModelAttribute("product") Product product,
//            BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "customers/update";
//        }
//        product = productService.save(product);
//        return "redirect:/customers/list";
//    }
}