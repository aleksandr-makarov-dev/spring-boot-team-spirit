package com.aleksandrmakarov.springbootteamspirit.service;

import com.aleksandrmakarov.springbootteamspirit.model.request.TaskRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getByProjectId(Long projectId);

    TaskResponse getById(Long id);

    TaskResponse create(TaskRequest request);

    TaskResponse updateById(Long id, TaskRequest request);

    void deleteById(Long id);
}
