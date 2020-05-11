package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import static br.ce.automacao.core.DriverFactory.getDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb(){
        getDriver().context((String) getDriver().getContextHandles().toArray()[1]);
    }

    public void sairContextoWeb(){
        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }

    public void setarEmail(String email){
        escrever(By.id("email"),email);
    }
    public void setarSenha(String senha){
        escrever(By.id("senha"),senha);
    }
    public void clicarEntrar(){
        clicar(By.xpath("//button[.='Entrar']"));
    }
    public String getMensagem(){
        return obtertexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
