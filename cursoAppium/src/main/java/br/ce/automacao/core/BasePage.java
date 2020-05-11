package br.ce.automacao.core;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

//import java.time.Duration;
import java.time.Duration;
import java.util.List;

import static br.ce.automacao.core.DriverFactory.getDriver;

public class BasePage {
	public void escrever(By by, String texto){
		getDriver().findElement(by).sendKeys(texto);

	}
	public String obtertexto(By by){
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by){
		getDriver().findElement(by).click();

	}
	//Clicar e selecionar um opção do combo
	public void selecionarCombo(By by, String opcap){
		//clicar no combo
		getDriver().findElement(by).click();
		//selecionar opção do combo
		clicarPorTexto(opcap);
	}
	//clicar em algum elemento pelo texo
	public void clicarPorTexto(String texto){
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	public void cliqueLongo(By by){
		new TouchAction(getDriver()).longPress(PointOption.point(getDriver().findElement(by).getCenter())).perform();
	}
	public void clicarLongoPorTexto(String texto){
		cliqueLongo(By.xpath("//*[@text ='"+texto+"']"));
	}
	//verificar se está selecionado
	public boolean isCheckMarcado(By by){
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	public boolean existeElementoPorTexto(String texto){
		List<MobileElement> elm = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elm.size() > 0;
	}
	public String obterMensagemAlerta(){
		return obtertexto(By.id("android:id/message"));
	}
	public String obterTituloAlert(){
		return obtertexto(By.id("android:id/alertTitle"));
	}
	public void tap(int x, int y){
		new TouchAction(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
	}
	public MobileElement retornaElemento(String id){
		MobileElement elm = getDriver().findElement(MobileBy.AccessibilityId(id));
		return  elm;
	}
	public void scrolDown(){
		scroll(0.9,0.1);
	}
	public void scrowUp(){
		scroll(0.1,0.9);
	}
	public void swipeLeft(){
		swipe(0.1,0.9);
	}
	public void swipeRigth(){
		swipe(0.9,0.1);
	}

	public void scroll(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction(getDriver())
				.press(PointOption.point(new Point(x , start_y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(x, end_y)))
				.release()
				.perform();
	}
	public void swipe(double inicio, double fim){
		Dimension size = getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		new TouchAction(getDriver())
				.press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y)))
				.release()
				.perform();
	}
	public void swipeElement(MobileElement element, double inicio, double fim){
		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);

		new TouchAction(getDriver())
				.press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y)))
				.release()
				.perform();
	}
}
