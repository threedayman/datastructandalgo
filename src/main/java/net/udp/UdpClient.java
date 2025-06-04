package net.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author dongwq
 * @date 2025/5/30
 **/
public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();

        byte[] bytes = "hello world".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),9126);

        client.send(packet);
        System.out.println("data send success");
        client.close();
    }
}
