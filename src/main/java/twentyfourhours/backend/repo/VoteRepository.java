package twentyfourhours.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyfourhours.backend.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
