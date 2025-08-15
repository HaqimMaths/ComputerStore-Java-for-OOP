package com.alphatechsz.computerstore_test.integration; // Package for integration tests //
import com.alphatechsz.computerstore.Computer; // Import Computer class //
import org.junit.jupiter.api.BeforeAll; // Import for one-time setup //
import org.junit.jupiter.api.DisplayName; // Import for display names //
import org.junit.jupiter.api.Tag; // Import for tagging //
import org.junit.jupiter.params.ParameterizedTest; // Import for parameterized tests //
import org.junit.jupiter.params.provider.MethodSource; // Import for method-sourced arguments //
import org.junit.jupiter.params.provider.Arguments; // Import Arguments //
import java.util.stream.Stream; // Import Stream //
import static org.junit.jupiter.api.Assertions.*; // Import assertions //
@DisplayName("Computer Integration Tests (Product + Diagnosis behaviors)") // Class display name //
public class ComputerIntegrationTest { // Start class //
    @BeforeAll // Initialize once for all tests //
    static void beforeAll() { // Setup method //
        System.setProperty("test.mode", "true"); // Ensure no blocking dialogs from any UI component //
    } // End setup //
    @ParameterizedTest(name = "Functional integration case #{index} -> price={12}, discount={13}%") // Functional integration test header //
    @MethodSource("functionalData") // Link functional data //
    @Tag("integration") // Mark as integration //
    @Tag("functional") // Mark as functional suite //
    @DisplayName("Functional: Discount math and gaming detection across Computer/Product") // Display name //
    void testDiscountAndGamingFunctional( // Method signature //
            int id, String brand, String model, String type, String size, String color, int year, // Product attributes //
            String cpu, String gpu, String mobo, int storage, int ram, double price, double discount, boolean isGaming // Computer-specific and expectations //
    ) { // Start method //
        Computer c = new Computer(id, brand, model, type, size, color, year, cpu, gpu, mobo, storage, ram, price); // Construct Computer //
        double expectedDiscountTotal = (discount * price) / 100.0; // Compute expected total discount //
        double expectedDiscountPrice = price - expectedDiscountTotal; // Compute expected discounted price //
        assertAll( // Group assertions //
                () -> assertEquals(isGaming, c.isComputerGaming(), "Gaming detection must match expectation"), // Verify gaming detection from GPU string //
                () -> assertEquals(expectedDiscountTotal, c.getDiscountTotal(discount), 0.0001, "Discount total must match"), // Verify discount total //
                () -> assertEquals(expectedDiscountPrice, c.getDiscountPrice(discount), 0.0001, "Discounted price must match") // Verify discounted price //
        ); // End assertions //
    } // End functional integration test //
    static Stream<Arguments> functionalData() { // Data provider for 15 functional integration cases //
        return Stream.of( // Provide argument sets //
                Arguments.of(100, "Dell", "XPS", "Ultrabook", "30x20x2", "Silver", 2022, "i7", "RTX 3050", "XPS Board", 512, 16, 6000.0, 10.0, true), // Case 1 //
                Arguments.of(101, "HP", "Omen", "Gaming", "35x25x3", "Black", 2023, "i9", "RTX 4080", "Omen Max", 2048, 32, 13000.0, 15.0, true), // Case 2 //
                Arguments.of(102, "Apple", "MBP", "Pro", "30x21x2", "Gray", 2021, "M1", "Integrated", "Apple", 1024, 16, 9000.0, 5.0, false), // Case 3 //
                Arguments.of(103, "Lenovo", "ThinkPad", "Business", "31x22x2", "Black", 2020, "i5", "Integrated", "Lenovo", 256, 8, 3500.0, 20.0, false), // Case 4 //
                Arguments.of(104, "Asus", "ROG", "Gaming", "36x26x3", "Black", 2024, "Ryzen 9", "Radeon RX 7900", "ROG", 2048, 64, 14000.0, 25.0, true), // Case 5 //
                Arguments.of(105, "Acer", "Swift", "Ultrabook", "30x20x2", "Blue", 2022, "i7", "Arc A370M", "Swift", 512, 16, 5300.0, 10.0, true), // Case 6 //
                Arguments.of(106, "MSI", "Creator", "Pro", "33x23x2", "White", 2023, "i7", "RTX 4060", "MSI", 1024, 32, 9000.0, 10.0, true), // Case 7 //
                Arguments.of(107, "Gigabyte", "Aero", "Creator", "33x22x2", "Silver", 2022, "i9", "RTX 4070", "Gigabyte", 1024, 32, 10000.0, 12.5, true), // Case 8 //
                Arguments.of(108, "Razer", "Blade", "Gaming", "35x24x2", "Black", 2023, "i9", "RTX 4090", "Razer", 2048, 64, 16000.0, 17.5, true), // Case 9 //
                Arguments.of(109, "Samsung", "GalaxyBook", "Portable", "29x19x2", "Silver", 2021, "i5", "Integrated", "Samsung", 512, 8, 4000.0, 10.0, false), // Case 10 //
                Arguments.of(110, "Huawei", "MateBook", "Portable", "29x19x2", "Gray", 2022, "i7", "Integrated", "Huawei", 512, 16, 4600.0, 7.0, false), // Case 11 //
                Arguments.of(111, "Microsoft", "Surface", "2-in-1", "29x20x2", "Platinum", 2023, "i7", "Integrated", "Microsoft", 1024, 32, 9000.0, 8.0, false), // Case 12 //
                Arguments.of(112, "Alienware", "M17", "Gaming", "40x28x3", "Black", 2024, "Ryzen 7", "RTX 4080", "Alien", 2048, 32, 14000.0, 30.0, true), // Case 13 //
                Arguments.of(113, "Framework", "13", "Modular", "30x20x2", "Silver", 2024, "i7", "Integrated", "FW", 1024, 32, 8000.0, 9.0, false), // Case 14 //
                Arguments.of(114, "Tuxedo", "Infinity", "Linux", "31x21x2", "Black", 2023, "i7", "RTX 4050", "TXD", 1024, 32, 7600.0, 11.0, true) // Case 15 //
        ); // End stream //
    } // End provider //
    @ParameterizedTest(name = "Exception integration case #{index} -> GPU may be null") // Header for exception tests //
    @MethodSource("exceptionData") // Link exception data //
    @Tag("integration") // Tag as integration //
    @Tag("exception") // Tag as exception handling //
    @DisplayName("Exception: isComputerGaming throws NPE when GPU type is null") // Display name //
    void testGamingDetectionThrowsOnNullGPU( // Method testing exception //
            String gpu // Only GPU is relevant for exception behavior //
    ) { // Start method //
        Computer c = new Computer(1, "Brand", "Model", "Type", "Size", "Color", 2024, "CPU", gpu, "Mobo", 256, 8, 1000.0); // Build computer with possibly null GPU //
        assertThrows(NullPointerException.class, c::isComputerGaming, "Null GPU must cause NPE due to toLowerCase"); // Expect NPE when calling isComputerGaming //
    } // End exception test //
    static Stream<Arguments> exceptionData() { // Data provider for 10 exception cases //
        return Stream.of( // Build arguments //
                Arguments.of((String) null), // Case 1: null //
                Arguments.of((String) null), // Case 2: null //
                Arguments.of((String) null), // Case 3: null //
                Arguments.of((String) null), // Case 4: null //
                Arguments.of((String) null), // Case 5: null //
                Arguments.of((String) null), // Case 6: null //
                Arguments.of((String) null), // Case 7: null //
                Arguments.of((String) null), // Case 8: null //
                Arguments.of((String) null), // Case 9: null //
                Arguments.of((String) null) // Case 10: null //
        ); // End stream //
    } // End provider //
} // End class //
