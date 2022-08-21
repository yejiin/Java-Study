package com.example.designpatterns._01_creational_patterns._05_prototype.java;

import com.example.designpatterns._01_creational_patterns._05_prototype.GithubIssue;
import com.example.designpatterns._01_creational_patterns._05_prototype.GithubRepository;
import org.modelmapper.ModelMapper;

public class ModelMapperExample {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("kim");
        repository.setName("study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차");

        GithubIssueData githubIssueData = new GithubIssueData();
        githubIssueData.setId(githubIssue.getId());
        githubIssueData.setRepositoryName(githubIssue.getRepository().getName());

        // ModelMapper 사용
        ModelMapper modelMapper = new ModelMapper();
        GithubIssueData githubIssueData1 = modelMapper.map(githubIssue, GithubIssueData.class);
        System.out.println(githubIssueData1);
    }
}

