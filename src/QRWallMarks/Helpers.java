package QRWallMarks;

import de.yadrone.apps.controlcenter.plugins.video.VideoPanel;
import de.yadrone.base.IARDrone;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.awt.image.BufferedImage;

public class Helpers {
    public Helpers() {

    }

    public void BeginSession() {
        QRWallMarks.GetQRCode q = new QRWallMarks.GetQRCode();
        VideoCapture camera = new VideoCapture(0);
        Mat frame = new Mat();
        camera.read(frame);

        // This is currently checking over and over again if a QR code has
        // been read by the webcam, to implement this with the drone, it
        // should just call the GetQRCode.readQRCode(bufferedimage) directly,
        // then that function will return either the code or 3 error messages.
        if (!camera.isOpened()) {
            System.out.println("Error");
        } else {
            while (true) {
                if (camera.read(frame)) {
                    BufferedImage image = q.MatToBufferedImage(frame);
                    String qrcode = GetQRCode.readQRCode(image);
                    if (qrcode.charAt(0) == 'W') {
                        System.out.println(qrcode);
                        q.window(image, "QRCode Detected.", 0, 0);
                        break;
                    }
                }
            }
        }
        camera.release();
    }
}
