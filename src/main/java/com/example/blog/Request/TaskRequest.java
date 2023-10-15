package com.example.blog.Request;

import com.example.blog.Entity.Task;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    public static TaskRequest valueOf(Task task){
        return TaskRequest.builder().id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .build();
    }
}
