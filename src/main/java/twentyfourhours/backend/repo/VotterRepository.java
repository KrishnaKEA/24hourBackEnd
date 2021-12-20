package twentyfourhours.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyfourhours.backend.entity.Votter;

public interface VotterRepository extends JpaRepository<Votter,Long> {
}
