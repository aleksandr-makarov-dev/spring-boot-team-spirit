package com.aleksandrmakarov.springbootteamspirit.repository;

import com.aleksandrmakarov.springbootteamspirit.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> getAllByProjectId(Long projectId);
}
