package twentyfourhours.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "party")
    List<Candidate> candidateList = new ArrayList<>();

    public Party(String name) {
        this.name = name;
    }

    public void addCandidate(Candidate candidate){
        candidateList.add(candidate);
        candidate.setParty(this);
    }

}
