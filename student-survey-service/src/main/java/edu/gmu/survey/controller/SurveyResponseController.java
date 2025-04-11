package edu.gmu.survey.controller;

import edu.gmu.survey.model.SurveyResponse;
import edu.gmu.survey.service.SurveyResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*") // Allow requests from any origin
public class SurveyResponseController {

    private final SurveyResponseService surveyResponseService;

    @Autowired
    public SurveyResponseController(SurveyResponseService surveyResponseService) {
        this.surveyResponseService = surveyResponseService;
    }

    @GetMapping
    public ResponseEntity<List<SurveyResponse>> getAllSurveys() {
        List<SurveyResponse> surveys = surveyResponseService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponse> getSurveyById(@PathVariable Long id) {
        Optional<SurveyResponse> survey = surveyResponseService.getSurveyById(id);
        return survey.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SurveyResponse> createSurvey(@Valid @RequestBody SurveyResponse surveyResponse) {
        SurveyResponse createdSurvey = surveyResponseService.createSurvey(surveyResponse);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyResponse> updateSurvey(@PathVariable Long id, @Valid @RequestBody SurveyResponse surveyResponse) {
        try {
            SurveyResponse updatedSurvey = surveyResponseService.updateSurvey(id, surveyResponse);
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        try {
            surveyResponseService.deleteSurvey(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}