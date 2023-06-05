package com.marzhiievskyi.spring_mvc_project.service;

import com.marzhiievskyi.spring_mvc_project.dao.ClientDao;
import com.marzhiievskyi.spring_mvc_project.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    public List<Client> getAllClientList() {
        return clientDao.findAll();
    }
}
