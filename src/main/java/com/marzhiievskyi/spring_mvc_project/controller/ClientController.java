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

    @GetMapping("/{id}")
    public String editClient(@PathVariable String id, Model model) {
            Optional<Client> clientToUpdate = clientService.getClient(id);
            model.addAttribute("newClient", clientToUpdate);
            Permission[] permissions = clientService.getClientPermissions();
            model.addAttribute("permissions", permissions);
            return "clientInfo";
    }

    @GetMapping("/addNewClient")
    public String createClient(Model model) {
        Client client = new Client();
        model.addAttribute("newClient", client);
        Permission[] permissions = clientService.getClientPermissions();
        model.addAttribute("permissions", permissions);
        return "clientInfo";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("newClient") @Valid Client client,
                             BindingResult bindingResult, 
                             @ModelAttribute("permissions" Permission[] permissions) ) {
        if (bindingResult.hasErrors()) { 
            return "clientInfo";
        }
        clientService.createOrUpdate(client);
        return "redirect:/";
    }
}
