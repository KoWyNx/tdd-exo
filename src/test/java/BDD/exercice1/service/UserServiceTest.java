package BDD.exercice1.service;

import static org.junit.jupiter.api.Assertions.*;

import BDD.exercice1.User;
import BDD.exercice1.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserServiceTest {

    private UserService userService;

    private User user;
    private boolean creationResult;
    private User foundUser;

    @Given("a user with the email {string}, username {string}, and password {string}")
    public void a_user_with_details(String email, String username, String password) {
        user = new User(email, username, password);
        userService = new UserService();
    }

    @Given("the account already exists")
    public void the_account_already_exists() {
        userService.createUser(user); // Crée l'utilisateur une première fois
    }

    @When("the user tries to create an account")
    public void the_user_tries_to_create_an_account() {
        creationResult = userService.createUser(user);
    }

    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
        assertTrue(creationResult, "L'utilisateur devrait être créé avec succès.");
    }

    @Then("the account creation should fail")
    public void the_account_creation_should_fail() {
        assertFalse(creationResult, "La création d'un utilisateur avec un nom d'utilisateur existant devrait échouer.");
    }

    @Then("the user should be able to find the account by the username {string}")
    public void the_user_should_be_able_to_find_the_account(String username) {
        foundUser = userService.findUserByUsername(username);
        assertNotNull(foundUser, "L'utilisateur devrait être trouvable après la création.");
    }

    @Given("a user with the username {string} and password {string}")
    public void a_user_with_username_and_password(String username, String password) {
        user = new User("dummy@test.com", username, password);
    }

    @Given("the account exists in the system")
    public void the_account_exists_in_the_system() {
        userService.createUser(user);
    }

    @When("the user tries to log in with the correct credentials")
    public void the_user_tries_to_log_in_with_correct_credentials() {
        foundUser = userService.findUserByUsername(user.getUsername());
        assertEquals(user.getPassword(), foundUser.getPassword(), "Le mot de passe devrait correspondre.");
    }

    @When("the user tries to log in with the wrong password")
    public void the_user_tries_to_log_in_with_wrong_password() {
        foundUser = userService.findUserByUsername(user.getUsername());
        assertNotEquals(user.getPassword(), foundUser.getPassword(), "Le mot de passe ne devrait pas correspondre.");
    }

    @Then("the login should be successful")
    public void the_login_should_be_successful() {
        assertEquals(user.getPassword(), foundUser.getPassword(), "Connexion réussie.");
    }

    @Then("the login should fail")
    public void the_login_should_fail() {
        assertNotEquals(user.getPassword(), foundUser.getPassword(), "La connexion devrait échouer avec un mauvais mot de passe.");
    }
}
