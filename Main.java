import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


public class Main {
    private static final File filee = new File("C:\\Users\\test\\IdeaProjects\\TPO\\src\\Myfile");

    private static String writeM="write";
    private static String readM="read";

    public static void main(String[] args)  {
        RandomAccessFile file = null;
try{
    file= new RandomAccessFile(filee, "rw");
}catch(FileNotFoundException e){
    e.printStackTrace();
}





        System.out.println("In process...");

        String mode2 = args[0];
        if(mode2.equals(writeM)){

            FirstApplication writer = new FirstApplication(file);
            writer.start();

        } else if(mode2.equals(readM)){

            SecondApplication reader = new SecondApplication(file);
            reader.start();

        }else{
            throw new IllegalArgumentException();
        }

    }
}
