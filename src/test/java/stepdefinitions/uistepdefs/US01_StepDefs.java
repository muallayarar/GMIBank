package stepdefinitions.uistepdefs;

    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import utilities.Driver;

    public class US01_StepDefs {
        @Given("User clicks Register Button")
        public void user_clicks_register_button() {
            Driver.getDriver().get("https://www.google.com/");
            Driver.waitForPageToLoad(30);
        }
        @Then("User verifies Registration Page")
        public void userVerifiesRegistrationPage() {

        }
        @Given("User clicks SSN Box and clicks next box")
        public void user_clicks_ssn_box_and_clicks_next_box() {

        }
        @Given("User enters {int} digit SSN in the SSN Box without {string} and clicks next box")
        public void user_enters_digit_ssn_in_the_ssn_box_without_and_clicks_next_box(Integer int1, String string) {

        }
        @Then("User verifies system put {string} between digits automatically")
        public void user_verifies_system_put_between_digits_automatically(String string) {

        }
        @When("User enters {int} digit SSN in the SSN Box and clicks next box")
        public void user_enters_digit_ssn_in_the_ssn_box_and_clicks_next_box(Integer int1) {

        }
        @Then("User verifies {string} message is displayed under SSN Box")
        public void user_verifies_message_is_displayed_under_ssn_box(String string) {

        }
        @Then("User verifies system doesn't accept {int}. digit")
        public void user_verifies_system_doesn_t_accept_digit(Integer int1) {

        }
        @When("User enters only char in the SSN Box and clicks next box")
        public void user_enters_only_char_in_the_ssn_box_and_clicks_next_box() {

        }
        @Then("User verifies system doesn't accept any char")
        public void user_verifies_system_doesn_t_accept_any_char() {

        }
        @When("User enters only symbols in the SSN Box and clicks next box")
        public void user_enters_only_symbols_in_the_ssn_box_and_clicks_next_box() {

        }
        @Then("User verifies system doesn't accept any sepacial character")
        public void user_verifies_system_doesn_t_accept_any_sepacial_character() {

        }
        @When("User enters a valid SSN in the SSN Box and clicks next box")
        public void user_enters_a_valid_ssn_in_the_ssn_box_and_clicks_next_box() {

        }
        @Then("User verifies any error message is not displayed")
        public void user_verifies_any_error_message_is_not_displayed() {

        }

        @When("User enters only symbols in the First Name Box and clicks next box")
        public void user_enters_only_symbols_in_the_first_name_box_and_clicks_next_box() {

        }
        @Then("User clicks First Name Box and clicks next box")
        public void user_clicks_first_name_box_and_clicks_next_box() {

        }
        @Then("User clicks Last Name Box and clicks next box")
        public void user_clicks_last_name_box_and_clicks_next_box() {

        }
        @Then("User clicks Address Box and clicks next box")
        public void user_clicks_address_box_and_clicks_next_box() {

        }

        @Then("User verifies {string} message is displayed")
        public void user_verifies_message_is_displayed(String string) {

        }
        @When("User enters only digital numbers in First Name Box and clicks next box")
        public void user_enters_only_digital_numbers_in_first_name_box_and_clicks_next_box() {

        }
        @When("User enters chars with digital numbers and clicks next box")
        public void user_enters_chars_with_digital_numbers_and_clicks_next_box() {

        }
        @When("User enters a valid First Name in First Name Box and clicks next box")
        public void user_enters_a_valid_first_name_in_first_name_box_and_clicks_next_box() {

        }

        @When("User enters only symbols in the Last Name Box and clicks next box")
        public void user_enters_only_symbols_in_the_last_name_box_and_clicks_next_box() {

        }

        @When("User enters only digital numbers in Last Name Box and clicks next box.")
        public void user_enters_only_digital_numbers_in_last_name_box_and_clicks_next_box() {

        }
        @When("User enters a valid Last Name in Last Name Box and clicks next box")
        public void user_enters_a_valid_last_name_in_last_name_box_and_clicks_next_box() {

        }

        @When("User enters only symbols in the Address Box and clicks next box")
        public void user_enters_only_symbols_in_the_address_box_and_clicks_next_box() {

        }
        @When("User enters a valid Address in Address Box and clicks next box")
        public void user_enters_a_valid_address_in_address_box_and_clicks_next_box() {

        }
        @When("User clicks Mobilephone Number Box and clicks next box")
        public void user_clicks_mobilephone_number_box_and_clicks_next_box() {

        }
        @When("User enters {int} digit Mobilephone Number without {string} in the Mobilephone Number Box and clicks next box")
        public void user_enters_digit_mobilephone_number_without_in_the_mobilephone_number_box_and_clicks_next_box(Integer int1, String string) {

        }
        @When("User enters {int} digit Mobilephone Number in the Mobilephone Number Box and clicks next box")
        public void user_enters_digit_mobilephone_number_in_the_mobilephone_number_box_and_clicks_next_box(Integer int1) {

        }
        @Then("User verifies {string} message is displayed under Mobilephone Number Box")
        public void user_verifies_message_is_displayed_under_mobilephone_number_box(String string) {

        }
        @Then("User verifies system doesn't accept {int}. digit Mobilephone Number")
        public void user_verifies_system_doesn_t_accept_digit_mobilephone_number(Integer int1) {

        }
        @When("User enters only char in the  Mobilephone Number Box and clicks next box")
        public void user_enters_only_char_in_the_mobilephone_number_box_and_clicks_next_box() {

        }
        @Then("User verifies system doesn't accept any char in the Mobilephone Number Box")
        public void user_verifies_system_doesn_t_accept_any_char_in_the_mobilephone_number_box() {

        }
        @When("User enters only symbols in the Mobilephone Number Box and clicks next box")
        public void user_enters_only_symbols_in_the_mobilephone_number_box_and_clicks_next_box() {

        }
        @Then("User verifies system doesn't accept any sepacial character in the Mobilephone Number Box")
        public void user_verifies_system_doesn_t_accept_any_sepacial_character_in_the_mobilephone_number_box() {

        }
        @When("User enters a valid Mobilephone Number in the Mobilephone Number Box and clicks next box")
        public void user_enters_a_valid_mobilephone_number_in_the_mobilephone_number_box_and_clicks_next_box() {

        }
        @Then("User verifies error message is not displayed")
        public void user_verifies_error_message_is_not_displayed() {

        }
        @When("User clicks Email Box and clicks next box")
        public void user_clicks_email_box_and_clicks_next_box() {

        }
        @When("User enters an email without -@- and -.com- and clicks next box")
        public void user_enters_an_email_without_and_and_clicks_next_box() {

        }
        @When("User enters an email without -@- but with -.com- and clicks next box")
        public void user_enters_an_email_without_but_with_and_clicks_next_box(String string, String string2) {

        }
        @When("User enters an email without -.com- but -@- and clicks next box")
        public void user_enters_an_email_without_but_and_clicks_next_box(String string, String string2) {

        }
        @When("User enters a valid email in the email box and clicks next box")
        public void user_enters_a_valid_email_in_the_email_box_and_clicks_next_box() {

        }


}
