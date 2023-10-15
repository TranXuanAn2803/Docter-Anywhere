package com.example.blog.Repository;

import com.example.blog.Entity.Task;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(@NotNull String title);

}
