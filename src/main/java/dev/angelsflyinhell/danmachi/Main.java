package dev.angelsflyinhell.danmachi;

import dev.angelsflyinhell.danmachi.library.XPEngine.*;

public class Main {

    public static void main(String[] args) {
        Danmachi.init();

        User user = new User("123");
        user.addXP(12);

        long xp = user.getXP();
        long level = user.getLevel();
        String userId = user.getId();

        System.out.println(userId + ": {" + xp + ", " + level + "}");

        user.removeXP(123);

        xp = user.getXP();
        level = user.getLevel();
        userId = user.getId();

        System.out.println(userId + ": {" + xp + ", " + level + "}");
    }

}
