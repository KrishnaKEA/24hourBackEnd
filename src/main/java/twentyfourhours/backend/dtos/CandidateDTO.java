package twentyfourhours.backend.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import twentyfourhours.backend.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CandidateDTO {
    private long id;
    private String name;
    private String position;
    private String partyname;


    public CandidateDTO(String name, String position, String partyname) {
        this.name = name;
        this.position = position;
        this.partyname = partyname;

    }

    public CandidateDTO(Candidate candidate) {
        this.name = candidate.getName();
        this.position = candidate.getPosition();
        this.id = candidate.getId();

    }

    public static List<CandidateDTO> candidatesToCandidateDTOS(Iterable<Candidate> candidates) {
        List<CandidateDTO> candidateDTOS = new ArrayList<>();
        for (Candidate candidate : candidates) {
            CandidateDTO cdDTO = new CandidateDTO(candidate);
            cdDTO.setPartyname(candidate.getParty().getName());
            candidateDTOS.add(cdDTO);
        }
        return candidateDTOS;
    }

    public static Candidate candidateFromCanditateDTO(CandidateDTO candidateDTO) {

        Candidate c = new Candidate(candidateDTO.getName(), candidateDTO.getPosition());
        return c;
    }

}
