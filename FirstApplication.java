
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;



public class FirstApplication {
    private static final int SleepTime = 1000;
    private static final Random random = new Random();
    private static final int BufferSize = 16;
    private static MappedByteBuffer buffer;
    private static RandomAccessFile rfile;

    public FirstApplication(RandomAccessFile file) {
        this.rfile = file;

    }

    public  void start(){
        try {
            FileChannel channel = rfile.getChannel();
            buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BufferSize);

        } catch (IOException e) {
            e.printStackTrace();
        }



        while (true) {
         buffer.rewind();
            if (buffer.getInt() == 0) {
                int value1 = random.nextInt();
                    int value2 = random.nextInt();
                    buffer.putInt(value1);
                    buffer.putInt(value2);
                buffer.rewind();
                buffer.putInt(1);
                }
buffer.rewind();
            try{
                Thread.sleep(SleepTime);
            }catch(InterruptedException e){
                e.printStackTrace();
            }


            }


        }
    }
