package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Administrator on 2016-09-28.
 */
public class WriteToFilrExample {
    public static void main(String[] args) {
        try{
            String content = "abcdefghijklmnopqrstuvwxyz";
            File file = new File("E://hh.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            //可传入参数   true 表示追加文本
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // 另起一行
            bufferedWriter.newLine();
            bufferedWriter.write(content);

            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){

        }
    }
}
