package mybytstream1;

import java.io.*;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("E:\\插画\\9e976c37bfa807e2c409e69aafde4149525661848.png");
        FileOutputStream fos =  new FileOutputStream("E:\\临时\\copy.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
