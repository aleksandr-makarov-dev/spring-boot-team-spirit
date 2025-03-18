package com.aleksandrmakarov.springbootteamspirit.service.impl;

import com.aleksandrmakarov.springbootteamspirit.repository.ProjectRepository;
import com.aleksandrmakarov.springbootteamspirit.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
}
