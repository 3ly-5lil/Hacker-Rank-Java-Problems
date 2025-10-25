public class TextComparator {
    public static void main(String[] args) {
        String a = "mmbRRBFxaaHrZfwjRd\n" +
                "zyozlUCSWW\n" +
                "xpTQlNqz\n" +
                "sfAiidXuOoxQmlK\n" +
                "aWyFOuAWguGBKPUHoDu\n" +
                "NQZAbFSnPudOhyWuXFVsvU\n" +
                "zwwFQMwyzKmdM\n" +
                "efcHhxhYfdiVJEYsRx\n" +
                "DrKFicspkkSpy\n" +
                "MPUFSeXOnRUONciPjJdXHi\n" +
                "aVidElJPiFPOjZaj\n" +
                "MJkbsOToDEuPXGcxaqh\n" +
                "pFDgFbOuQSiMxol\n" +
                "HebumZJvsplOAWOBHGn\n" +
                "mCyfGUQqvsGZUPsg\n" +
                "OIdsO\n" +
                "zdaXLHQoZU\n" +
                "xPorPztEaoOEPuMqN\n" +
                "DdytxekvUq\n" +
                "bomCytxGHGi\n" +
                "VbhDSfeqHipsHfCDhyBxEkwR\n" +
                "stedKTzivLGuxWiUGGiLxtiS\n" +
                "GaDeYopcynsmBIHWokzSOxJJ\n";
        String b = "mmbRRBFxaaHrZfwjRd\n" +
                "zyozlUCSWW\n" +
                "xpTQlNqz\n" +
                "sfAiidXuOoxQmlK\n" +
                "NQZAbFSnPudOhyWuXFVsvU\n" +
                "aWyFOuAWguGBKPUHoDu\n" +
                "zwwFQMwyzKmdM\n" +
                "efcHhxhYfdiVJEYsRx\n" +
                "DrKFicspkkSpy\n" +
                "MPUFSeXOnRUONciPjJdXHi\n" +
                "aVidElJPiFPOjZaj\n" +
                "lmoTwBEpO\n" +
                "HebumZJvsplOAWOBHGn\n" +
                "pFDgFbOuQSiMxol\n" +
                "mCyfGUQqvsGZUPsg\n" +
                "OIdsO\n" +
                "zdaXLHQoZU\n" +
                "DdytxekvUq\n" +
                "xPorPztEaoOEPuMqN\n" +
                "bomCytxGHGi\n" +
                "VbhDSfeqHipsHfCDhyBxEkwR\n" +
                "stedKTzivLGuxWiUGGiLxtiS\n" +
                "GaDeYopcynsmBIHWokzSOxJJ\n" +
                "yWUuFeagdAyVDbenVbbGcY";

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                System.out.printf("char at %d", i);
            }
        }
    }
}
