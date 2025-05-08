package com.caleb.taskmanager.controller;

import com.caleb.taskmanager.model.Task;
import com.caleb.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/tasks")
    public String create(@ModelAttribute Task task) {
        taskRepo.save(task);
        return  "redirect:/";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskRepo.findById(id).orElseThrow());
        return "edit";
    }

    @PostMapping("/tasks/update")
    public String update(@ModelAttribute Task task) {
        taskRepo.save(task);
        return "redirect:/";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskRepo.deleteById(id);
        return "redirect:/";
    }

}
