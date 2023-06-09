package africa.vote.SmartVote.services.impl;

import africa.vote.SmartVote.datas.models.Result;
import africa.vote.SmartVote.datas.repositories.ResultRepository;
import africa.vote.SmartVote.services.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    @Override
    public void updateCandidateResult(String resultId) {
        Result foundResult = resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Result ID does not exist"));
        foundResult.setNoOfVotes(foundResult
                .getNoOfVotes() + 1);
        resultRepository.save(foundResult);
    }

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }
}