package com.joel.codingdojo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joel.codingdojo.model.Programa;
import com.joel.codingdojo.model.Usuario;
import com.joel.codingdojo.service.ProgramaService;
import com.joel.codingdojo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/programas")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    String homeProgramas(HttpSession session, Model model) {
        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }
        Usuario usuarioActual = usuarioService.findById(usuarioActualID);
        List<Programa> listProgramas = programaService.findAll();

        model.addAttribute("usuarioActual", usuarioActual);
        model.addAttribute("programas", listProgramas);
        return "dashboard.jsp";
    }

    @GetMapping("/new")
    public String New(@ModelAttribute(value = "programa") Programa programa, HttpSession session) {
        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }

        return "newPrograma.jsp";
    }

    @PostMapping("/new")
    public String Create(@Valid @ModelAttribute(value = "programa") Programa programa, BindingResult results,
    HttpSession session) {

        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }

        if (results.hasErrors()) {
            return "newPrograma.jsp";
        }

        // System.out.println(programa.s());

        Usuario usuario = usuarioService.findById(usuarioActualID);
        programa.setUsuario(usuario);
        programaService.save(programa);

        return "redirect:/programas";
    }

    @GetMapping("/{id}")
    public String tabla(@PathVariable("id") Long id, Model model, HttpSession session) {

        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }

        Usuario usuarioEnSession = usuarioService.findById(usuarioActualID);
        Programa programa = programaService.findById(id);

        model.addAttribute("programa", programa);
        model.addAttribute("usuarioActual", usuarioEnSession);

        return "detallePrograma.jsp";
    }

    @GetMapping("/{idEditPage}/edit")
    String PaginaEditado(@ModelAttribute("editarPage") Programa programaEdit, @PathVariable("idEditPage") Long idEditPage, Model model, HttpSession session){

        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }

        Programa programaSend = programaService.findById(idEditPage);
        model.addAttribute("programa", programaSend);

        return "editPrograma.jsp";
    }

    @PostMapping("/{idEdit}/edit")
    String editarPrograma(@Valid @ModelAttribute("editarPage") Programa programaEdit, BindingResult result, @PathVariable("idEdit") Long idEditPage, Model model, HttpSession session){

        Long usuarioActualID = (Long) session.getAttribute("user_id");
        if (usuarioActualID == null) {
            return "redirect:/";
        }
        Programa programaAModificar = programaService.findById(idEditPage);

        if(result.hasErrors()){
            model.addAttribute("programa", programaAModificar);
            return "editPrograma.jsp";
        }

        
        programaAModificar.setTitle(programaEdit.getTitle());
        programaAModificar.setRed(programaEdit.getRed());
        programaAModificar.setDescripcion(programaEdit.getDescripcion());

        programaService.save(programaAModificar);

        return "redirect:/programas";
    }

    
    @GetMapping("/{idDelete}/delete")
    String deleteName(
        @PathVariable("idDelete") Long id,
        HttpSession session
    ){
        Long userAct = (Long)session.getAttribute("user_id");
        if(userAct == null){
            return "redirect:/";
        }
        programaService.delete(id);
        return "redirect:/programas";
    }
    

}
