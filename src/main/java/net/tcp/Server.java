package net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dongwq
 * @date 2025/6/3
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8946);

        Socket accept = serverSocket.accept();

        InputStream is = accept.getInputStream();

        DataInputStream dataInputStream = new DataInputStream(is);

        String s = dataInputStream.readUTF();

        System.out.println(s);
        System.out.println(accept.getRemoteSocketAddress());

        dataInputStream.close();
        accept.close();
        serverSocket.close();
    }
}
