package com.anthonyponte.wallet.controller;

import com.anthonyponte.wallet.entity.Cuenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anthonyponte.wallet.service.ICuentaService;


@Controller
public class CuentaController {
  @Autowired
  private ICuentaService<Cuenta> service;

  @GetMapping("/cuentas")
  public String consultar(Model model, Pageable pageable) {
    Page<Cuenta> listCuentas = service.getAll(pageable);
    model.addAttribute("listCuentas", listCuentas);
    return "consultarCuentas";
  }

  @RequestMapping("/cuenta/nuevo")
  public String registrar(Model model) {
    model.addAttribute("cuenta", new Cuenta());
    return "registrarCuenta";
  }

  @PostMapping("/cuenta/guardar")
  public String guardar(Cuenta cuenta, BindingResult result, RedirectAttributes attr) {
    if (result.hasErrors()) {
      return "consultarCuentas";
    }
    service.create(cuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se guardo la cuenta " + cuenta.getIdCuenta());
    return "redirect:/";
  }

  @GetMapping("/cuenta/editar/{idCuenta}")
  public String editar(@PathVariable("idCuenta") Integer idCuenta, Model model) {
    Cuenta cuenta = service.getById(idCuenta);
    model.addAttribute("cuenta", cuenta);
    return "registrarCuenta";
  }

  @GetMapping("/cuenta/eliminar/{idCuenta}")
  public String eliminar(@PathVariable("idCuenta") Integer idCuenta, RedirectAttributes attr) {
    service.delete(idCuenta);
    attr.addFlashAttribute("textAlertSuccess", "Se elimino la cuenta " + idCuenta);
    return "redirect:/";
  }
}
