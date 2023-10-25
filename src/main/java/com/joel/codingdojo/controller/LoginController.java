package com.joel.codingdojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joel.codingdojo.model.Usuario;
import com.joel.codingdojo.service.UsuarioService;
import com.joel.codingdojo.validator.UsuarioValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioValidator usuarioValidator;

    @PostMapping("/login")
    public String Login(@RequestParam("email") String email, @RequestParam("password") String password,
        HttpSession session, RedirectAttributes redirectAttributes) {

        if(email == null || email == ""){
            redirectAttributes.addFlashAttribute("errorLogin", "por favor dijita un correo valido");
            return "redirect:/";
        }

        if(password == null || password == ""){
            redirectAttributes.addFlashAttribute("passwordErrorIn", "por favor dijita una contraseña valida");
            return "redirect:/";
        }

        Usuario usuario = usuarioService.validarDatosLogin(email, password);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("errorLogin", "no existe el usuario, Revisa bien los campos e intenta de nuevo");
            return "redirect:/";
        }
        if (usuario.getEmail() == null) {
            redirectAttributes.addFlashAttribute("passwordErrorIn", "no coincide tu contraseña, revisala y intenta de nuevo");
            return "redirect:/";
        }

        session.setAttribute("user_id", usuario.getId());
        return "redirect:/";
    }

    @PostMapping("/new")
    public String Register(@Valid @ModelAttribute(value = "usuario") Usuario usuario, BindingResult results,
        HttpSession session) {

        usuarioValidator.validate(usuario, results);
        
        if (results.hasErrors()) {
            return "index.jsp";
        } else {
            usuarioService.save(usuario);
            session.setAttribute("user_id", usuario.getId());
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
