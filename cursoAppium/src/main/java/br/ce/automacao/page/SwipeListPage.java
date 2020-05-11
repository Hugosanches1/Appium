package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import static br.ce.automacao.core.DriverFactory.getDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

public class SwipeListPage extends BasePage {
    public void swipeElementLeft(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9 );
    }
    public void swipeElementRigth(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1 );
    }
    public void clicarBotaoMais(){
       MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
       new TouchAction(getDriver())
               .tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, -50,0)))
               .perform();
    }
}
