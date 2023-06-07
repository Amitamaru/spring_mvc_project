package com.marzhiievskyi.spring_mvc_project.controller;

import com.marzhiievskyi.spring_mvc_project.domain.Client;
import com.marzhiievskyi.spring_mvc_project.domain.Permission;
import com.marzhiievskyi.spring_mvc_project.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        model.addAttribute("current_page", page);
        int totalPages = pageClients.getTotalPages(); 
        if (totalPages > 1) {
            List<Integer> totalPagesList IntStream.rangeClosed(1, totalPages).boxed().collected(Collectors.toList());
            model.addAttribute("total_pages", totalPagesList);
        }
        return "clients";
    }

    @ModelAttribute("permissions")
    public Permission[] clientPermissions() {
        return clientService.getClientPermissions();
    }

    @GetMapping("/addNewClient")
    public String addNewClient(Model model) {
        model.addAttribute("newClient", new Client();
        return "clientInfo";
    }


    @PostMapping("/saveClient")
    public String createClient(@Valid @ModelAttribute("newClient") Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clientInfo";
        }
        clientService.createOrUpdate(client);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editClient(@RequestParam("id") Long id, Model model) {
        Optional<Client> client = clientService.getClient(id);
        model.addAttribute("newClient" ,client);
        return "clientInfo";
    }



    @GetMapping("/delete")
    public String deleteClient(@RequestParam("id") Long id) {

        clientService.deleteClient(id);
        return "redirect:/";
    }

}
