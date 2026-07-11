package com.cognizant.countryquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.countryquery.model.Skill;
import com.cognizant.countryquery.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill get(int id) {
        return skillRepository.findById(id).get();
    }

    public void save(Skill skill) {
        skillRepository.save(skill);
    }
}