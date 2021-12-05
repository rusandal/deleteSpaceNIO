import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientNIO {
    public static int bufferSize = 256;
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 23444);
        SocketChannel socketChannel;
        try (Scanner scanner=new Scanner(System.in)){
            socketChannel = SocketChannel.open();
            socketChannel.connect(inetSocketAddress);
            final ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
            String msg;
            while (true){

                System.out.println("Начните вводить данные...");
                msg=scanner.nextLine();
                if(msg.equals("end")) break;
                socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
                int byteCount = socketChannel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array(), 0 ,byteCount, StandardCharsets.UTF_8).trim());
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
