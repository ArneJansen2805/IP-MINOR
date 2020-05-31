package be.ucll.IP.Minor.dto;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class SubtaskDTO {

    @NotBlank(message = "Title is mandatory")
    @NotNull
    private String title;
    @NotNull
    @NotBlank(message = "Description is mandatory")
    private String description;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
