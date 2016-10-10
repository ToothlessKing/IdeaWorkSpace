package file;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Administrator on 2016-09-28.
 */

public class BufferefReaderTest {
        public static void main(String[] args) {
            FileReader reader = null ;
            BufferedReader bufferedReader = null;
            try{
                reader = new FileReader("E://hh.txt");
                bufferedReader =new BufferedReader(reader);
                String line = null;
                while ((line=bufferedReader.readLine())!=null){
                    System.out.println(line);

                }
                bufferedReader.close();
                reader.close();
            }catch (Exception e){

            }
        }
}

