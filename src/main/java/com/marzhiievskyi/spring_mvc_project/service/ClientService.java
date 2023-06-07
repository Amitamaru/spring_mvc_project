package com.marzhiievskyi.spring_mvc_project.service;

import com.marzhiievskyi.spring_mvc_project.dao.ClientDAO;
import com.marzhiievskyi.spring_mvc_project.domain.Client;
import com.marzhiievskyi.spring_mvc_project.domain.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Page<Client> getPageClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clientDAO.findAll(pageable);
    }

    public void createOrUpdate(Client client) {
        clientDAO.save(client);
    }

    public Optional<Client> getClient(Long id) {
        return clientDAO.findById(id);
    }

    public void deleteClient(Long id) {
        clientDAO.deleteById(id);
    }

    public Permission[] getClientPermissions() {
        return Permission.values();
    }

}
