package com.example.designpatterns._02_structural_patterns._09_decorator._01_before;

public class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어 게임");
        client.writeComment("재밌음...");
        client.writeComment("http://sqaregame.com");
    }
}
