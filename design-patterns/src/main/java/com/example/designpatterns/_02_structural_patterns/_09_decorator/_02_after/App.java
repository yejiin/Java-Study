package com.example.designpatterns._02_structural_patterns._09_decorator._02_after;

public class App {

    private static boolean enabledSpamFilter = true;
    private static boolean enabledTrimming = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (enabledSpamFilter) {
            commentService = new SpamFilterCommentDecorator(commentService);
        }

        if (enabledTrimming) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        Client client = new Client(commentService);
        client.writeComment("오징어 게임");
        client.writeComment("재밌음...");
        client.writeComment("http://sqaregame.com");
    }
}
