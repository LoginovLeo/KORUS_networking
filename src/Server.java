import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static String protocol = "TCP";
    private final static int UDP_SERVICE_PORT = 50001;
    private final static int TCP_SERVICE_PORT = 3345;
    private final static String DOWNLOAD_PATH = "C:\\Users\\Leonid\\Downloads\\1GB.zip";


    public static void main(String[] args) throws IOException {

        //DatagramSocket udpServer = new DatagramSocket(UDP_SERVICE_PORT);
        //DatagramPacket inputPacket;

        byte[] udpReceivingDataBuffer = new byte[1024];
        byte[] udpSendingDataBuffer = new byte[1024];




        if (protocol.equals("TCP")) {
            try {
               ServerSocket tcpServer = new ServerSocket(TCP_SERVICE_PORT);
                System.out.println("TCP sever waiting connection");
                while (true) {
                    Socket tcpClient = tcpServer.accept();
                    System.out.println("New connection" + tcpClient.getInetAddress());
                    InputStream inputStream = tcpClient.getInputStream();
                    FileOutputStream receivingFile = new FileOutputStream(DOWNLOAD_PATH);
                    long bytesSend = CopyUtil.copy(inputStream,receivingFile);

                /*byte[] buf = new byte[2048];
                int bytesRead = 0;
                int totalBytes = 0;
                while ((bytesRead = inputStream.read(buf)) != -1) {
                    totalBytes += bytesRead;
                    receivingFile.write(buf, 0, bytesRead);
                }*/
                System.out.println("Download finish, total " + bytesSend/1000 + " kb");
                System.out.println("Waiting new connection");

            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (protocol.equals("UDP")) {
            //inputPacket = new DatagramPacket(udpReceivingDataBuffer, udpSendingDataBuffer.length);
            System.out.println("UDP server waiting connection");
            //udpServer.receive(inputPacket);


        } else
            System.out.println("Protocol must be TCP or UDP");
    }
}
