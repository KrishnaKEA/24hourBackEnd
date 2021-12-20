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

    public DataSetup(CandidateRepository candidateRepository, PartyRepository partyRepository, VotterRepository votterRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
        this.votterRepository = votterRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Party p1 = new Party("social democrateit");
        Votter v1 = new Votter("Krishna");
        Candidate c1 = new Candidate("Hari", "member");
        c1.getVotterList().add(v1);
        c1.setParty(p1);
        candidateRepository.save(c1);
        p1.getCandidateList().add(c1);
        partyRepository.save(p1);
        v1.setCandidate(c1);
        votterRepository.save(v1);

        Party p3 = new Party("Socialistisk Folkeparti");
        Votter v3 = new Votter("Ulla Holm");
        Candidate c3 = new Candidate("Per Urban Olsen", "Secretary");
        c3.getVotterList().add(v3);
        c3.setParty(p3);
        candidateRepository.save(c3);
        p3.getCandidateList().add(c3);
        partyRepository.save(p3);
        v3.setCandidate(c3);
        votterRepository.save(v3);

        Party p5 = new Party("Venstre, Danmarks Liberale Parti");
        Votter v5 = new Votter("Rita");
        Candidate c5 = new Candidate("Søren Wiese", "Member");
        c5.getVotterList().add(v5);
        c5.setParty(p5);
        candidateRepository.save(c5);
        p5.getCandidateList().add(c5);
        partyRepository.save(p5);
        v5.setCandidate(c5);
        votterRepository.save(v5);

        Party p6 = new Party("Enhedslisten + De Rød Grønne");
        Votter v6 = new Votter("Rashmusen");
        Candidate c6 = new Candidate("Pia Birkmand", "Vice president");
        c6.getVotterList().add(v6);
        c6.setParty(p6);
        candidateRepository.save(c6);
        p6.getCandidateList().add(c6);
        partyRepository.save(p6);
        v6.setCandidate(c6);
        votterRepository.save(v6);

        Party p2 = new Party("Det konservative Folkeparti");
        Votter v2 = new Votter("Wolf");
        Candidate c2 = new Candidate("Louise Bramstorp", "Vice president");
        c2.getVotterList().add(v2);
        c2.setParty(p2);
        candidateRepository.save(c2);
        p2.getCandidateList().add(c2);
        partyRepository.save(p2);
        v2.setCandidate(c2);
        votterRepository.save(v2);
    }
}
