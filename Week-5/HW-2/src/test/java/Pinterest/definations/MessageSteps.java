package Pinterest.definations;

import Pinterest.pages.HomePage;
import Pinterest.pages.MessagePage;
import Pinterest.pages.NotificationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;


public class MessageSteps {

    HomePage homePage = new HomePage();
    NotificationPage notificationPage = new NotificationPage();
    MessagePage messagePage = new MessagePage();

    public MessageSteps() throws MalformedURLException {
    }

    @And("I click the notifications tab")
    public void iClickTheNotificationsTab() {
        homePage.clickNotificationTab();
    }

    @And("I click the Messages")
    public void iClickTheMessages() {
        notificationPage.clickMessagesTab();
    }

    @And("I search user for {string}")
    public void iSearchUserFor(String userName) {
        notificationPage.searchUser(userName);
    }

    @And("I select the searched user and press the next button")
    public void iSelectTheSearchedUserAndPressTheNextButton() {
        notificationPage.clickSearchUser();
    }

    @And("I type {string} in the message field")
    public void iTypeInTheMessageField(String message) {
        messagePage.sendMessagesBox(message);
    }

    @When("I click the send button")
    public void iClickTheSendButton() {
        messagePage.sendMessagesBtn();
    }

    @Then("I should see the message sent")
    public void iShouldSeeTheMessageSent() {
        messagePage.verifyMessage();
    }

    @And("I click the New message")
    public void iClickTheNewMessage() {
        messagePage.clickNewMsg();
    }
}
