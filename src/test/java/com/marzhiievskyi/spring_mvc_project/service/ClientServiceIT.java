package com.marzhiievskyi.spring_mvc_project.service;

import com.marzhiievskyi.spring_mvc_project.domain.Client;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@TestConfiguration
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class ClientServiceIT {

    private final ClientService clientService;

    private Client inClient;
    private Client expectClient;



    @BeforeEach
    void setup() {

    }

    @Test
    void getPageClients() {
    }

    @Test
    void createOrUpdate() {
    }

    @Test
    void getClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void getClientPermissions() {

    }
}