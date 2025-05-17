package com.empleados.api.ui.controller;

import com.empleados.api.dto.EmpleadoDTO;
import com.empleados.api.model.TipoContrato;
import com.empleados.api.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.math.BigDecimal;

/**
 * Controlador para las vistas web
 */
@Controller
@RequiredArgsConstructor
public class WebController {
    
    private final EmpleadoService empleadoService;
    
    /** Página de inicio (Dashboard) */
    @GetMapping("/")
    public String dashboard(Model model) {
        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        int totalEmpleados = empleados.size();
        BigDecimal salarioPromedio = empleados.stream()
            .map(EmpleadoDTO::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(Math.max(1, totalEmpleados)), BigDecimal.ROUND_HALF_UP);

        Map<String, Long> departamentos = empleados.stream()
            .collect(Collectors.groupingBy(EmpleadoDTO::getDepartamento, Collectors.counting()));

        model.addAttribute("totalEmpleados", totalEmpleados);
        model.addAttribute("salarioPromedio", salarioPromedio.toString());
        model.addAttribute("departamentos", departamentos);
        return "index";
    }
    
    /** Lista de empleados */
    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.getAllEmpleados());
        return "empleados";
    }
    
    /** Formulario para nuevo empleado */
    @GetMapping("/empleados/nuevo")
    public String nuevoEmpleadoForm(Model model) {
        EmpleadoDTO empleado = new EmpleadoDTO();
        empleado.setFechaContratacion(LocalDate.now());
        model.addAttribute("empleado", empleado);
        model.addAttribute("tipoContratos", TipoContrato.values());
        return "form";
    }
    
    /** Guardar nuevo empleado */
    @PostMapping("/empleados/guardar")
    public String guardarEmpleado(
        @Valid @ModelAttribute("empleado") EmpleadoDTO empleado,
        BindingResult result,
        Model model,                         
        RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("tipoContratos", TipoContrato.values());
            return "form";
        }
        
        empleadoService.createEmpleado(empleado);
        redirectAttributes.addFlashAttribute("mensajeExito", "¡Empleado creado correctamente!");
        return "redirect:/empleados";
    }
    
    /** Formulario para editar empleado */
    @GetMapping("/empleados/editar/{id}")
    public String editarEmpleadoForm(@PathVariable Long id, Model model) {
        EmpleadoDTO empleado = empleadoService.getEmpleadoById(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("tipoContratos", TipoContrato.values());
        return "form";
    }
    
    /** Actualizar empleado existente */
    @PostMapping("/empleados/actualizar/{id}")
    public String actualizarEmpleado(
        @PathVariable Long id, 
        @Valid @ModelAttribute("empleado") EmpleadoDTO empleado,
        BindingResult result,
        Model model,                                   
        RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("tipoContratos", TipoContrato.values());
            return "form";
        }
        
        empleadoService.updateEmpleado(id, empleado);
        redirectAttributes.addFlashAttribute("mensajeExito", "¡Empleado actualizado correctamente!");
        return "redirect:/empleados";
    }
    
    /** Eliminar empleado */
    @PostMapping("/empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        empleadoService.deleteEmpleado(id);
        redirectAttributes.addFlashAttribute("mensajeExito", "¡Empleado eliminado correctamente!");
        return "redirect:/empleados";
    }
}
