package twentyfourhours.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyfourhours.backend.entity.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    public List<Candidate> getCandidateByPartyName(String name);
    public void deleteById(long id);

}
