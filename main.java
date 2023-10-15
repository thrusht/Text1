package cn.edu.swu.jsp;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
            new Addressget().Addressget();//先获取存储图片地址的文档
            List<String> urls = new ArrayList<>();//将图片网址存入一个集合中
            for (int i = 0; i < 5; i++) {
                urls.add(new URLget().urlget(i));
            }
            List<String> imgName = new ArrayList<>();//提取文件名字
            for (int i = 0; i < 5; i++) {
                String fname= urls.get(i);//根据/分割读取
                System.out.println(fname);
                String[] net = fname.split("/");
                String rename1 = "C:/images/" + net[2] + "/"+ net[3]+ "/"+ net[4]+ "/";//命名存储地址
                System.out.println(rename1);
                imgName.add(rename1);
            }
            List<Integer> size = new ArrayList<>();//存储文件大小
            List<String> img = new ArrayList<>();//存储文件名字
            for (int i = 0; i < 5; i++) {
                File filename = new File(imgName.get(i));
                filename.mkdirs();//创建保存文件夹
                System.out.println(filename.exists());
                URL url = new URL(urls.get(i));
                String savename = imgName.get(i) + "01.jpg";
                InputStream inputStream = url.openStream();//创建文件
                OutputStream outputStream = new FileOutputStream(savename);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                File Picture = new File(savename);
                size.add((int) Picture.length());
                img.add(savename);
                outputStream.close();
                inputStream.close();
            }
            int[] compare = new int[]{0, 1, 2, 3, 4};//文件排序
            int temp;
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (size.get(i) < size.get(j)) {
                        temp = compare[i];
                        compare[i] = compare[j];
                        compare[j] = temp;
                    }
                }
            }
            FileWriter sort = new FileWriter("C:/images/images-sorted.txt");//打印排序后的文件
            for (int i = 0; i < 5; i++) {
                sort.write(size.get(compare[i])+"");
                sort.write("     ");
                sort.write(img.get(compare[i]));
                sort.write("\n");
            }
            sort.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
