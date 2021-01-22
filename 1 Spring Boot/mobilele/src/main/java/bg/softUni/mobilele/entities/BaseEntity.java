package bg.softUni.mobilele.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @Column(nullable = false)
    protected LocalDateTime created;


    @Column(nullable = false)
    protected LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
