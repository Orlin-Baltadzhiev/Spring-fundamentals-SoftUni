package bg.softUni.mobilele.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {


    @Column(unique = true,nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
