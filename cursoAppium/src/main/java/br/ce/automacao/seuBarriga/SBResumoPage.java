package br.ce.automacao.seuBarriga;

import br.ce.automacao.core.BasePage;
import static br.ce.automacao.core.DriverFactory.getDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SBResumoPage extends BasePage {
    public void excluirMovimentacao(String desc){
        MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
        swipeElement(el, 0.9, 0.1);
        clicarPorTexto("Del");
    }
}
