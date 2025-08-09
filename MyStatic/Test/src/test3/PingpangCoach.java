package test3;

public class PingpangCoach extends Coach implements PlayingPingpang,SpeackingEnglish{
    public PingpangCoach() {
    }

    public PingpangCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("Teaching Pingpang");
    }

    @Override
    public void playPingpang() {
        System.out.println("Coach playing Pingpang");
    }

    @Override
    public void speakEnglish() {
        System.out.println("Coach speak English");
    }
}
