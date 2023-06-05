package com.marzhiievskyi.spring_mvc_project.controller;

import com.marzhiievskyi.spring_mvc_project.domain.Client;
import com.marzhiievskyi.spring_mvc_project.domain.Permission;
import com.marzhiievskyi.spring_mvc_project.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String showClients(Model model,
                              @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "size", required = false, defaultValue = "5") int size) {
        Page<Client> pageClients = clientService.getPageClients(page, size);
        model.addAttribute("clients", pageClients);
        return "clients";
    }

    @PostMapping("/{id}")
    public void editClient(@PathVariable String id) {

    }

    @GetMapping("/addNewClient")
    public String createClient(Model model) {
        Client client = new Client();
        model.addAttribute("newClient", client);
        Permission[] permissions = Permission.values();
        model.addAttribute("permissions", permissions);
        return "clientInfo";
    }

    @PostMapping("/saveClient")
    public String createOrUpdate(@ModelAttribute("newClient") @Valid Client client,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Permission[] permissions = Permission.values();
            model.addAttribute("permissions", permissions);
            return "clientInfo";
        }
        clientService.createOrUpdate(client);
        return "redirect:/";

    }
}
