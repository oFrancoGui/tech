package com.example.tc.tech_challange.domain.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco getReferenceById(PathVariable id);
    Page<Endereco> findAll(Pageable paginacao);
}
