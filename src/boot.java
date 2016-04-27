import org.opencv.core.Core;

import static QRWallMarks.Helpers.*;

public class boot {
    public boot() {

    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        BeginSession();
    }
}
