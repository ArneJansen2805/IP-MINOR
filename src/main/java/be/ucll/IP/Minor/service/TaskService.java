package be.ucll.IP.Minor.service;

import be.ucll.IP.Minor.domain.Task;
import be.ucll.IP.Minor.dto.SubtaskDTO;
import be.ucll.IP.Minor.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskDTO save(TaskDTO s);

    TaskDTO findById(Long aLong);

    List<TaskDTO> findAll();

    void delete(TaskDTO task);

    void deleteByID(Long id);

    void update(TaskDTO task);

    void addSubtask(SubtaskDTO subtask, Long id);


}
