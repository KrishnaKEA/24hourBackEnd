package twentyfourhours.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import twentyfourhours.backend.entity.Party;

public interface PartyRepository extends JpaRepository<Party,Long> {
}
