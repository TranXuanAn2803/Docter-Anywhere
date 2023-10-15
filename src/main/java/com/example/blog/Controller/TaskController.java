package com.example.blog.Controller;

import com.example.blog.Entity.Task;
import com.example.blog.Request.TaskRequest;
import com.example.blog.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskService service;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll()
    {
        List<TaskRequest> taskRequests= this.service.getAll();
        return new ResponseEntity<>(taskRequests, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetail(@PathVariable Long id)
    {
        try {
            TaskRequest taskRequest = this.service.getDetail(id);
            return new ResponseEntity<>(taskRequest, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody TaskRequest taskRequest)
    {
        try {
            TaskRequest task= this.service.create(taskRequest);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody TaskRequest taskRequest)
    {
        try {
            TaskRequest task= this.service.update(id, taskRequest);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            this.service.delete(id);
            return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

}
