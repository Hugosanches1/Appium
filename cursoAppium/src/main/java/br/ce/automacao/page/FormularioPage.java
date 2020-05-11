package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome){
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }
    public String obterNome(){
        return obtertexto(MobileBy.AccessibilityId("nome"));
    }
    public void selecionarCombo(String valor){
        selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
    }
    public String obterValorCombo(){
        return obtertexto(By.xpath("//*[@text='Nintendo Switch']"));
    }
	public void clicarNoCheck(){
        clicar(By.className("android.widget.CheckBox"));
    }
    public void clicarNoSwitch(){
        clicar(MobileBy.AccessibilityId("switch"));
    }
    public boolean isCheckMarcado(){
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }
    public boolean idSwitchMarcado(){
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }
    public void salvar(){
        clicarPorTexto("SALVAR");
    }
    public void salvarDemorado(){
        clicarPorTexto("SALVAR DEMORADO");
    }
    public String obterNomeCadastrado(){
        return obtertexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }
    public String obterConsoleCadastrado(){
        return obtertexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }
    public String obterCheckCadastrado(){
        return obtertexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
    public String obterSwitchCadastrado(){
        return obtertexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }
    public void setarCalendario(){
        clicarPorTexto("01/01/2000");
        clicarPorTexto("20");
        clicarPorTexto("OK");
    }
    public void setarHora(){
        clicarPorTexto("06:00");
        clicar(MobileBy.AccessibilityId("19"));
        clicar(MobileBy.AccessibilityId("30"));
        clicar(By.id("android:id/button1"));
    }
    public void clicarSeekBar(double posicao){
        int delta = 40;
        MobileElement seek = retornaElemento("slid");
        int xinicial = seek.getLocation().x + delta;
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        int x = (int) ( xinicial + ((seek.getSize().width - 2 * delta) * posicao));

        tap(x, y);
    }
}
