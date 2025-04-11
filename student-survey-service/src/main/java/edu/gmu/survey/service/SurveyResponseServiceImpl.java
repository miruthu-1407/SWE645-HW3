package edu.gmu.survey.service;

import edu.gmu.survey.model.SurveyResponse;
import edu.gmu.survey.repository.SurveyResponseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyResponseServiceImpl implements SurveyResponseService {

    private final SurveyResponseRepository surveyResponseRepository;

    @Autowired
    public SurveyResponseServiceImpl(SurveyResponseRepository surveyResponseRepository) {
        this.surveyResponseRepository = surveyResponseRepository;
    }

    @Override
    public List<SurveyResponse> getAllSurveys() {
        return surveyResponseRepository.findAll();
    }

    @Override
    public Optional<SurveyResponse> getSurveyById(Long id) {
        return surveyResponseRepository.findById(id);
    }

    @Override
    public SurveyResponse createSurvey(SurveyResponse surveyResponse) {
        return surveyResponseRepository.save(surveyResponse);
    }

    @Override
    public SurveyResponse updateSurvey(Long id, SurveyResponse surveyResponseDetails) {
        SurveyResponse surveyResponse = surveyResponseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found with id: " + id));

        // Update the fields
        surveyResponse.setFirstName(surveyResponseDetails.getFirstName());
        surveyResponse.setLastName(surveyResponseDetails.getLastName());
        surveyResponse.setStreetAddress(surveyResponseDetails.getStreetAddress());
        surveyResponse.setCity(surveyResponseDetails.getCity());
        surveyResponse.setState(surveyResponseDetails.getState());
        surveyResponse.setZip(surveyResponseDetails.getZip());
        surveyResponse.setTelephoneNumber(surveyResponseDetails.getTelephoneNumber());
        surveyResponse.setEmail(surveyResponseDetails.getEmail());
        surveyResponse.setDateOfSurvey(surveyResponseDetails.getDateOfSurvey());
        surveyResponse.setCampusLikes(surveyResponseDetails.getCampusLikes());
        surveyResponse.setInterestSource(surveyResponseDetails.getInterestSource());
        surveyResponse.setRecommendationLikelihood(surveyResponseDetails.getRecommendationLikelihood());

        return surveyResponseRepository.save(surveyResponse);
    }

    @Override
    public void deleteSurvey(Long id) {
        SurveyResponse surveyResponse = surveyResponseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Survey not found with id: " + id));
        surveyResponseRepository.delete(surveyResponse);
    }
}