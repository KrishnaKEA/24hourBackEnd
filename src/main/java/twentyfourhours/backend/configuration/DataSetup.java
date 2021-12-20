package twentyfourhours.backend.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import twentyfourhours.backend.entity.Candidate;
import twentyfourhours.backend.entity.Party;
import twentyfourhours.backend.entity.Votter;
import twentyfourhours.backend.repo.CandidateRepository;
import twentyfourhours.backend.repo.PartyRepository;
import twentyfourhours.backend.repo.VotterRepository;

@Configuration
public class DataSetup implements CommandLineRunner {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;
    VotterRepository votterRepository;

    public DataSetup(CandidateRepository candidateRepository, PartyRepository partyRepository,VotterRepository votterRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
        this.votterRepository = votterRepository;
    }

    @Override
    public void run(String... args) throws Exception {





        Party p1 = new Party("social democrateit");
        Votter v1 = new Votter("Krishna");

        Candidate c1 = new Candidate("Hari","member");
        c1.getVotterList().add(v1);
        c1.setParty(p1);
        candidateRepository.save(c1);

        p1.getCandidateList().add(c1);
        partyRepository.save(p1);
        v1.setCandidate(c1);
        votterRepository.save(v1);


    }
}
