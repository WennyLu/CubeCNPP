package cnpp.Framework;


import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * 包装的RemoteWebDriver，继承了RemoteWebDriver，重新findElements和findElement方法，实现元素查找时的日志记录
 */
public class WrappedRemoteWebDriver extends RemoteWebDriver {
	
	private Logger logger = LogManager.getLogger();
	
	public WrappedRemoteWebDriver(URL remoteAddress, Capabilities capabilities) {
		super(remoteAddress,capabilities);
	}
	
	@Override
	protected List<WebElement> findElements(String by, String using) {
		List<WebElement> elements = null;
		try {
			elements = super.findElements(by, using);
			logger.info("Through "+by+" method find "+using+" element, found "+elements.size()+"per");
		}catch(Exception e) {
			logger.error("Through "+by+" method find "+using+" failed, reason: "+e.getMessage());
		}
		return elements;
	}
	
	@Override
	protected WebElement findElement(String by, String using) {
		WebElement element = null;
		try {
			element = super.findElement(by, using);
			logger.info("Through "+by+" method find "+using+" element, found");
		}catch(Exception e) {
			logger.error("Through "+by+" method find "+using+" failed, reason: "+e.getMessage());
		}
		return element;
	}
	
	public void takeScreenShot(String filename) {
		File screenShot = ((TakesScreenshot)this).getScreenshotAs(OutputType.FILE);
		File directory = new File("screenshots");
		if(!directory.exists() || !directory.isDirectory()){
			logger.info("screenshots file is non-existent, create this file");
			directory.mkdir();
		}
		File file = new File(directory,filename);
		screenShot.renameTo(file);
		logger.info("Screensaver is successful, locate: "+file.getAbsolutePath());
	}
}
