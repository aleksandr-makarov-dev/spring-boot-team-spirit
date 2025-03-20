package com.aleksandrmakarov.springbootteamspirit.service.impl;

import com.aleksandrmakarov.springbootteamspirit.entity.ProjectEntity;
import com.aleksandrmakarov.springbootteamspirit.mapper.ProjectMapper;
import com.aleksandrmakarov.springbootteamspirit.model.request.ProjectRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.ProjectResponse;
import com.aleksandrmakarov.springbootteamspirit.repository.ProjectRepository;
import com.aleksandrmakarov.springbootteamspirit.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
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
    @Transactional
    public ProjectResponse create(ProjectRequest request) {
        ProjectEntity project = projectMapper.mapToProjectEntity(request);
        project.setCreatedAt(LocalDateTime.now());

        ProjectEntity createdProject = projectRepository.save(project);

        log.info("project '{}' was created.", createdProject.getId());

        return projectMapper.mapToProjectResponse(createdProject);
    }

    @Override
    @Transactional
    public ProjectResponse updateById(Long id, ProjectRequest request) {
        ProjectEntity project = getByIdOrThrow(id);

        project.setName(request.name());

        ProjectEntity updatedProject = projectRepository.save(project);

        log.info("project '{}' was updated.", updatedProject.getId());

        return projectMapper.mapToProjectResponse(updatedProject);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ProjectEntity project = getByIdOrThrow(id);

        projectRepository.delete(project);

        log.info("project '{}' was deleted.", project);
    }

    private ProjectEntity getByIdOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project '" + id + "' not found."));
    }
}
