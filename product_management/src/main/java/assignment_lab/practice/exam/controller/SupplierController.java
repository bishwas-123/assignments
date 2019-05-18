package assignment_lab.practice.exam.controller;

import assignment_lab.practice.exam.model.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import assignment_lab.practice.exam.service.ISupplierService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/suppliers/list")
      public ModelAndView suppliers(){
        ModelAndView modelAndView=new ModelAndView();
        List<Supplier> suppliers=supplierService.findAll();
        modelAndView.addObject("suppliers",suppliers);
        modelAndView.setViewName("supplier/display");
        return modelAndView;
    }

    @GetMapping(value = "/suppliers/newSupplier")
    public String createSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier/new_supplier";
    }

    @PostMapping(value = "suppliers/save")
    public String addNewSupplier(@Valid  @ModelAttribute("supplier") Supplier supplier, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors",result.getAllErrors());
            return "supplier/new_supplier";
        }
        supplier=supplierService.save(supplier);
        return "redirect:/suppliers/list";

    }

    @GetMapping(value = "/supplier/update/{supplierId}")
    public String editProduct(@PathVariable Long supplierId, Model model) {
        Supplier supplier = supplierService.findById(supplierId);
        if (supplier != null) {
            model.addAttribute("supplier", supplier);
            return "supplier/update";
        }
        return "supplier/display";
    }

    @PostMapping(value = "/supplier/update")
    public String updateProduct(@Valid @ModelAttribute("supplier") Supplier supplier,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/update";
        }
        supplier = supplierService.save(supplier);
        return "redirect:/suppliers/list";
    }




}
