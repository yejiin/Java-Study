package com.example.designpatterns._01_creational_patterns._05_prototype._02_after;

import com.example.designpatterns._01_creational_patterns._05_prototype._01_before.GithubRepository;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("kim");
        repository.setName("study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차");

        String url = githubIssue.getUrl();
        System.out.println(url);

        GithubIssue clone = (GithubIssue) githubIssue.clone();
        System.out.println(clone.getUrl());

        repository.setUser("park");

        System.out.println(clone != githubIssue);
        System.out.println(clone.equals(githubIssue));
        System.out.println(clone.getClass() == githubIssue.getClass());
        System.out.println(clone.getRepository() == githubIssue.getRepository());

        System.out.println(clone.getUrl());
    }
}
