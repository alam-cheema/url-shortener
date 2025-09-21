package com.example.demo.repository;

import com.example.demo.entity.Url;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);
}
