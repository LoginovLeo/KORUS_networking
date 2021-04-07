import java.io.*;
import java.net.Socket;

public class Client {
    private final static String PROTOCOL = "UDP";
    private final static int TCP_PORT = 3345;
    private final static String IP = "192.168.0.113";

    public static void main(String[] args) throws IOException {
        try {
            Socket tcpClient = new Socket(IP, TCP_PORT);
            InputStream in = new BufferedInputStream(new FileInputStream("1GB.zip"));
            OutputStream out = tcpClient.getOutputStream();


            long timeStart = System.currentTimeMillis() / 1000;
            long bytesSend = CopyUtil.copy(in,out) / 1000;
            long timeEnd = System.currentTimeMillis() / 1000;
            tcpClient.close();
            System.out.println("Average speed of TCP uploading: " + bytesSend / (timeEnd - timeStart) + " kb/s. Time of uploading: " + (timeEnd-timeStart) + "sec.");
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
