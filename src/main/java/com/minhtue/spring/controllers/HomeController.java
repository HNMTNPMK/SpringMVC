
package com.minhtue.spring.controllers;

import com.minhtue.spring.models.Account;
import com.minhtue.spring.models.Product;
import com.minhtue.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ProductService service;

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Product> listProduct = service.getAll();
        model.addAttribute("products", listProduct);
        return "index";
    }


    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public String details(@PathVariable Integer id, Model model) {
        Product product = service.getById(id);
        model.addAttribute("product", product);
        return "details";
    }

    @RequestMapping(value = "/Signup", method = RequestMethod.GET)
    public String signup() {
        return "form-signup";
    }

    @ModelAttribute("account")
    public Account setLoginModel() {
        return new Account();
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("account") Account account, Model model) {
        if (account.getUsername().equals("admin") && account.getPassword().equals("admin")) {
            model.addAttribute("success", "Đăng ký thành công");
        } else {
            model.addAttribute("error", "Đăng ký thất bại");
        }
        return "form-signup";
    }

    @RequestMapping(value = "product/add", method = RequestMethod.GET)
    public String addProduct() {
        return "add-product";
    }

    @RequestMapping(value = "product/update/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, Model model) {
        Product product = service.getById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @ModelAttribute("product")
    public Product setProductModal() {
        return new Product();
    }

    @RequestMapping(value = "product/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, Model model) {
        service.insert(product);
        return "redirect:/Home";
    }

    @RequestMapping(value = "product/update/saveUpdateProduct", method = RequestMethod.POST)
    public String saveUpdateProduct(@ModelAttribute("product") Product product, Model model) {
        service.update(product);
        return "redirect:/Home";
    }

    @RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/Home";
    }

}