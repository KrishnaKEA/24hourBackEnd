package twentyfourhours.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
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
    @OneToMany(mappedBy = "candidate",cascade = CascadeType.ALL)
    List<Vote> votes = new ArrayList<>();
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="party_id",referencedColumnName = "id")
    private Party party;

    public Candidate(String name, String position, List<Vote> votes, Party party) {
        this.name = name;
        this.position = position;
        this.votes = votes;
        this.party = party;
    }

    public void addVote(Vote vote){
        votes.add(vote);
        vote.setCandidate(this);
    }

}
