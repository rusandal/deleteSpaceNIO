import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(23444);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    System.out.println("Новое соединение установлено");
                    String line;
                    while((line = in.readLine())!=null){
                        System.out.println("пришло"+in.readLine());
                        if(line.equals("end")) break;
                        out.println("Ответ без пробелов: " + line.replace(" ", ""));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
