package com.cognizant.hqljpql.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<Options> optionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Options> getOptionList() {
        return optionList;
    }

    public void setOptionList(Set<Options> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", text=" + text + "]";
    }
}