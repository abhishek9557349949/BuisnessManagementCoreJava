package testing;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

import constants.BMSConstants;
import dao.UserSession;
import service.UserSessionServices;

class UserSessionServicesTest {

    @Test
    void testSessionservices_Login() {
        try {
            // Simulate user input for login
            String input = BMSConstants.LoginPage.LOGIN.getId();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Perform the test
            boolean result = UserSessionServices.Sessionservices(BMSConstants.LoginPage.LOGIN.getKey());

            // Assertions
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    void testSessionservices_Signup_Success() {
        try {
            // Simulate user input for signup
            String input = BMSConstants.LoginPage.SIGNUP.getId();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Mock the signUp method to return true
            UserSession.setSignUp(true);

            // Perform the test
            boolean result = UserSessionServices.Sessionservices(BMSConstants.LoginPage.SIGNUP.getKey());

            // Assertions
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    void testSessionservices_Signup_Failure() {
        try {
            // Simulate user input for signup
            String input = BMSConstants.LoginPage.SIGNUP.getId();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // Mock the signUp method to return false
            UserSession.setSignUp(false);

            // Perform the test
            boolean result = UserSessionServices.Sessionservices(BMSConstants.LoginPage.SIGNUP.getKey());

            // Assertions
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    // Add more test cases for other scenarios as needed

    // Reset System.in after each test
    @After
    void restoreSystemInputOutput() {
        System.setIn(System.in);
    }
}
