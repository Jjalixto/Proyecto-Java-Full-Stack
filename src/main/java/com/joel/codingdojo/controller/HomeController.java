package com.joel.codingdojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.joel.codingdojo.model.Usuario;
import com.joel.codingdojo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller 
public class HomeController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/")
    public String Home(@ModelAttribute(value = "usuario") Usuario usuario, HttpSession session, Model model){

        Long usuarioActualID = (Long)session.getAttribute("user_id");

        if(usuarioActualID == null){
            return "index.jsp";
        }else{
            return "redirect:/programas";
        }
    }
}
