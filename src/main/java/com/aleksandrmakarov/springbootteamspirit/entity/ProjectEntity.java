package com.aleksandrmakarov.springbootteamspirit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "projects")
public class ProjectEntity extends BaseEntity {

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
}
