package com.cognizant.hqljpql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hqljpql.model.Skill;
import com.cognizant.hqljpql.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill get(int id) {
        return skillRepository.findById(id).get();
    }
}