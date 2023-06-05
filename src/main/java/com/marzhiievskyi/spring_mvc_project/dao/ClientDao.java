package com.marzhiievskyi.spring_mvc_project.dao;

import com.marzhiievskyi.spring_mvc_project.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
}
