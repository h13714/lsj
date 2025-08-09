package test3;

public class PingpangSpoter extends Spoter implements PlayingPingpang, SpeackingEnglish{
    public PingpangSpoter() {
    }

    public PingpangSpoter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("Studing Pingpang");
    }

    @Override
    public void playPingpang() {
        System.out.println("Playing Pingpang");
    }

    @Override
    public void speakEnglish() {
        System.out.println("Spoter speak English");
    }
}
