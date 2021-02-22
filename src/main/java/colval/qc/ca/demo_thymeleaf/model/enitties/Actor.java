package colval.qc.ca.demo_thymeleaf.model.enitties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "actor")
@NamedQueries({
        @NamedQuery(name = "Actor.findByActorId", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId")
        , @NamedQuery(name = "Actor.findByFirstName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstName")
        , @NamedQuery(name = "Actor.findByLastName", query = "SELECT a FROM Actor a WHERE a.lastName = :lastName")
        , @NamedQuery(name = "Actor.findByLastUpdate", query = "SELECT a FROM Actor a WHERE a.lastUpdate = :lastUpdate")
        , @NamedQuery(name = "Actor.countAll", query = "SELECT count(a) FROM Actor a")
        , @NamedQuery(name = "Actor.findAllActorIdAsc",query = "SELECT a FROM Actor a order by a.actorId asc ")})

@NoArgsConstructor
@AllArgsConstructor
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actorId;

    @Column(name = "first_name")
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

    public long getActorId() {
        return this.actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(java.sql.Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
