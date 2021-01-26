package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ScreenShot {

    private static Driver d = Driver.getInstanceOfDriver();

    static void takeScreenshot() throws IOException {

        File srcFile = d.getScreenshot().getScreenshotAs(OutputType.FILE);
        String path = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //please change user in order to take screenshots in your PC
        File destFile = new File("C:\\Users\\U748235\\IdeaProjects\\ProjectSeleniumTestNG\\src\\test\\resources\\screenshots\\"+path+".png");
        FileUtils.copyFile(srcFile, destFile);

    }
}
