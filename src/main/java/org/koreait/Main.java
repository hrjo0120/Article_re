package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lastArticleId = 0;
        List<Article> articles = new ArrayList<Article>();

        Scanner sc = new Scanner(System.in);
        System.out.println("== 프로그램 시작==");

        while(true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if(cmd.length() == 0) {
                System.out.println("명령어를 입력하세요.");
                continue;
            }
            if(cmd.equals("exit")) {
                break;
            }

            String[] cmdBits = cmd.split(" ");

//            String controllerName = cmdBits[0];
//            String actionMethodName = cmdBits[1];

            if(cmdBits.length == 1) {
                System.out.println("명령어를 확인해주세요.");
                continue;
            }

            if(cmdBits[1].equals("write")) {
                System.out.println("== 게시글 작성 ==");
                int id = lastArticleId + 1;
                System.out.print("제목: ");
                String title = sc.nextLine();
                System.out.print("내용: ");
                String body = sc.nextLine();

                Article article = new Article(id, title, body);
                articles.add(article);

                System.out.println(id + "번 글이 생성되었습니다.");
                lastArticleId++;
            } else if(cmdBits[1].equals("list")) {
                System.out.println("== 게시글 목록 ==");
                System.out.println("  번호  /  제목  /  내용");
                for(int i = articles.size() - 1; i >= 0; i--) { // 번호 역순
                    System.out.print("  %d  /  %s  /  %s  ", );
                }
            }

        }


    }
}

class Article {
    private int id;
    private String title;
    private String body;

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}