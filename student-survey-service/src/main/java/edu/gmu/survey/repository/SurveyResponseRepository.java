package edu.gmu.survey.repository;

import edu.gmu.survey.model.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    // Spring Data JPA provides basic CRUD operations
    // You can add custom query methods here if needed
}