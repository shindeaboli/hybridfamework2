package utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DriverManagement.DriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtils {

	public static String capture(String testCaseName) {

		TakesScreenshot ts = (TakesScreenshot) DriverManager.getInstance().getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);

		String destPath = System.getProperty("user.dir") + "//Screenshot//" + testCaseName + System.currentTimeMillis()
				+ ".png";

		try {
			FileUtils.copyFile(src, new File(destPath));
		} catch (Exception e) {
			e.getLocalizedMessage();
		}

		return destPath;
	}

	public static void fullPageScreenshot(String screenshotName) {
		AShot ashot = new AShot();

		ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));

		Screenshot screenshot = ashot.takeScreenshot(DriverManager.getInstance().getDriver());

		BufferedImage source = screenshot.getImage();

		File dest = new File(System.getProperty("user.dir") + "//screenshot//" + screenshotName
				+ System.currentTimeMillis() + ".png");

		try {
			ImageIO.write(source, "PNG", dest);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}

	}

}
