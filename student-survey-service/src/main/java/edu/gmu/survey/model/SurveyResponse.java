package edu.gmu.survey.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "survey_responses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Street address is required")
    private String streetAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip code is required")
    private String zip;

    @NotBlank(message = "Telephone number is required")
    private String telephoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Date of survey is required")
    private LocalDate dateOfSurvey;

    @ElementCollection
    private List<String> campusLikes; // Options: students, location, campus, atmosphere, dorm rooms, sports

    @NotBlank(message = "Interest source is required")
    private String interestSource; // Options: friends, television, Internet, other

    @NotBlank(message = "Recommendation likelihood is required")
    private String recommendationLikelihood; // Options: Very Likely, Likely, Unlikely
}
