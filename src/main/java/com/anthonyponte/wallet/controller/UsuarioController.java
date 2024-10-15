package com.anthonyponte.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthonyponte.wallet.entity.Estado;
import com.anthonyponte.wallet.entity.Usuario;
import com.anthonyponte.wallet.service.IEstadoService;
import com.anthonyponte.wallet.service.IUsuarioService;
import com.google.common.collect.Lists;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {
    @Autowired
    private IUsuarioService<Usuario> usuarioService;

    @Autowired
    private IEstadoService<Estado> estadoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(Authentication auth, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            String username = auth.getName();
            Usuario usuario = usuarioService.getByUsername(username);
            session.setAttribute("username", usuario);
        }
        return "redirect:/cuentas";
    }

    @GetMapping("/login")
    public String ingresar() {
        return "ingresarUsuario";
    }

    @RequestMapping("/usuario/nuevo")
    public String registrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registrarUsuario";
    }

    @PostMapping("/usuario/guardar")
    public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "registrarUsuario";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setEstado(1);
        usuarioService.create(usuario);

        attributes.addFlashAttribute(
                "textAlertSuccess", "Se guardo el usuario '" + usuario.getIdUsuario() + "'");
        return "redirect:/";
    }

    @ModelAttribute
    public void cargar(Model model) {
        List<Estado> listEstados = Lists.newArrayList(estadoService.getAll());
        model.addAttribute("listEstados", listEstados);
    }
}
