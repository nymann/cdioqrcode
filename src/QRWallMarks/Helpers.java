package QRWallMarks;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import java.awt.image.BufferedImage;

public class Helpers {
    public Helpers() {

    }

    public static void BeginSession() {
        QRWallMarks.GetQRCode q = new QRWallMarks.GetQRCode();
        VideoCapture camera = new VideoCapture(0);
        Mat frame = new Mat();
        camera.read(frame);

        if (!camera.isOpened()) {
            System.out.println("Error");
        } else {
            while (true) {
                if (camera.read(frame)) {
                    BufferedImage image = q.MatToBufferedImage(frame);
                    String qrcode = GetQRCode.readQRCode(image);
                    if (!qrcode.equals("")) {
                        System.out.println(qrcode);
                        q.window(image, "image", 0, 0);
                        break;
                    }
                }
            }
        }
        camera.release();
    }
}
