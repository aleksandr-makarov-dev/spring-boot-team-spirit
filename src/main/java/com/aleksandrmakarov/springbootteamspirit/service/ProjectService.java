package com.aleksandrmakarov.springbootteamspirit.service;

import com.aleksandrmakarov.springbootteamspirit.model.request.ProjectRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> getAll();

    ProjectResponse getById(Long id);

    ProjectResponse create(ProjectRequest request);

    ProjectResponse updateById(Long id, ProjectRequest request);

    void deleteById(Long id);
}
