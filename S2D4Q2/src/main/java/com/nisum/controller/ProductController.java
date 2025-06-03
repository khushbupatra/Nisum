package com.nisum.controller;

import com.nisum.dao.ProductDAO;
import com.nisum.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductDAO dao;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("products", dao.list());
        return "product_list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product p) {
        if (p.getId() > 0) {
            dao.update(p);
        } else {
            dao.save(p);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("product", dao.get(id));
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/";
    }
}
