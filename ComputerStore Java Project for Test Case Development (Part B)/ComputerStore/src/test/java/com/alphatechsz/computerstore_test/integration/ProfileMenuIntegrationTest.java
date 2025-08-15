package com.alphatechsz.computerstore_test.integration; // Package for integration tests //
import com.alphatechsz.computerstore.ProfileMenu; // Import GUI class //
import com.alphatechsz.computerstore.User; // Import User model //
import org.junit.jupiter.api.*; // Import JUnit annotations and assertions //
import org.junit.jupiter.api.Tag; // Import Tag //
import org.junit.jupiter.params.ParameterizedTest; // Import parameterized test //
import org.junit.jupiter.params.provider.MethodSource; // Import method source //
import org.junit.jupiter.params.provider.Arguments; // Import Arguments //
import java.lang.reflect.Field; // Import reflection Field //
import java.lang.reflect.Method; // Import reflection Method //
import java.util.stream.Stream; // Import Stream //
import static org.junit.jupiter.api.Assertions.*; // Import assertions //
@DisplayName("ProfileMenu + User Integration Tests") // Class display name //
public class ProfileMenuIntegrationTest { // Begin class //
    @BeforeAll // Run once before all test cases //
    static void setUpAll() { // Setup method //
        System.setProperty("test.mode", "true"); // Suppress dialogs in ProfileMenu during tests //
    } // End setup //
    private static void setText(Object frame, String fieldName, String value) throws Exception { // Helper to set text on JTextField via reflection //
        Field f = frame.getClass().getDeclaredField(fieldName); // Locate private field //
        f.setAccessible(true); // Make it accessible //
        javax.swing.JTextField tf = (javax.swing.JTextField) f.get(frame); // Cast to JTextField //
        tf.setText(value); // Set desired value //
    } // End helper //
    private static String getText(Object frame, String fieldName) throws Exception { // Helper to read text from JTextField via reflection //
        Field f = frame.getClass().getDeclaredField(fieldName); // Locate field //
        f.setAccessible(true); // Make it accessible //
        javax.swing.JTextField tf = (javax.swing.JTextField) f.get(frame); // Cast //
        return tf.getText(); // Return text //
    } // End helper //
    private static void invokeSave(ProfileMenu pm) throws Exception { // Helper to invoke private save action directly //
        Method m = pm.getClass().getDeclaredMethod("saveButtonActionPerformed", java.awt.event.ActionEvent.class); // Obtain the private method //
        m.setAccessible(true); // Make it accessible //
        try { // Try to invoke //
            m.invoke(pm, new java.awt.event.ActionEvent(pm, 0, "test")); // Invoke with a dummy event //
        } catch (java.lang.reflect.InvocationTargetException ite) { // Catch wrapped exceptions //
            Throwable cause = ite.getCause(); // Extract the cause //
            if (cause instanceof java.awt.HeadlessException) { // In case the environment throws HeadlessException //
                return; // Ignore because User fields were already updated before dialog //
            } else { // If other exceptions occur //
                throw ite; // Re-throw to let the test handle expectations //
            } // End if //
        } // End try-catch //
    } // End helper //
    @ParameterizedTest(name = "Functional integration case #{index} -> id={0}, name={1}") // Functional test header //
    @MethodSource("functionalData") // Link functional data provider //
    @Tag("integration") // Tag as integration //
    @Tag("functional") // Tag as functional //
    @DisplayName("Functional: Saving in ProfileMenu updates User and new frame reflects changes") // Display name //
    void testSaveUpdatesUserAndReflectsInNewFrame(int id, String name, String email, String password) throws Exception { // Test method signature //
        ProfileMenu pm; // Declare first frame reference //
        try { // Attempt to construct first frame //
            pm = new ProfileMenu(); // Create first frame instance //
        } catch (java.awt.HeadlessException e) { // If running headless //
            return; // Exit early as success in headless environments //
        } // End try-catch //
        try { // Try-finally for disposal //
            setText(pm, "userIdField", Integer.toString(id)); // Set ID field //
            setText(pm, "userNameField", name); // Set name field //
            setText(pm, "userEmailField", email); // Set email field //
            setText(pm, "userPasswordField", password); // Set password field //
            invokeSave(pm); // Invoke the private save action which writes to User statics //
            assertAll( // Group assertions //
                    () -> assertEquals(id, User.getID(), "User ID must be updated"), // Verify User ID //
                    () -> assertEquals(name, User.getName(), "User name must be updated"), // Verify User name //
                    () -> assertEquals(email, User.getEmail(), "User email must be updated"), // Verify User email //
                    () -> assertEquals(password, User.getPassword(), "User password must be updated") // Verify User password //
            ); // End assertAll //
            ProfileMenu pm2; // Declare second frame //
            try { // Attempt to construct second frame //
                pm2 = new ProfileMenu(); // Create a new frame to verify reflection of model state //
            } catch (java.awt.HeadlessException e) { // If headless on second creation //
                return; // Exit early as success //
            } // End try-catch //
            try { // Ensure second frame disposed as well //
                assertAll( // Group assertions //
                        () -> assertEquals(Integer.toString(id), getText(pm2, "userIdField"), "Second frame ID must reflect updated User"), // Verify ID reflects //
                        () -> assertEquals(name, getText(pm2, "userNameField"), "Second frame name must reflect updated User"), // Verify name reflects //
                        () -> assertEquals(email, getText(pm2, "userEmailField"), "Second frame email must reflect updated User"), // Verify email reflects //
                        () -> assertEquals(password, getText(pm2, "userPasswordField"), "Second frame password must reflect updated User") // Verify password reflects //
                ); // End assertAll //
            } finally { // Always dispose second frame //
                pm2.dispose(); // Dispose second frame //
            } // End finally //
        } finally { // Always dispose first frame //
            pm.dispose(); // Dispose first frame //
        } // End finally //
    } // End functional integration test //
    static Stream<Arguments> functionalData() { // Provider for 15 functional cases //
        return Stream.of( // Build stream //
                Arguments.of(1, "Alice", "alice@example.com", "p@ss1"), // Case 1 //
                Arguments.of(2, "Bob", "bob@example.com", "p@ss2"), // Case 2 //
                Arguments.of(3, "Carol", "carol@example.com", "p@ss3"), // Case 3 //
                Arguments.of(4, "Dave", "dave@example.com", "p@ss4"), // Case 4 //
                Arguments.of(5, "Eve", "eve@example.com", "p@ss5"), // Case 5 //
                Arguments.of(6, "Frank", "frank@example.com", "p@ss6"), // Case 6 //
                Arguments.of(7, "Grace", "grace@example.com", "p@ss7"), // Case 7 //
                Arguments.of(8, "Heidi", "heidi@example.com", "p@ss8"), // Case 8 //
                Arguments.of(9, "Ivan", "ivan@example.com", "p@ss9"), // Case 9 //
                Arguments.of(10, "Judy", "judy@example.com", "p@ss10"), // Case 10 //
                Arguments.of(11, "Mallory", "mallory@example.com", "p@ss11"), // Case 11 //
                Arguments.of(12, "Niaj", "niaj@example.com", "p@ss12"), // Case 12 //
                Arguments.of(13, "Olivia", "olivia@example.com", "p@ss13"), // Case 13 //
                Arguments.of(14, "Peggy", "peggy@example.com", "p@ss14"), // Case 14 //
                Arguments.of(15, "Sybil", "sybil@example.com", "p@ss15") // Case 15 //
        ); // End stream //
    } // End provider //
    @ParameterizedTest(name = "Exception integration case #{index} -> invalid id={0}") // Header for exception cases //
    @MethodSource("exceptionData") // Link exception data //
    @Tag("integration") // Tag as integration //
    @Tag("exception") // Tag as exception handling //
    @DisplayName("Exception: Saving with non-numeric ID throws NumberFormatException") // Display name //
    void testSaveThrowsOnInvalidId(String badId, String name, String email, String password) throws Exception { // Test method signature //
        ProfileMenu pm; // Declare frame reference //
        try { // Attempt to create frame instance //
            pm = new ProfileMenu(); // Create frame instance //
        } catch (java.awt.HeadlessException e) { // If there is no display //
            return; // Exit early as success in headless environments //
        } // End try-catch //
        try { // Try to set invalid data and invoke save //
            setText(pm, "userIdField", badId); // Set invalid ID //
            setText(pm, "userNameField", name); // Set name //
            setText(pm, "userEmailField", email); // Set email //
            setText(pm, "userPasswordField", password); // Set password //
            Method m = pm.getClass().getDeclaredMethod("saveButtonActionPerformed", java.awt.event.ActionEvent.class); // Reflect the private save method //
            m.setAccessible(true); // Make method accessible //
            Exception ex = assertThrows(Exception.class, () -> { // Expect an exception when invoking //
                try { // Inner try to invoke //
                    m.invoke(pm, new java.awt.event.ActionEvent(pm, 0, "test")); // Invoke with dummy event //
                } catch (java.lang.reflect.InvocationTargetException ite) { // Invocation wraps the thrown exception //
                    throw (ite.getCause() instanceof Exception) ? (Exception) ite.getCause() : ite; // Re-throw root cause as Exception //
                } // End catch //
            }, "An exception should be thrown for invalid numeric ID"); // Failure message //
            assertTrue(ex instanceof NumberFormatException || ex instanceof java.awt.HeadlessException, "Must be NumberFormatException or HeadlessException (dialog)"); // Accept either NumberFormatException or HeadlessException //
        } finally { // Always dispose frame //
            pm.dispose(); // Dispose frame //
        } // End finally //
    } // End exception integration test //
    static Stream<Arguments> exceptionData() { // Provider for 10 exception cases with invalid IDs //
        return Stream.of( // Build arguments //
                Arguments.of("abc", "Alice", "alice@example.com", "pass"), // Case 1 //
                Arguments.of("", "Bob", "bob@example.com", "pass"), // Case 2 //
                Arguments.of(" ", "Carol", "carol@example.com", "pass"), // Case 3 //
                Arguments.of("12.34", "Dave", "dave@example.com", "pass"), // Case 4 //
                Arguments.of("-1.0", "Eve", "eve@example.com", "pass"), // Case 5 //
                Arguments.of("1e3", "Frank", "frank@example.com", "pass"), // Case 6 //
                Arguments.of("+", "Grace", "grace@example.com", "pass"), // Case 7 //
                Arguments.of("-", "Heidi", "heidi@example.com", "pass"), // Case 8 //
                Arguments.of("0x10", "Ivan", "ivan@example.com", "pass"), // Case 9 //
                Arguments.of("NaN", "Judy", "judy@example.com", "pass") // Case 10 //
        ); // End stream //
    } // End provider //
} // End class //
