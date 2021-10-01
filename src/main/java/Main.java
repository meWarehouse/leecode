

//1 2 1 2 输入数据
//2 聚拢数据


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //    public static void main(String[] args) throws Exception {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(reader.readLine());
//
//        String[] splits = reader.readLine().split(" ");
//
//        int k = Integer.parseInt(reader.readLine());
//
//
//
//
//
//
//    }
    public static void main(String[] args) throws IOException {

//        FileInputStream inputStream = new FileInputStream(new File("D:\\workspace\\workspace2021\\python\\py-test\\爬虫\\animal_images\\dog"));
//
//        int read = inputStream.read();
//        System.out.println(read);

        File file = new File("D:\\workspace\\workspace2021\\python\\py-test\\论文\\data\\animals2\\test");
        String dirPath = file.getAbsolutePath();
        File[] files = file.listFiles();

        int index = 0;
        for (File f : files) {


            BufferedImage imageMsg = ImageIO.read(f);

            int pixelSize = imageMsg.getColorModel().getPixelSize();
            String fileName = f.getName();

//            if(pixelSize < 24){
//                System.out.println(fileName);
//            }





            String substring = fileName.substring(fileName.indexOf("."));

//            Math.round(500)
//            String newName = (int)(Math.random() * 500000) + substring;
            String newName = (index++) + substring;

            File fds = new File("D:\\workspace\\workspace2021\\python\\py-test\\论文\\data\\animals2\\sheep" + "/" + newName);

            f.renameTo(fds);

            System.out.println(fds.getName());


        }


    }

}
