package be.ucll.IP.Minor.controller;


import be.ucll.IP.Minor.domain.Subtask;
import be.ucll.IP.Minor.domain.Task;
import be.ucll.IP.Minor.dto.SubtaskDTO;
import be.ucll.IP.Minor.dto.TaskDTO;
import be.ucll.IP.Minor.service.TaskService;
import be.ucll.IP.Minor.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;


@Controller
public class TaskController {


    @Autowired
    private TaskService service;


    @GetMapping("/")
    public String showNav(Model model){
        return "index";
    }

    @GetMapping("/tasks")
    public String showTasksView(Model model){
        model.addAttribute("tasks", service.findAll());
        return "/tasks";
    }

    @GetMapping("/addtask")
    public String showAdd(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "add-task";
    }

    @PostMapping("/addtask")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult result, Model model){
        if(result.hasErrors()){
            return"add-task";
        }
        service.save(task);
        model.addAttribute("tasks", service.findAll());
        return "redirect:/tasks";
    }

    @GetMapping("/detail/{id}")
    public String showDetails(@PathVariable("id") long id, Model model){
        TaskDTO task = service.findById(id);
        model.addAttribute("task", task);
        return "detail-task";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        if (service.findById(id) != null) {
            TaskDTO task = service.findById(id);
            model.addAttribute("task", task);
            return "update-task";
        }
        else {
            model.addAttribute("error", "No task with this ID");
            return "update-task";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") long id, @Valid TaskDTO task,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            task.setId(id);
            return "update-task";
        }

        service.update(task);
        model.addAttribute("tasks", service.findAll());
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteTask(@PathVariable("id") long id, Model model) {
        service.deleteByID(id);
        model.addAttribute("tasks", service.findAll());
        return new RedirectView("/tasks");
    }



    @GetMapping("/subtask/{id}")
    public String getSubtask(@PathVariable("id") long id, Model model) {
        TaskDTO task = service.findById(id);
        SubtaskDTO dto = new SubtaskDTO();
        model.addAttribute("task", task);
        model.addAttribute("subtask", dto);
        return "create-subtask";
    }

    @PostMapping("/subtask/{id}")
    public String addSubtask(@Valid SubtaskDTO subtask, BindingResult result, Model model, @PathVariable("id") long id ) {
        if(result.hasErrors()){
            return "tasks";
        }

        service.addSubtask(subtask, id);
        Collection c = service.findAll();//after exectution of add subtask, subtasks are added. Upon executing this line they are gone.
        model.addAttribute("tasks", c);
        return "tasks";
    }



}
