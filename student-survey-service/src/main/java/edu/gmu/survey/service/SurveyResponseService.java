package edu.gmu.survey.service;

import edu.gmu.survey.model.SurveyResponse;

import java.util.List;
import java.util.Optional;

public interface SurveyResponseService {
    List<SurveyResponse> getAllSurveys();
    Optional<SurveyResponse> getSurveyById(Long id);
    SurveyResponse createSurvey(SurveyResponse surveyResponse);
    SurveyResponse updateSurvey(Long id, SurveyResponse surveyResponse);
    void deleteSurvey(Long id);
}