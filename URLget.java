package cn.edu.swu.jsp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class URLget//将文档中的地址输出
         {
    public String urlget(int i)
    {
        String fileName = "text1.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            int c;
            int  j=1;
            String url = new String();
            while(j <= i) {
                if((char) (c = br.read()) == '\n')
                {
                    j++;
                }
            }
            while((char) (c = br.read()) != '\n') {
                url = url + (char)c;
            }
                return url;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
