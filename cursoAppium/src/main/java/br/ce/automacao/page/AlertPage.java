package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {
    public void clicarAlertConfimracao(){
        clicarPorTexto("ALERTA CONFIRM");
    }
    public String obterTextoAlertaConfirmado(){
        return obtertexto(By.xpath("//*[@text='Confirmado']"));
    }
    public void clicarEmConfirmacaoAlerta(){
        clicarPorTexto("CONFIRMAR");
    }
    public void clicarEmSairAlert(){
        clicarPorTexto("SAIR");
    }
    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }
    public void clicarForaCaixa(){
        tap(100,150);
    }
}
