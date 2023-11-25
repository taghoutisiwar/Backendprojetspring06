package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.entities.Team;

@RepositoryRestResource(path = "te")
@CrossOrigin("*")
public interface TeamRepository extends JpaRepository<Team, Long> {

}
