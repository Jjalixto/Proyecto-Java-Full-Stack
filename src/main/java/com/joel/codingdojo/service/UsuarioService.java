package com.joel.codingdojo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.codingdojo.model.Usuario;
import com.joel.codingdojo.repository.UsuarioRepository;

@Service
public class UsuarioService extends ServiceBase<Usuario> {

    @Autowired
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repositoryBase) {
        super(repositoryBase);
    }

    @Override
    public Usuario save(Usuario usuario) {
        encriptarPassword(usuario);
        return super.save(usuario);
    }

    public Usuario findByemail(String email) {
        Usuario user = repository.findByEmail(email);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    private void encriptarPassword(Usuario usuario) {
        String passwordEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(passwordEncriptado);
    }

    public Usuario validarDatosLogin(String email, String password) {
        Usuario usuario = validarCorreo(email);
        if (usuario != null) {
            if (auntenticarContraseña(usuario, password)) {
                return usuario;
            }
            Usuario NoContraseña = new Usuario();
            return NoContraseña;
        }
        return null;
    }

    public Usuario validarCorreo(String email) {
        Usuario usuarioTemporal = repository.findByEmail(email);
        if (usuarioTemporal != null) {
            return usuarioTemporal;
        }
        return null;
    }

    private boolean auntenticarContraseña(Usuario usuario, String password) {
        return BCrypt.checkpw(password, usuario.getPassword());
    }
}
