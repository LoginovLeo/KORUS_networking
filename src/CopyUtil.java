import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyUtil {
    public static int copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[2048];
        int bytesRead = 0;
        int totalBytes = 0;
        while((bytesRead = in.read(buf)) != -1) {
            totalBytes += bytesRead;
            out.write(buf, 0, bytesRead);
        }
        return totalBytes;
    }
}
