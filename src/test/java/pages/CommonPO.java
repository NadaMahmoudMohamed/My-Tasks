package pages;

import base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.net.MalformedURLException;

public class CommonPO extends PageObjectBase {
    public CommonPO() throws MalformedURLException {
        super();
    }

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@accessibilityLabel='DISPLAY']"),
            @FindBy(how = How.XPATH, using = "//*[@name='DISPLAY']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Display & Brightness' and @class='UIAStaticText']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Display']"),//*[@text='Display']
            @FindBy(how = How.XPATH, using = "//*[@text='Display & brightness']")//*[@text='Display']
    })//*[@text='Display']
    public WebElement displaymode;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Dark']"),
            @FindBy(how = How.XPATH, using = "//*[@name='DBSDeviceAppearanceOptionDark']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Dark mode']"),
            @FindBy(how = How.XPATH, using = "//*[@content-desc='Night mode']"),
            @FindBy(how = How.XPATH, using = "//*[@id='high_button_dot']"),
            @FindBy(how = How.XPATH, using = "//*[@contentDescription='Night mode']"),
            @FindBy(how = How.XPATH, using = "//*[@contentDescription='Dark theme']"),
            @FindBy(how = How.XPATH, using = "//*[@id='switchWidget']"),
            @FindBy(how = How.XPATH, using = "//*[@id='radio_button' and ./parent::*[@id='item2']]"),
            @FindBy(how = How.XPATH, using = "//*[@id='switch_widget' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[./*[@text='Dark mode']]]]]")

    })
    public WebElement darkmode;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/icon"),
            @FindBy(how = How.XPATH, using = "//*[@text='Advanced']")
    })
    public WebElement advancedOptions;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device theme']")
    })
    public WebElement deviceTheme;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Dark']")
    })
    public WebElement darkRadioBtn;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Settings']"),
            @FindBy(how = How.XPATH, using = " //*[@name='Settings']")
    })
    public WebElement devicesettings;
}
