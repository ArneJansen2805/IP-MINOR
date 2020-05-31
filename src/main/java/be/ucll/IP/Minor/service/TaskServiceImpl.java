package be.ucll.IP.Minor.service;

import be.ucll.IP.Minor.domain.Subtask;
import be.ucll.IP.Minor.domain.Task;

import be.ucll.IP.Minor.dto.SubtaskDTO;
import be.ucll.IP.Minor.dto.TaskDTO;
import be.ucll.IP.Minor.repository.JPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements  be.ucll.IP.Minor.service.TaskService {


    private final JPARepo repository;

    @Autowired
    public TaskServiceImpl(JPARepo repository){
        this.repository = repository;


    }

    @Override
    public TaskDTO save(TaskDTO s) {
        repository.save(convertDTO(s));
        return s;
    }


    @Override
    public TaskDTO findById(Long aLong) {
       return convert(repository.findById(aLong).get());
    }


    @Override
    public List<TaskDTO> findAll() {
       return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }



    @Override
    public void delete(TaskDTO task) {
        repository.deleteById(task.getId());
    }

    @Override
    public void deleteByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(TaskDTO dto) {
        Task task = repository.findById(dto.getId()).get();
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setDate(dto.getDate());
        repository.deleteById(dto.getId());
        repository.save(task);
    }

    @Override
    public void addSubtask(SubtaskDTO subtask, Long id) {

        Task task = repository.findById(id).get();

        Subtask sub = new Subtask();
        sub.setDescription(subtask.getDescription());
        sub.setTitle(subtask.getTitle());
        task.getSubtasks().add(sub);
        Collection c = repository.findAll();


    }


    private TaskDTO convert(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setDate(task.getDate());
        dto.setDescription(task.getDescription());
        dto.setTitle(task.getTitle());
        dto.setId(task.getId());
        return dto;
    }

    public Task convertDTO(TaskDTO dto){
        Task task = new Task();
        task.setDate(dto.getDate());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        return task;
    }

    private void fill() {
       // Task t1 = new Task("15 januari", "IP TEST", "Dit is een Demo van mijn project voor het vak IP Minor." );
       // Task t2 = new Task("16 januari", "Opgave", "We maken een applicatie om taken bij te houden." );
       // Task t3 = new Task("17 januari", "Vooruitgang", "Je kan al taken aanmaken, updaten, verwijderen en de details opvragen.");
        //repository.save(t1);
       // repository.save(t2);
        //repository.save(t3);

    }
}
