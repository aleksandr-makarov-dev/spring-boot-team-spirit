package com.aleksandrmakarov.springbootteamspirit.mapper;

import com.aleksandrmakarov.springbootteamspirit.entity.ProjectEntity;
import com.aleksandrmakarov.springbootteamspirit.entity.TaskEntity;
import com.aleksandrmakarov.springbootteamspirit.model.request.TaskRequest;
import com.aleksandrmakarov.springbootteamspirit.model.response.TaskResponse;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskResponse mapToTaskResponse(TaskEntity t) {
        return new TaskResponse(
                t.getId(),
                t.getTitle(),
                t.getStatus(),
                t.getCreatedAt(),
                t.getDueDate(),
                t.getCompletedAt()
        );
    }

    public TaskEntity mapToTaskEntity(TaskRequest t, ProjectEntity project) {

        return TaskEntity.builder()
                .title(t.title())
                .description(t.description())
                .status(t.status())
                .dueDate(t.dueDate())
                .project(project)
                .build();
    }
}
