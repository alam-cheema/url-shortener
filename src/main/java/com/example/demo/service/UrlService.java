package com.example.demo.service;

import com.example.demo.entity.Url;
import com.example.demo.repository.UrlRepository;
import com.example.demo.utility.Base62;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class UrlService {
    private final JdbcTemplate jdbc;
    private final UrlRepository repo;

    public UrlService(JdbcTemplate jdbc, UrlRepository repo) {
        this.jdbc = jdbc;
        this.repo = repo;
    }

    public Url createShortUrl(String longUrl) {
        Long id = jdbc.queryForObject("SELECT nextval('url_seq')", Long.class);
        String code = Base62.encode(id);

        Url url = new Url(id, code, longUrl, OffsetDateTime.now());
        return repo.save(url);
    }

    public Optional<Url> resolve(String code) {
        return repo.findByShortCode(code);
    }
}
