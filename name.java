public class name {
    public static void main(String[] args) {
        Image guestImage = new ProxyImage("salary_sheet.png", "GUEST");
        Image adminImage = new ProxyImage("salary_sheet.png", "ADMIN");
        guestImage.show();
        adminImage.show();

        System.out.println();

        Video video = new ProxyVideo("Cat_Memes.mp4");
        video.play();

        System.out.println();

        video.play();

        System.out.println();

        video.play();

        System.out.println();

        Internet internet = new SchoolProxyInternet();
        internet.connectTo("wikipedia.org");
        internet.connectTo("gaming.com");

        System.out.println();

        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);
        remote.powerOn();
        remote.mute();

        System.out.println();

        Device radio = new Radio();
        PartyRemote partyRemote = new PartyRemote(radio);
        partyRemote.partyMode();

        System.out.println();

        Knight swordKnight = new Knight(new Sword());
        swordKnight.attack();

        Knight magicKnight = new Knight(new MagicWand());
        magicKnight.attack();
    }

    static class PartyRemote extends BasicRemote {
        public PartyRemote(Device device) {
            super(device);
        }

        public void partyMode() {
            System.out.println("[Party Remote] Pumping up the party!");
            device.turnOn();
            device.setVolume(100);
        }
    }

    static class ProxyImage implements Image {
        private final String fileName;
        private final String userRole;
        private RealImage realImage;

        public ProxyImage(String fileName, String userRole) {
            this.fileName = fileName;
            this.userRole = userRole;
        }

        public void show() {
            if (!"ADMIN".equals(userRole)) {
                System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
                return;
            }

            if (realImage == null) {
                realImage = new RealImage(fileName);
            }

            realImage.show();
        }
    }

    static class ProxyVideo implements Video {
        private final String fileName;
        private RealVideo realVideo;
        private int viewCount = 0;

        public ProxyVideo(String fileName) {
            this.fileName = fileName;
        }

        public void play() {
            viewCount++;
            System.out.println("--> [AUDIT] Main.Video has been played " + viewCount + " time(s).");

            if (realVideo == null) {
                realVideo = new RealVideo(fileName);
            }

            realVideo.play();
        }
    }

    static class Radio implements Device {
        public void turnOn() {
            System.out.println("Main.Radio starts playing static/music.");
        }

        public void turnOff() {
            System.out.println("Main.Radio turns off.");
        }

        public void setVolume(int level) {
            System.out.println("Main.Radio volume knob turned to: " + level);
        }
    }

    static class RealImage implements Image {
        private final String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
        }

        public void show() {
            System.out.println("Displaying " + fileName + " on screen!");
        }
    }

    static class RealInternet implements Internet {
        public void connectTo(String site) {
            System.out.println("Connected to site: " + site);
        }
    }

    static class RealVideo implements Video {
        private final String fileName;

        public RealVideo(String fileName) {
            this.fileName = fileName;
            download();
        }

        private void download() {
            System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + fileName);
        }

        public void play() {
            System.out.println("Playing video: " + fileName);
        }
    }

    static class SchoolProxyInternet implements Internet {
        private RealInternet realInternet;

        public void connectTo(String site) {
            if ("gaming.com".equals(site) || "socialmedia.com".equals(site)) {
                System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
                return;
            }

            if (realInternet == null) {
                realInternet = new RealInternet();
            }

            realInternet.connectTo(site);
        }
    }

    static class SmartLight implements Device {
        public void turnOn() {
            System.out.println("Smart Light glows bright white.");
        }

        public void turnOff() {
            System.out.println("Smart Light shuts off.");
        }

        public void setVolume(int level) {
            System.out.println("Smart Light brightness set to: " + level + "%");
        }
    }

    static class Sword implements Weapon {
        public void use() {
            System.out.println("Slash! Dealing 20 physical damage.");
        }
    }

    static interface Video {
        void play();
    }

    static interface Weapon {
        void use();
    }

    static class Wizard extends Hero {
        public Wizard(Weapon weapon) {
            super(weapon);
        }

        public void attack() {
            weapon.use();
        }
    }

    static class AdvancedRemote extends BasicRemote {
        public AdvancedRemote(Device device) {
            super(device);
        }

        public void mute() {
            System.out.println("[Remote] Mute button pressed!");
            device.setVolume(0);
        }
    }

    static class BasicRemote {
        protected final Device device;

        public BasicRemote(Device device) {
            this.device = device;
        }

        public void powerOn() {
            device.turnOn();
        }

        public void powerOff() {
            device.turnOff();
        }
    }

    static interface Device {
        void turnOn();

        void turnOff();

        void setVolume(int level);
    }

    abstract static class Hero {
        protected final Weapon weapon;

        public Hero(Weapon weapon) {
            this.weapon = weapon;
        }
    }

    static interface Image {
        void show();
    }

    static interface Internet {
        void connectTo(String site);
    }

    static class Knight extends Hero {
        public Knight(Weapon weapon) {
            super(weapon);
        }

        public void attack() {
            weapon.use();
        }
    }

    static class MagicWand implements Weapon {
        public void use() {
            System.out.println("Zap! Dealing 35 magic damage.");
        }
    }
}
