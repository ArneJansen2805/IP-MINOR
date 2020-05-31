package be.ucll.IP.Minor.dto;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class TaskDTO {

    private String date;
    @NotBlank(message = "Title is mandatory")
    @NotNull
    private String title;
    @NotNull
    @NotBlank(message = "Description is mandatory")
    private String description;
    private List<SubtaskDTO> subtasks = new ArrayList<SubtaskDTO>();
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubtaskDTO> getSubtasks() { return subtasks; }

    public void addSubtask(SubtaskDTO task) { this.subtasks.add(task); }

}
