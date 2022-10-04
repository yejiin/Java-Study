package com.example.designpatterns._01_creational_patterns._05_prototype._01_before;

import com.example.designpatterns._01_creational_patterns._05_prototype._02_after.GithubIssue;

public class App {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("kim");
        repository.setName("study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차");

        String url = githubIssue.getUrl();
        System.out.println(url);
    }
}
