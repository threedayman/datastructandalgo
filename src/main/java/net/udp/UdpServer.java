package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author dongwq
 * @date 2025/5/30
 **/
public class UdpServer {

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(9126);
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        server.receive(packet);
        String rs = new String(buffer,0,packet.getLength());
        System.out.println(rs);
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(packet.getPort());
        server.close();
    }
}
