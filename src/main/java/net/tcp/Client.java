package net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author dongwq
 * @date 2025/6/3
 **/
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8946);
        OutputStream outputStream = client.getOutputStream();

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeUTF("你好");

        dataOutputStream.close();

        client.close();
    }
}
