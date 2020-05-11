package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {
    public boolean isAba1(){
        return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }
    public boolean isAba2(){
        return existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }
    public void clicarAba2(){
        clicarPorTexto("ABA 2");
    }
    public void clicarAba1(){
        clicarPorTexto("ABA 1");
    }
}
