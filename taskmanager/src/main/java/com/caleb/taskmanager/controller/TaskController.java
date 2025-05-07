package com.caleb.taskmanager.controller;

import com.caleb.taskmanager.model.Task;
import com.caleb.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    private final TaskRepository taskRepo;
    public TaskController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        return "index";
    }

    @GetMapping("/tasks/new")
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }

}
