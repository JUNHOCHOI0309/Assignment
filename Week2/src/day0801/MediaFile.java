package day0801;

public class MediaFile {
    String filename;
    double size;

    public MediaFile(String filename, double size) {
        this.filename = filename;
        this.size = size;
    }

    public void open(){
        System.out.println("파일을 엽니다.");
    }
    public void compress(double rate) {
        double newSize = size * rate;
        System.out.println(filename + "을 " + (rate * 100) + "%로 압축합니다. 파일 크기: " + newSize + "MB");
    }

    public void compress(double rate, String destination) {
        double newSize = size * rate;
        System.out.println(filename + "을 " + (rate * 100) + "%로 압축하여 " + destination + "에 저장합니다. 파일 크기: " + newSize + "MB");
    }

    public static void main(String[] args) {
        MediaFile[] files = new MediaFile[3];
        files[0] = new ImageFile("image1.jpg", 1000000);
        files[1] = new VideoFile("video1.mp4", 10000000);
        files[2] = new AudioFile("audio1.mp3", 100000000);
        for(MediaFile file : files){
            file.open();
            file.compress(0.5);
        }
        for(MediaFile file : files){
            file.open();
            file.compress(0.9, "C:/Users/CHOI/Desktop");
        }
    }
}

class ImageFile extends MediaFile{
    public ImageFile(String filename, double size) {
        super(filename, size);
    }

    @Override
    public void open() {
        System.out.println("이미지 파일을 엽니다.");
    }
}
class VideoFile extends MediaFile{
    public VideoFile(String filename, double size) {
        super(filename, size);
    }

    @Override
    public void open() {
        System.out.println("비디오 파일을 엽니다.");
    }
}
class AudioFile extends MediaFile{
    public AudioFile(String filename, double size) {
        super(filename, size);
    }

    @Override
    public void open() {
        System.out.println("오디오 파일을 엽니다.");
    }
}