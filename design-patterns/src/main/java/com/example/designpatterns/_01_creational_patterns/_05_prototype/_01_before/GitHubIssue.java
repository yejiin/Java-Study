package com.example.designpatterns._01_creational_patterns._05_prototype._01_before;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubIssue {

    private int id;

    private String title;

    private GithubRepository repository;

    public GitHubIssue(GithubRepository repository) {
        this.repository = repository;
    }

    public String getUrl() {
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                this.getId());
    }
}
