package twentyfourhours.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyfourhours.backend.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
