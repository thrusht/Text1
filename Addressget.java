package cn.edu.swu.jsp;
import java.io.*;
import java.net.URL;
public class Addressget //获取网上的文档
{
    public void Addressget()
    {
        try {
            URL url1 = new URL("http://10.122.7.154/javaweb/data/images-url.txt");
            File f1 = new File("text1.txt");
            InputStream is = url1.openStream();
            OutputStream os = new FileOutputStream(f1);
            byte[] buffer =new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1)
            {
                os.write(buffer,0,len);
            }
            is.close();
            os.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
