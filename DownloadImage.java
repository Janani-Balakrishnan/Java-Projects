import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadImage {
	
    public static void main(String[] args) {
		BufferedImage image;
		int width;
		int height;
        String imageUrl = "http://via.placeholder.com/350x150";
        String destinationFilePath = "C://users/Janani Balakrishnan/test1.jpg"; 

        InputStream inputStream = null;
        try {
            inputStream = new URL(imageUrl).openStream();
            Files.copy(inputStream, Paths.get(destinationFilePath));
        } catch (IOException e) {
            System.out.println("Exception Occurred " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
		File file =new File("c:\\Users\\Janani Balakrishnan\\test1.jpg");
		
		if(file.exists()){
			
			double bytes = file.length();
			double kilobytes = (bytes / 1024);
			System.out.println("File Size in Bytes : " + bytes);
			System.out.println("File Size in Kilobytes : " + kilobytes);
		}
		try{
			image = ImageIO.read(file);
			width = image.getWidth();
			height = image.getHeight();
			System.out.println("Width : " + width);
			System.out.println("Height : " + height);
		}catch (Exception e) {}
    }
}