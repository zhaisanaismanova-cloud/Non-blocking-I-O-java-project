
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

import static java.lang.Thread.sleep;


public class SecondApplication {
    private static final int SleepTime = 1000;
    private static final Random random = new Random();
    private static final int BufferSize = 16;
    private static RandomAccessFile rfile;
    private static MappedByteBuffer buffer;

    public SecondApplication(RandomAccessFile file) {
this.rfile=file;}


public void start(){
        try {

            FileChannel channel = rfile.getChannel();
            buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BufferSize);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        while (true) {
buffer.rewind();
            if ( buffer!=null&&buffer.getInt() == 1) {

                int value1 = buffer.getInt();
                int value2 = buffer.getInt();
                int sum = value1 + value2;
                System.out.println("sum: " + sum);
                buffer.rewind();
                buffer.putInt(0);
            }
            buffer.rewind();

           try{
               Thread.sleep(SleepTime);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
    }
}
