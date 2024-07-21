package manage.todo_list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@Table(name = "task_details")
@Getter
@Setter
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE task_details SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taskTodo;
    private Boolean isCompleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    @JsonIgnore
    private Boolean isDeleted;

    public TaskDetail() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.isDeleted = false;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.isDeleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
        this.isDeleted = false;
    }

}
