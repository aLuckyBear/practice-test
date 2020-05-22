package practice.sort;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：shujie
 * @date ：2019/12/05
 * @description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuf = ByteBuffer.allocate(1000);
        byteBuf.put((byte) 1);

        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        SelectionKey register = socketChannel.register(selector, SelectionKey.OP_READ);

        while (true) {
            int readyChannel = selector.select();
            if (readyChannel == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {

                } else if (key.isConnectable()) {

                } else if (key.isReadable()) {

                } else if (key.isWritable()) {

                }

                iterator.remove();
            }
        }

    }

}