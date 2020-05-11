package br.ce.automacao.seuBarriga;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {
    public void setarNome(String nome){
        escrever(By.xpath("//*[@text='Nome']"),nome);
    }

    public void setarSenha(String senha){
        escrever(By.xpath("//*[@text='Senha']"),senha);
    }

    public void entrar(){
        clicarPorTexto("ENTRAR");
    }

}
