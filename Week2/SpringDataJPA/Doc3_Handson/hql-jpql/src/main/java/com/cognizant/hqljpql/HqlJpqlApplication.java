package com.cognizant.hqljpql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hqljpql.model.Attempt;
import com.cognizant.hqljpql.model.AttemptOption;
import com.cognizant.hqljpql.model.AttemptQuestion;
import com.cognizant.hqljpql.model.Options;
import com.cognizant.hqljpql.services.AttemptService;
import com.cognizant.hqljpql.services.EmployeeService;

@SpringBootApplication
public class HqlJpqlApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HqlJpqlApplication.class);

    private static EmployeeService employeeService;
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HqlJpqlApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        attemptService = context.getBean(AttemptService.class);

        testGetAttemptDetail();
    }

    private static void testGetAttemptDetail() {
        LOGGER.info("Start testGetAttemptDetail");
        Attempt attempt = attemptService.getAttempt(1, 1);

        for (AttemptQuestion aq : attempt.getAttemptQuestionList()) {
            System.out.println(aq.getQuestion().getText());
            System.out.println();

            int selectedOptionId = -1;
            for (AttemptOption ao : aq.getAttemptOptionList()) {
                selectedOptionId = ao.getOptions().getId();
            }

            int index = 1;
            for (Options option : aq.getQuestion().getOptionList()) {
                boolean selected = option.getId() == selectedOptionId;
                System.out.println(index + ") " + option.getText() + "\t" + option.getScore() + "\t" + selected);
                index++;
            }
            System.out.println();
        }

        LOGGER.info("End testGetAttemptDetail");
    }
}