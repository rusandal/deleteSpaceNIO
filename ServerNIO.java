import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ServerNIO {
    private static final int byteBufferSize = 256;
    public static void main(String[] args) {
        try {
            final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 23444));
            while (true){
                try(SocketChannel socketChannel = serverSocketChannel.accept()){
                    final ByteBuffer byteBuffer = ByteBuffer.allocate(byteBufferSize);
                    while (socketChannel.isConnected()){
                        int bytesCount = socketChannel.read(byteBuffer);
                        if(bytesCount == -1) break;
                        String msg = new String(byteBuffer.array(), 0 , bytesCount, StandardCharsets.UTF_8);
                        //System.out.println("Получено сообщение от клиента"+msg);
                        socketChannel.write(ByteBuffer.wrap(("Server: " + msg.replace(" ", "")).getBytes(StandardCharsets.UTF_8)));
                        byteBuffer.clear();
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
