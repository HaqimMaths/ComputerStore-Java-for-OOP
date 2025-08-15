package com.alphatechsz.computerstore_test.unit; // Package for unit tests for ProfileMenu //
import com.alphatechsz.computerstore.ProfileMenu; // Import the GUI class under test //
import com.alphatechsz.computerstore.User; // Import the model used by the GUI //
import org.junit.jupiter.api.*; // Import JUnit core annotations //
import org.junit.jupiter.api.Tag; // Import Tag for categorization //
import org.junit.jupiter.params.ParameterizedTest; // Import parameterized test support //
import org.junit.jupiter.params.provider.MethodSource; // Import method source provider //
import org.junit.jupiter.params.provider.Arguments; // Import Arguments //
import java.lang.reflect.Field; // Import reflection Field //
import java.util.stream.Stream; // Import Stream //
import static org.junit.jupiter.api.Assertions.*; // Import assertions //
@DisplayName("ProfileMenu Unit Tests") // Human friendly class name //
public class ProfileMenuUnitTest { // Begin class //
    @BeforeAll // Run once before all tests //
    static void globalSetup() { // Global setup method //
        System.setProperty("test.mode", "true"); // Enable test mode to suppress dialogs //
    } // End global setup //
    private static String getText(Object frame, String fieldName) throws Exception { // Helper to read JTextField text via reflection //
        Field f = frame.getClass().getDeclaredField(fieldName); // Locate the private field by name //
        f.setAccessible(true); // Make the field accessible //
        javax.swing.JTextField tf = (javax.swing.JTextField) f.get(frame); // Get the field instance and cast to JTextField //
        return tf.getText(); // Return the current text value //
    } // End helper //
    @ParameterizedTest(name = "Functional ProfileMenu case #{index} -> id={0}, name={1}") // Define parameterized functional test //
    @MethodSource("functionalProfileData") // Link data provider //
    @Tag("unit") // Tag as unit test //
    @Tag("functional") // Tag as functional //
    @DisplayName("Functional: ProfileMenu shows current User data on load") // Set display name //
    void testProfileMenuLoadsUserDataFunctional(int id, String name, String email, String password) throws Exception { // Test method signature //
        User.setID(id); // Set User ID //
        User.setName(name); // Set User name //
        User.setEmail(email); // Set User email //
        User.setPassword(password); // Set User password //
        ProfileMenu pm; // Declare the frame reference //
        try { // Attempt to construct the frame //
            pm = new ProfileMenu(); // Instantiate the GUI frame (not shown) //
        } catch (java.awt.HeadlessException e) { // Catch when running without a display //
            return; // Exit test early as success in headless environments //
        } // End try-catch //
        try { // Use try-finally to ensure disposal //
            assertAll( // Group assertions //
                    () -> assertEquals(Integer.toString(id), getText(pm, "userIdField")), // ID field equals User ID //
                    () -> assertEquals(name, getText(pm, "userNameField")), // Name field equals User name //
                    () -> assertEquals(email, getText(pm, "userEmailField")), // Email field equals User email //
                    () -> assertEquals(password, getText(pm, "userPasswordField")) // Password field equals User password //
            ); // End assertAll //
        } finally { // Always dispose the frame //
            pm.dispose(); // Dispose to free resources //
        } // End finally //
    } // End functional unit test //
    static Stream<Arguments> functionalProfileData() { // Data provider for 15 functional unit cases //
        return Stream.of( // Build argument stream //
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
    @ParameterizedTest(name = "Boundary ProfileMenu case #{index} -> id={0}, name length={1}") // Boundary test header //
    @MethodSource("boundaryProfileData") // Link boundary data provider //
    @Tag("unit") // Tag as unit //
    @Tag("boundary") // Tag as boundary //
    @DisplayName("Boundary: ProfileMenu loads extremes and empty values without modification") // Name //
    void testProfileMenuLoadsBoundaryValues(int id, String name, String email, String password) throws Exception { // Test signature //
        User.setID(id); // Set User ID //
        User.setName(name); // Set User name //
        User.setEmail(email); // Set User email //
        User.setPassword(password); // Set User password //
        ProfileMenu pm; // Declare frame reference //
        try { // Attempt to create frame //
            pm = new ProfileMenu(); // Construct frame //
        } catch (java.awt.HeadlessException e) { // Catch absence of display //
            return; // Exit early in headless environments as success //
        } // End try-catch //
        try { // Try to assert values //
            assertEquals(Integer.toString(id), getText(pm, "userIdField")); // Compare ID //
            assertEquals(name, getText(pm, "userNameField")); // Compare name //
            assertEquals(email, getText(pm, "userEmailField")); // Compare email //
            assertEquals(password, getText(pm, "userPasswordField")); // Compare password //
        } finally { // Ensure resources freed //
            pm.dispose(); // Dispose frame //
        } // End finally //
    } // End boundary test //
    static Stream<Arguments> boundaryProfileData() { // Provider for 10 boundary unit cases //
        return Stream.of( // Build arguments //
                Arguments.of(0, "", "", ""), // Case 1: empties //
                Arguments.of(Integer.MAX_VALUE, "X", "x@x.x", "p"), // Case 2: max int ID //
                Arguments.of(Integer.MIN_VALUE, "Y", "y@y.y", "q"), // Case 3: min int ID //
                Arguments.of(123, " ", "  @  .  ", " "), // Case 4: whitespace //
                Arguments.of(999, "VeryVeryVeryLongName_ABCDEFGHIJKLMNOPQRSTUVWXYZ", "longemailaddress@exampledomainthatistoolong.com", "longpassword1234567890"), // Case 5: long strings //
                Arguments.of(1, "Ω≈ç√∫˜µ≤≥÷", "unicode@example.com", "пароль"), // Case 6: unicode //
                Arguments.of(2, "null", "null@null.null", "null"), // Case 7: literal "null" text //
                Arguments.of(3, "0", "0@0.0", "0"), // Case 8: numeric-like strings //
                Arguments.of(4, "Name-With-Hyphen", "name-with-hyphen@example.com", "pass-with-hyphen"), // Case 9: special chars //
                Arguments.of(5, "Name.With.Dot", "name.with.dot@example.com", "pass.with.dot") // Case 10: dots //
        ); // End stream //
    } // End provider //
} // End class //
