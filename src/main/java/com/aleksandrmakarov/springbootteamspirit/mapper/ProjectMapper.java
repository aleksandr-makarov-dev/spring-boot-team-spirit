package com.aleksandrmakarov.springbootteamspirit.mapper;

import com.aleksandrmakarov.springbootteamspirit.entity.ProjectEntity;
import com.aleksandrmakarov.springbootteamspirit.model.request.ProjectRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.ProjectResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectResponse mapToProjectResponse(ProjectEntity p) {
        return new ProjectResponse(p.getId(), p.getName(), p.getCreatedAt());
    }

    public ProjectEntity mapToProjectEntity(ProjectRequest p) {
        return ProjectEntity.builder()
                .name(p.name())
                .build();
    }
}
