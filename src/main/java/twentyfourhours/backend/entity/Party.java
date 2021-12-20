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
    @OneToMany(mappedBy = "party",cascade = CascadeType.ALL)
    List<Candidate> candidateList = new ArrayList<>();
    @OneToMany(mappedBy = "party",cascade = CascadeType.ALL)
    List<Vote> voteList = new ArrayList<>();

    public Party(String name, List<Candidate> candidateList, List<Vote> voteList) {
        this.name = name;
        this.candidateList = candidateList;
        this.voteList = voteList;
    }
    public void addCandidate(Candidate candidate){
        candidateList.add(candidate);
        candidate.setParty(this);
    }
    public void addVote(Vote vote){
        voteList.add(vote);
        vote.setParty(this);
    }
}
