package com.example.blog.Service;

import com.example.blog.Entity.Task;
import com.example.blog.Repository.TaskRepository;
import com.example.blog.Request.TaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TaskService {
    @Autowired
    TaskRepository repository;
    public List<TaskRequest> getAll() {
        List<Task> tasks= repository.findAll();
        List<TaskRequest> taskRequests = new ArrayList<TaskRequest>();
        for (Task t:tasks) {
            TaskRequest taskRequest = TaskRequest.valueOf(t);
            taskRequests.add(taskRequest);
        }
        return taskRequests;
    }

    public TaskRequest getDetail(Long id) throws Exception {
        Optional<Task> task=repository.findById(id);
        if(!task.isPresent()){
            throw new Exception("Task does not exist");
        }
        TaskRequest taskRequest=TaskRequest.valueOf(task.get());
        return taskRequest;
    }

    public TaskRequest create(TaskRequest taskRequest) throws Exception {
        if(taskRequest==null|| taskRequest.getTitle()==null)
            throw new Exception("Task's title can not be null");

        Task task = repository.findByTitle(taskRequest.getTitle());
        if(task!=null)
            throw new Exception("Task's title already exist");
        task=new Task();
        task.setTitle(taskRequest.getTitle());
        if(taskRequest.getDescription()!=null&&!taskRequest.getDescription().toString().isEmpty()) task.setDescription(taskRequest.getDescription());
        if(taskRequest.getCompleted()!=null) task.setCompleted(taskRequest.getCompleted());
        repository.save(task);
        return TaskRequest.valueOf(task);
    }

    public TaskRequest update(Long id,TaskRequest taskRequest) throws Exception {
        Optional<Task> task = repository.findById(id);
        if(!task.isPresent()){
            throw new Exception("Task does not exist");
        }
        Task updateTask=task.get();
        if(taskRequest.getTitle()!=null&&!taskRequest.getTitle().toString().trim().isEmpty()) updateTask.setTitle(taskRequest.getTitle());
        if(taskRequest.getDescription()!=null&&!taskRequest.getDescription().toString().isEmpty()) updateTask.setDescription(taskRequest.getDescription());
        if(taskRequest.getCompleted()!=null) updateTask.setCompleted(taskRequest.getCompleted());
        repository.save(updateTask);
        return TaskRequest.valueOf(updateTask);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
