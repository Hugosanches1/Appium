package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {
    public void clicarOpcao1(){
        clicarPorTexto("Opção 1");
    }
    public String obterTextoOpcao1(){
        return obtertexto(By.xpath("//*[@text = 'Esta é a descrição da opção 1']"));
    }
}
