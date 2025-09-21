package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "urls")
public class Url {
    @Id
    private Long id;
    @Column("short_code")
    private String shortCode;
    @Column("long_url")
    private String longUrl;
    @Column("created_at")
    private OffsetDateTime createdAt;

    public Url(Long id, String code, String longUrl, OffsetDateTime now) {
        this.id = id;
        this.shortCode = code;
        this.longUrl = longUrl;
        this.createdAt = now;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
