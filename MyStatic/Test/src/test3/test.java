package test3;

public class test {
    public static void main(String[] args) {
        PingpangSpoter p = new PingpangSpoter("Tom", 18);
        BasketballSpoter b = new BasketballSpoter("Jerry", 20);
        PingpangCoach cp = new PingpangCoach("Jack", 28);
        BasketballCoach cb = new BasketballCoach("Jimi", 27);

        p.playPingpang();
        p.speakEnglish();
        b.playBasketball();
        cp.speakEnglish();
        cb.playBasketball();
        p.study();
        b.study();
    }
}
