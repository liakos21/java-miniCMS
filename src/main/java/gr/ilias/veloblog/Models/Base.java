package gr.ilias.veloblog.Models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    public boolean isPersisted() {
        return id != null && id != 0L;
    }
}
