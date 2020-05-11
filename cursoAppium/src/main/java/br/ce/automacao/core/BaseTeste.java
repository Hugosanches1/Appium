package br.ce.automacao.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.ce.automacao.core.DriverFactory.*;

public class BaseTeste {

    @Rule
    public TestName testName = new TestName();

    @AfterClass
    public static void finalizaClasse(){
        killdriver();
    }
    @After
    public void finaliza(){
        tirarScreenShot();
        getDriver().resetApp();
    }
    public void tirarScreenShot(){
        try {
            File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target" + File.separator +"screenshots" + File.separator + testName.getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
