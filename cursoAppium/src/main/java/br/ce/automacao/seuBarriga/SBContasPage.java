package br.ce.automacao.seuBarriga;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class SBContasPage extends BasePage {

    public void setarNomeConta(String nome){
        escrever(By.className("android.widget.EditText"), nome);
    }
    public void salvar(){
        clicarPorTexto("SALVAR");
    }
    public String getMensagem(){
        return obtertexto(By.xpath("//*[@text='Conta adicionada com sucesso']"));
    }
    public void excluir(){
        clicarPorTexto("EXCLUIR");
    }
    public void selecionarConta(String conta){
        cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }

}
