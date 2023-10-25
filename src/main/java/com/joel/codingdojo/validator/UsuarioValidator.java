package com.joel.codingdojo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.joel.codingdojo.model.Usuario;
import com.joel.codingdojo.service.UsuarioService;

@Component
public class UsuarioValidator implements Validator {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;
        validarContraseña(usuario, errors);
        validarCorreo(usuario, errors);
    }

    private void validarCorreo(Usuario usuario, Errors errors) {
        if (usuarioService.findByemail(usuario.getEmail()) != null) {
            errors.rejectValue("email", "correoUnique");
        }
    }

    private void validarContraseña(Usuario usuario, Errors errors) {
        if (!usuario.getPassword().equals(usuario.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "passwordDiferente");
        }
    }

}
