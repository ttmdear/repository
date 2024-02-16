package com.repo.caffeine;

public class App {

    private final GetUserService getUserService = new GetUserService();

    public static void main(String[] args) {
        new App().run();
    }

    public App() {

    }

    public void run() {
        User user = getUserService.get("10");

        User user1 = getUserService.get("10");
        User user2 = getUserService.get("10");
        User user3 = getUserService.get("10");

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
    }

}
