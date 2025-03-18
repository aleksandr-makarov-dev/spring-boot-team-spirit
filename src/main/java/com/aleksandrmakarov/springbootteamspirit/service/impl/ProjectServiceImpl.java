package com.aleksandrmakarov.springbootteamspirit.service.impl;

import com.aleksandrmakarov.springbootteamspirit.entity.ProjectEntity;
import com.aleksandrmakarov.springbootteamspirit.mapper.ProjectMapper;
import com.aleksandrmakarov.springbootteamspirit.model.request.ProjectRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.ProjectResponse;
import com.aleksandrmakarov.springbootteamspirit.repository.ProjectRepository;
import com.aleksandrmakarov.springbootteamspirit.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectResponse> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::mapToProjectResponse)
                .toList();
    }

    @Override
    public ProjectResponse getById(Long id) {
        return projectMapper.mapToProjectResponse(getByIdOrThrow(id));
    }

    @Override
    public ProjectResponse create(ProjectRequest request) {
        ProjectEntity project = projectMapper.mapToProjectEntity(request);
        project.setCreatedAt(LocalDateTime.now());

        return projectMapper.mapToProjectResponse(projectRepository.save(project));
    }

    @Override
    public ProjectResponse update(Long id, ProjectRequest request) {
        ProjectEntity project = getByIdOrThrow(id);

        project.setName(request.name());

        return projectMapper.mapToProjectResponse(projectRepository.save(project));
    }

    @Override
    public void deleteById(Long id) {
        ProjectEntity project = getByIdOrThrow(id);

        projectRepository.delete(project);
    }

    private ProjectEntity getByIdOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project '" + id + "' not found."));
    }
}
