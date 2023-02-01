package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class US01_StepDefs {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker=new Faker();
    SoftAssert softAssert=new SoftAssert();
    String firstName;
    String lastName;
    String address;
    String phone;
    String userName;
    String email;





    @Given("User goes to Url")
    public void userGoesToUrl() {
        Driver.getDriver().get("https://www.gmibank.com/");
    }

    @Given("User clicks Register Button")
    public void user_clicks_register_button() {
        registrationPage.accountIcon.click();
        registrationPage.registerButton.click();
        //Driver.wait(3);
    }

    @Then("User verifies Registration Page")
    public void userVerifiesRegistrationPage() {
        Assert.assertTrue("Registration", registrationPage.registrationPageTitle.isDisplayed());
    }

    @Given("User clicks SSN Box and clicks next box")
    public void user_clicks_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.click();
        registrationPage.firstNameBox.click();
        Driver.wait(3);
    }

    @Then("User verifies {string} message is displayed")
    public void user_verifies_message_is_displayed(String message) {
        Assert.assertEquals(message, registrationPage.ssnBoxEmptyAlertText.getText());
        ReusableMethods.waitFor(3);
    }

    @Given("User enters {int} digit SSN in the SSN Box without {string} and clicks next box")
    public void user_enters_digit_ssn_in_the_ssn_box_without_and_clicks_next_box(Integer int1, String string) {
        registrationPage.ssnBox.click();
        registrationPage.ssnBox.sendKeys("123456789");
        //Driver.wait(3);
    }

    @Then("User verifies system put {string} between digits automatically")
    public void user_verifies_system_put_between_digits_automatically(String string) {
        String ssnId = registrationPage.ssnBox.getAttribute("value");
        Assert.assertEquals("123-45-6789", ssnId);
        //Driver.wait(3);
    }

    @When("User enters {int} digit SSN in the SSN Box and clicks next box")
    public void user_enters_digit_ssn_in_the_ssn_box_and_clicks_next_box(Integer int1) {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("12345678");
        registrationPage.firstNameBox.click();

    }

    @Then("User verifies {string} message is displayed under SSN Box")
    public void user_verifies_message_is_displayed_under_ssn_box(String string) {
        Assert.assertTrue(registrationPage.ssnInvalidAlertText.isDisplayed());
    }

    @When("User enters on digit SSN in the SSN Box and clicks next box")
    public void userEntersOnDigitSSNInTheSSNBoxAndClicksNextBox() {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("1234567890");
        registrationPage.firstNameBox.click();
    }

    @Then("User verifies system doesn't accept {int}. digit")
    public void user_verifies_system_doesn_t_accept_digit(Integer int1) {
        String ssnId = registrationPage.ssnBox.getAttribute("value");
        ssnId = ssnId.replace("-", "");
        System.out.println("ssnId Length:" + ssnId.length());
        Assert.assertEquals(9, ssnId.length());
        //Driver.wait(3);

    }

    @When("User enters only char in the SSN Box and clicks next box")
    public void user_enters_only_char_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("aaaaaaaaa");
        registrationPage.ssnBox.click();
    }

    @Then("User verifies system doesn't accept any char")
    public void user_verifies_system_doesn_t_accept_any_char() {
        Driver.wait(3);
        Assert.assertTrue(registrationPage.ssnBox.getAttribute("value").equals("a"));
    }

    @When("User enters only symbols in the SSN Box and clicks next box")
    public void user_enters_only_symbols_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        Driver.wait(3);
        registrationPage.ssnBox.sendKeys(".*??????!");
        registrationPage.ssnBox.click();
    }

    @Then("User verifies system doesn't accept any sepacial character")
    public void user_verifies_system_doesn_t_accept_any_sepacial_character() {
       // Assert.assertTrue(registrationPage.ssnBox.getAttribute("value").isEmpty());
    }

    @When("User enters a valid SSN in the SSN Box and clicks next box")
    public void user_enters_a_valid_ssn_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        Driver.wait(3);
        registrationPage.ssnBox.sendKeys("345-67-6788");
       registrationPage.firstNameBox.click();
    }

    @When("User enters valid SSN in the SSN Box and clicks next box")
    public void user_enters_valid_ssn_in_the_ssn_box_and_clicks_next_box(io.cucumber.datatable.DataTable credentials) {
        List<Map<String, String>> customerCredentials = credentials.asMaps(String.class, String.class);

        for (Map<String, String> each : customerCredentials) {
            registrationPage.ssnBox.clear();
            registrationPage.ssnBox.sendKeys(each.get("valid SSN"));
            registrationPage.firstNameBox.click();
        }
    }

    @When("User enters invalid SSN in the SSN Box and clicks next box")
    public void user_enters_invalid_ssn_in_the_ssn_box_and_clicks_next_box(io.cucumber.datatable.DataTable credentials) {
        List<Map<String, String>> customerCredentials = credentials.asMaps(String.class, String.class);

        for (Map<String, String> each : customerCredentials) {
            registrationPage.ssnBox.clear();
            registrationPage.ssnBox.sendKeys(each.get("Invalid SSN"));
            Assert.assertTrue(registrationPage.ssnInvalidAlertText.getText().contains("invalid"));
            registrationPage.firstNameBox.click();
        }
    }


    @Then("User verifies any error message is not displayed")
    public void user_verifies_any_error_message_is_not_displayed() {
        softAssert.assertEquals(firstName, registrationPage.firstNameBox.getAttribute("value"));
        softAssert.assertAll();

    }

    @When("User enters only symbols in the First Name Box and clicks next box")
    public void user_enters_only_symbols_in_the_first_name_box_and_clicks_next_box() {
        firstName ="*";
        registrationPage.firstNameBox.sendKeys(firstName);
        registrationPage.lastNameBox.click();
    }

    @Then("User verifies {string} message is displayed invalid FirstName")
    public void userVerifiesMessageIsDisplayedInvalidFirstName(String message) {
       softAssert.assertNotEquals(registrationPage.firstNameBox.getAttribute("value"), firstName);
       softAssert.assertAll();

    }

    @Then("User clicks First Name Box and clicks next box")
    public void user_clicks_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.click();
        registrationPage.lastNameBox.click();
    }

    @Then("User verifies {string} message is displayed in firstName")
    public void user_verifies_message_is_displayed_in_first_name(String message) {
        Assert.assertEquals(message,registrationPage.firstNameBoxEmptyAlertText.getText());
    }

    @Then("User clicks Last Name Box and clicks next box")
    public void user_clicks_last_name_box_and_clicks_next_box() {
        registrationPage.lastNameBox.click();
        registrationPage.emailBox.click();

    }

    @Then("User verifies {string} message is displayed Last name box")
    public void userVerifiesMessageIsDisplayedLastNameBox(String message) {
        Assert.assertEquals(message, registrationPage.lastNameBoxEmptyAlertText.getText());
    }

    @Then("User verifies {string} message is displayed in lastName box")
    public void userVerifiesMessageIsDisplayedInLastNameBox(String message) {
        Assert.assertEquals(lastName,registrationPage.lastNameBox.getAttribute("value"));

    }

    @Then("User clicks Address Box and clicks next box")
    public void user_clicks_address_box_and_clicks_next_box() {
        registrationPage.addressBox.click();
        registrationPage.mobilePhoneBox.click();
    }

    @Then("User verifies {string} message is displayed in address box")
    public void userVerifiesMessageIsDisplayedInAddressBox(String message) {
        Assert.assertEquals(message, registrationPage.addressBoxEmptyAlertText.getText());
    }

    @When("User enters only digital numbers in First Name Box and clicks next box")
    public void user_enters_only_digital_numbers_in_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.clear();
        firstName ="1234";
        registrationPage.firstNameBox.sendKeys(firstName);
        registrationPage.lastNameBox.click();


    }

    @When("User enters chars with digital numbers and clicks next box")
    public void user_enters_chars_with_digital_numbers_and_clicks_next_box() {
        registrationPage.firstNameBox.clear();
        firstName ="12Ali";
        registrationPage.firstNameBox.sendKeys(firstName);
        registrationPage.lastNameBox.click();
    }

    @When("User enters a valid First Name in First Name Box and clicks next box")
    public void user_enters_a_valid_first_name_in_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.clear();
        firstName ="Mualla";
        registrationPage.firstNameBox.sendKeys(firstName);
        registrationPage.lastNameBox.click();
    }

    @When("User enters only symbols in the Last Name Box and clicks next box")
    public void user_enters_only_symbols_in_the_last_name_box_and_clicks_next_box() {
        registrationPage.lastNameBox.clear();
        lastName="?";
        registrationPage.lastNameBox.sendKeys(lastName);
        registrationPage.emailBox.click();

    }

    @When("User enters only digital numbers in Last Name Box and clicks next box.")
    public void user_enters_only_digital_numbers_in_last_name_box_and_clicks_next_box() {
        registrationPage.lastNameBox.clear();
        lastName="12345";
        registrationPage.lastNameBox.sendKeys(lastName);
        registrationPage.emailBox.click();
    }
    @When("User enters chars with digital numbers and clicks next box last name")
    public void userEntersCharsWithDigitalNumbersAndClicksNextBoxLastName() {
        registrationPage.lastNameBox.clear();
        lastName="12Ali";
        registrationPage.lastNameBox.sendKeys(lastName);
        registrationPage.emailBox.click();

    }

    @When("User enters a valid Last Name in Last Name Box and clicks next box")
    public void user_enters_a_valid_last_name_in_last_name_box_and_clicks_next_box() {
        registrationPage.lastNameBox.clear();
        lastName="YARAR";
        registrationPage.lastNameBox.sendKeys(lastName);
        registrationPage.emailBox.click();
    }

    @Then("User verifies any error message is not displayed last name")
    public void userVerifiesAnyErrorMessageIsNotDisplayedLastName() {
        Assert.assertEquals(lastName, registrationPage.lastNameBox.getAttribute("value"));

    }
    @When("User enters only symbols in the Address Box and clicks next box")
    public void user_enters_only_symbols_in_the_address_box_and_clicks_next_box() {
        registrationPage.addressBox.clear();
        address="!'?=%&";
        registrationPage.addressBox.sendKeys(address);
        registrationPage.mobilePhoneBox.click();
    }

    @Then("User verifies {string} message is displayed addressBox")
    public void userVerifiesMessageIsDisplayedAddressBox(String message) {
        Assert.assertEquals(address,registrationPage.addressBox.getAttribute("value"));
    }


    @When("User enters a valid Address in Address Box and clicks next box")
    public void user_enters_a_valid_address_in_address_box_and_clicks_next_box() {
       registrationPage.addressBox.clear();
       address="Kızıltoprak mah. 786.sokak. no:13/4 Antalya";
       registrationPage.addressBox.sendKeys(address);
       registrationPage.mobilePhoneBox.click();
    }

    @Then("User verifies any error message is not displayed addressBox")
    public void userVerifiesAnyErrorMessageIsNotDisplayedAddressBox() {
        Assert.assertEquals(address, registrationPage.addressBox.getAttribute("value"));
    }

    @When("User clicks Mobilephone Number Box and clicks next box")
    public void user_clicks_mobilephone_number_box_and_clicks_next_box() {
        registrationPage.mobilePhoneBox.click();
        registrationPage.emailBox.click();
    }
    @And("User verifies {string} message is displayed phoneNumber")
    public void userVerifiesMessageIsDisplayedPhoneNumber(String message) {
        Assert.assertEquals(message,registrationPage.mobilePhoneEmptyAlertText.getText());
    }

    @When("User enters {int} digit Mobilephone Number without {string} in the Mobilephone Number Box and clicks next box")
    public void user_enters_digit_mobilephone_number_without_in_the_mobilephone_number_box_and_clicks_next_box(Integer int1, String string) {
        registrationPage.mobilePhoneBox.clear();
        phone="5568976543";
        registrationPage.mobilePhoneBox.sendKeys(phone);
    }

    @Then("User verifies system put {string} between digits automatically in phonebox")
    public void userVerifiesSystemPutBetweenDigitsAutomaticallyInPhonebox(String phone) {
        Assert.assertEquals("556-897-6543",registrationPage.mobilePhoneBox.getAttribute("value"));

    }
    @When("User enters {int} digit Mobilephone Number in the Mobilephone Number Box and clicks next box")
    public void user_enters_digit_mobilephone_number_in_the_mobilephone_number_box_and_clicks_next_box(Integer int1) {
        registrationPage.mobilePhoneBox.clear();
        phone="556897654";
        registrationPage.mobilePhoneBox.sendKeys(phone);
    }

    @Then("User verifies {string} message is displayed under Mobilephone Number Box")
    public void user_verifies_message_is_displayed_under_mobilephone_number_box(String string) {
      Assert.assertTrue(registrationPage.mobilePhoneNumberInvalidAlertText.isDisplayed());
    }

    @When("User enters {int} digit Mobilephone Number in the Mobilephone Number Box and clicks next boxx")
    public void userEntersDigitMobilephoneNumberInTheMobilephoneNumberBoxAndClicksNextBoxx(int arg0) {
        registrationPage.mobilePhoneBox.clear();
        phone="55689765498";
        registrationPage.mobilePhoneBox.sendKeys(phone);

    }
    @Then("User verifies system doesn't accept {int}. digit Mobilephone Number")
    public void user_verifies_system_doesn_t_accept_digit_mobilephone_number(Integer int1) {
        Assert.assertNotEquals(phone,registrationPage.mobilePhoneBox.getAttribute("value"));
    }

    @When("User enters only char in the  Mobilephone Number Box and clicks next box")
    public void user_enters_only_char_in_the_mobilephone_number_box_and_clicks_next_box() {
        registrationPage.mobilePhoneBox.clear();
        phone="Ahmet";
        registrationPage.mobilePhoneBox.sendKeys(phone);
        registrationPage.emailBox.click();
    }

    @Then("User verifies system doesn't accept any char in the Mobilephone Number Box")
    public void user_verifies_system_doesn_t_accept_any_char_in_the_mobilephone_number_box() {
        Assert.assertTrue(registrationPage.mobilePhoneBox.getText().isEmpty());
    }

    @When("User enters only symbols in the Mobilephone Number Box and clicks next box")
    public void user_enters_only_symbols_in_the_mobilephone_number_box_and_clicks_next_box() {
        registrationPage.mobilePhoneBox.clear();
        phone="?=/";
        registrationPage.mobilePhoneBox.sendKeys(phone);
        registrationPage.emailBox.click();
    }

    @Then("User verifies system doesn't accept any sepacial character in the Mobilephone Number Box")
    public void user_verifies_system_doesn_t_accept_any_sepacial_character_in_the_mobilephone_number_box() {
        Assert.assertTrue(registrationPage.mobilePhoneBox.getText().isEmpty());
    }

    @When("User enters a valid Mobilephone Number in the Mobilephone Number Box and clicks next box")
    public void user_enters_a_valid_mobilephone_number_in_the_mobilephone_number_box_and_clicks_next_box() {
        registrationPage.mobilePhoneBox.clear();
        phone="553-467-8965";
        registrationPage.mobilePhoneBox.sendKeys(phone);
        registrationPage.emailBox.click();
    }

    @Then("User verifies error message is not displayed")
    public void user_verifies_error_message_is_not_displayed() {
        try {
            Assert.assertFalse(registrationPage.mobilePhoneNumberInvalidAlertText.isDisplayed());
        }catch (Exception e){
            System.out.println("Error message is not displayed");
        }

    }

    @When("User clicks Email Box and clicks next box")
    public void user_clicks_email_box_and_clicks_next_box() {
                registrationPage.emailBox.click();
                registrationPage.userNameBox.click();
    }
    @And("User verifies {string} message is displayed email")
    public void userVerifiesMessageIsDisplayedEmail(String message) {
        Assert.assertEquals(message, registrationPage.emailBoxEmptyAlertText.getText());
    }

    @When("User enters an email without @ and .com and clicks next box")
    public void user_enters_an_email_without_and_and_clicks_next_box() {
        registrationPage.emailBox.clear();
        email="muallayarar";
        registrationPage.emailBox.sendKeys(email);
        registrationPage.userNameBox.click();

    }

    @When("User enters an email without @ but with .com and clicks next box")
    public void user_enters_an_email_without_but_with_and_clicks_next_box() {
        registrationPage.emailBox.clear();
        email="muallayarar.com";
        registrationPage.emailBox.sendKeys(email);
        registrationPage.userNameBox.click();
    }

    @When("User enters an email without .com but @ and clicks next box")
    public void user_enters_an_email_without_but_and_clicks_next_box() {
        registrationPage.emailBox.clear();
        email="muallayarar@";
        registrationPage.emailBox.sendKeys(email);
        registrationPage.userNameBox.click();
    }
    @Then("User verifies {string} message is displayed in email")
    public void userVerifiesMessageIsDisplayedInEmail(String arg0) {
        Assert.assertTrue(registrationPage.emailInvalidAlertText.isDisplayed());
    }

    @When("User enters a valid email in the email box and clicks next box")
    public void user_enters_a_valid_email_in_the_email_box_and_clicks_next_box() {
        registrationPage.emailBox.clear();
        email="muallayarar@abc.com";
        registrationPage.emailBox.sendKeys(email);
        registrationPage.userNameBox.click();
    }

    @Then("User verifies error message is not displayed email box")
    public void userVerifiesErrorMessageIsNotDisplayedEmailBox() {
        try {
        Assert.assertFalse(registrationPage.emailInvalidAlertText.isDisplayed());
        }catch (Exception e){
            System.out.println("Error message is not displayed email box");
        }
    }
}
