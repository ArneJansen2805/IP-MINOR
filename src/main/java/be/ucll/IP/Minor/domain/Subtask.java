package be.ucll.IP.Minor.domain;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Subtask {



        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

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


        @NotBlank(message = "Title is mandatory")
        @NotNull
        private String title;
        @NotNull
        @NotBlank(message = "Description is mandatory")
        private String description;




}
