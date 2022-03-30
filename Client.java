import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 23444);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 Scanner scanner = new Scanner(System.in)) {
                String msg;
                while (true) {
                    System.out.println("Введите текст для удаления пробелов");
                    msg = scanner.nextLine();
                    out.println(msg);
                    out.flush();
                    if(msg.equals("end")) break;
                    System.out.println("Server: "+in.readLine());
                }

            }

        } catch (IOException e) {

        }

    }
}
