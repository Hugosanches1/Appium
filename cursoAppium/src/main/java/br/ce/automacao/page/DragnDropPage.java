package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import static br.ce.automacao.core.DriverFactory.getDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;


import java.util.List;

public class DragnDropPage extends BasePage {

    public void arrastar(String origem, String destino){
        MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        new TouchAction(getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
                .moveTo(PointOption.point(fim.getCenter()))
                .release()
                .perform();
    }
    public String[] obterlista(){
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for(int i = 0; i < elements.size(); i ++){
            retorno[i] = elements.get(i).getText();
        }
        return retorno;
    }
}
