package assignment_lab.practice.exam.controller;

import assignment_lab.practice.exam.model.Supplier;
import assignment_lab.practice.exam.service.IProductService;
import assignment_lab.practice.exam.model.Product;
import assignment_lab.practice.exam.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value = "/products/list")
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("products/display");
        return modelAndView;
    }

    @GetMapping(value = "/products/newItem")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Supplier> supplier =  supplierService.findAll();
       model.addAttribute("supplier", supplier);
        return "products/new";
    }

    @PostMapping(value = "/product/save")
    public String addNewProduct(@Valid @ModelAttribute("product") Product product,
        BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/new";
        }
        product = productService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping(value = "/products/update/{productId}")
    public String editProduct(@PathVariable Long productId, Model model) {
        Product product = productService.findById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "products/update";
        }
        return "products/display";
    }

    @PostMapping(value = "/products/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "products/update";
        }
        product = productService.save(product);
        return "redirect:/products/list";
    }
}

