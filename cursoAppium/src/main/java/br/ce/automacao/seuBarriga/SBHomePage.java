package br.ce.automacao.seuBarriga;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {
    public String obterSaldoConta(String conta){
       return obtertexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
    }
}
