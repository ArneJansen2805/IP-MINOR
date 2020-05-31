package be.ucll.IP.Minor.domain;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Task")
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Subtask> getSubtasks() { return subtasks; }

    public void addSubtask(Subtask task) { this.subtasks.add(task); }




    private String date;
    @NotBlank(message = "Title is mandatory")
    @NotNull
    private String title;
    @NotNull
    @NotBlank(message = "Description is mandatory")
    private String description;

    @OneToMany( cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "task_id")
    private List<Subtask> subtasks = new ArrayList<>();


/**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getId() == task.getId() &&
                Objects.equals(getDate(), task.getDate()) &&
                Objects.equals(getTitle(), task.getTitle()) &&
                Objects.equals(getDescription(), task.getDescription());
    }
**/
    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTitle(), getDescription(), getId());
    }
}
