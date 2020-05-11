package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import static br.ce.automacao.core.DriverFactory.getDriver;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpcaoEscondidaTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void deveInteragirOpcaoEscondida(){
        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        menuPage.scrolDown();

        //clicar menu
        menuPage.clicarPorTexto("Opção bem escondida");

        //verificar mensagem
        Assert.assertEquals("Você achou essa opção", menuPage.obterMensagemAlerta());

        //sair
        menuPage.clicarPorTexto("OK");

    }
}
