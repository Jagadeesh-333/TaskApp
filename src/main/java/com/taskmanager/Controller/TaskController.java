package com.taskmanager.Controller;

import com.taskmanager.Entity.Task;
import com.taskmanager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/tasks")
    @CrossOrigin("*")
    public class TaskController {

        @Autowired
        private TaskService taskService;

        @GetMapping("/getAllTasks")
        public List<Task> getAllTasks() {
            return taskService.getAllTasks();
        }

        @GetMapping("/{id}")
        public Task getTaskById(@PathVariable Long id) {
            return taskService.getTaskById(id);
        }

        @PostMapping("/CreateTask")
        public Task createTask(@RequestBody Task task) {
            return taskService.createTask(task);
        }

        @PutMapping("/{id}")
        public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
            return taskService.updateTask(id, taskDetails);
        }

        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
        }
    }
