package com.aleksandrmakarov.springbootteamspirit.service.impl;

import com.aleksandrmakarov.springbootteamspirit.entity.ProjectEntity;
import com.aleksandrmakarov.springbootteamspirit.entity.TaskEntity;
import com.aleksandrmakarov.springbootteamspirit.mapper.TaskMapper;
import com.aleksandrmakarov.springbootteamspirit.model.request.TaskRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.TaskResponse;
import com.aleksandrmakarov.springbootteamspirit.repository.ProjectRepository;
import com.aleksandrmakarov.springbootteamspirit.repository.TaskRepository;
import com.aleksandrmakarov.springbootteamspirit.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskResponse> getByProjectId(Long projectId) {
        return taskRepository.getAllByProjectId(projectId)
                .stream()
                .map(taskMapper::mapToTaskResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getById(Long id) {
        return taskMapper.mapToTaskResponse(getTaskByIdOrThrow(id));
    }

    @Override
    @Transactional
    public TaskResponse create(TaskRequest request) {

        ProjectEntity project = getProjectByIdOrThrow(request.projectId());

        TaskEntity task = taskMapper.mapToTaskEntity(request, project);
        task.setCreatedAt(LocalDateTime.now());

        project.getTasks().add(task);

        TaskEntity createdTask = taskRepository.save(task);

        log.info("project '{}' was created.", createdTask.getId());

        return taskMapper.mapToTaskResponse(createdTask);
    }

    @Override
    @Transactional
    public TaskResponse updateById(Long id, TaskRequest request) {

        // TODO: update does not work >:(.

        ProjectEntity project = getProjectByIdOrThrow(request.projectId());

        TaskEntity task = getTaskByIdOrThrow(id);

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setCompletedAt(request.completedAt());
        task.setProject(project);

        project.getTasks().add(task);

        TaskEntity updatedTask = taskRepository.save(task);

        log.info("project '{}' was updated.", updatedTask.getId());

        return taskMapper.mapToTaskResponse(updatedTask);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        TaskEntity task = getTaskByIdOrThrow(id);

        taskRepository.delete(task);

        log.info("task '{}' was deleted.", task);
    }

    private TaskEntity getTaskByIdOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task '" + id + "' not found."));
    }

    private ProjectEntity getProjectByIdOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project '" + id + "' not found"));
    }
}
