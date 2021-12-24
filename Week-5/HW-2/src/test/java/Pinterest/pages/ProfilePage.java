package Pinterest.pages;

import Pinterest.utilities.Driver;
import Pinterest.utilities.Helper;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.net.MalformedURLException;

public class ProfilePage extends Helper {

    public ProfilePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.pinterest:id/profile_boards_tab_create_icon")
    public AndroidElement createBtn;

    @AndroidFindBy(xpath = "//*[@text='Board']")
    public AndroidElement elSelectBoard;

    @AndroidFindBy(id = "com.pinterest.board:id/board_name_edittext")
    public AndroidElement elBoardText;

    @AndroidFindBy(id = "com.pinterest.board:id/create_board_button_id")
    public AndroidElement boardNextBtn;

    @AndroidFindBy(id = "com.pinterest.board:id/done_button")
    public AndroidElement boardDoneBtn;

    @AndroidFindBy(id = "com.pinterest.board:id/board_title")
    public AndroidElement createdBoardTitle;

    public void clickCreateBtn() {
        clickElement(createBtn);
    }

    public void selectBoard() {
        waitForVisibilityOf(elSelectBoard);
        clickElement(elSelectBoard);
    }

    public void writeTheBoardName(String boardname) {
        waitForVisibilityOf(elBoardText);
        sendKeysElement(elBoardText, boardname);
        clickElement(boardNextBtn);
    }

    public void clickDoneBtn() {
        waitForVisibilityOf(boardDoneBtn);
        clickElement(boardDoneBtn);
    }

    public void verifyCreatedBoardName(String boardname) {
        Assert.assertEquals(createdBoardTitle.getText(), boardname);
    }

}