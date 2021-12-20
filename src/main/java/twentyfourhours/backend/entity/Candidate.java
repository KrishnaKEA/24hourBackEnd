package twentyfourhours.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String position;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Party party;
    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    List<Votter> votterList = new ArrayList<>();

    public Candidate(String name, String position) {
        this.name = name;
        this.position = position;
    }
    public void addVotter(Votter votter){
        votterList.add(votter);
        votter.setCandidate(this);

    }
}
