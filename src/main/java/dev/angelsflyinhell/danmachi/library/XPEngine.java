package dev.angelsflyinhell.danmachi.library;

import dev.angelsflyinhell.danmachi.library.utils.ConsoleController;

/**
 * Danmachi is a fully managed XP System.
 * <p>Use {@link Danmachi#init()} to initialize the system. This call needs to be made every time, your application starts</p>
 * <p>After that, you can simply use the {@link User} Object to manage your save entries.</p>
 */
public class XPEngine {

    private static long levelIncrease = 2;
    private static long levelDivision = 2;
    private static long maxLevel = 100;

    public static class Danmachi {

        /**
         * Initialize Danmachi.
         */
        public static void init() {
            Storage.init();
            System.out.println(ConsoleController.IDENTIFIER + ConsoleController.DANMACHIINFO);
            System.out.println(ConsoleController.IDENTIFIER + "Initialized danmachi. XP System is ready to use.");
        }
    }

    public static class User {

        public String uid;
        public long xp;
        public long level;

        public User(String s) {
            this.uid = s;
        }

        /**
         * Add XP to an User.
         * @param amount The amount of XP to be added.
         * @return {@link User} Object
         */
        public User addXP(long amount) {
            long uxp;
            if(Storage.propExist(uid))
                uxp = Long.parseLong(Storage.getValue(uid));
            else
                uxp = 0;

            Storage.addKey(uid, String.valueOf(uxp + amount));
            return this;
        }

        /**
         * Remove XP from an User.
         * @param amount The amount of XP to be removed.
         * @return {@link User} Object
         */
        public User removeXP(long amount) {
            long uxp;
            if(Storage.propExist(uid))
                uxp = Long.parseLong(Storage.getValue(uid));
            else
                uxp = 0;

            Storage.addKey(uid, String.valueOf(uxp - amount));
            return this;
        }

        /**
         * Deletes a user from the savefile.
         * @deprecated
         */
        public void delete() {
            if(Storage.propExist(uid))
                Storage.deleteKey(uid);
        }

        /**
         * Get all info about a specified User.
         * @return {@link User} Object
         */
        public User getUser() {

            this.xp = 0;
            this.level = 0;
            if(Storage.propExist(uid)) {
                this.xp = Long.parseLong(Storage.getValue(uid));
                this.level = (long) Math.sqrt(2 * this.xp) / 10;
            }
            return this;
        }

        /**
         * Get a Users amount of XP.
         * @return long xp
         */
        public long getXP() {
            return getUser().xp;
        }

        /**
         * Get a Users level.
         * @return long level
         */
        public long getLevel() {
            return getUser().level;
        }

        /**
         * Get a Users ID.
         * @return String Id
         */
        public String getId() {
            return getUser().uid;
        }

    }
}
