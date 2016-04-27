import org.opencv.core.Core;


public class boot {
    public boot() {

    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new QRWallMarks.Helpers().BeginSession();
    }
}
