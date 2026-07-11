package com.cognizant.hqljpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.hqljpql.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query(value = "SELECT a FROM Attempt a "
            + "left join fetch a.user u "
            + "left join fetch a.attemptQuestionList aq "
            + "left join fetch aq.question q "
            + "left join fetch q.optionList "
            + "left join fetch aq.attemptOptionList ao "
            + "left join fetch ao.options o "
            + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);

}