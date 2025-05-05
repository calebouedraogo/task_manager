package com.caleb.taskmanager.controller;

import com.caleb.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TaskController {
    private final TaskRepository taskRepo;
    public TaskController(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public String home(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        return index;
    }
}
