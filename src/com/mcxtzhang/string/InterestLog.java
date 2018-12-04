package com.mcxtzhang.string;

public class InterestLog {
    public static final boolean DEBUG = false;

    public static void main(String[] args) {
        log("test");

        if (DEBUG) {
            Log.e("TAG", "Explicit concurrent mark sweep " +
                    "GC freed 10477(686KB) AllocSpace objects, 0(0B) " +
                    "LOS objects, 39% free, 9MB/15MB, paused 915us total 28.320ms" + "test");
        }
    }


    public static void log(String msg) {
        if (DEBUG) {
            Log.e("TAG", "Explicit concurrent mark sweep " +
                    "GC freed 10477(686KB) AllocSpace objects, 0(0B) " +
                    "LOS objects, 39% free, 9MB/15MB, paused 915us total 28.320ms" + msg);
        }
    }

    private static class Log {
        public static void e(String tag, String s) {

        }
    }
}
