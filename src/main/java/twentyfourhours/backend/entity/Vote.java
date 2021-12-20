package twentyfourhours.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Candidate candidate;
    @ManyToOne
    private Party party;

    public Vote(Candidate candidate, Party party) {
        this.candidate = candidate;
        this.party = party;
    }
}
