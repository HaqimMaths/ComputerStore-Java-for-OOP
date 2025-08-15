package com.alphatechsz.computerstore_test.unit; // Package for unit tests //
import com.alphatechsz.computerstore.Computer; // Import Computer class under test //
import org.junit.jupiter.api.BeforeAll; // Import JUnit lifecycle annotation //
import org.junit.jupiter.api.DisplayName; // Import for readable test names //
import org.junit.jupiter.api.Tag; // Import for test categorization //
import org.junit.jupiter.params.ParameterizedTest; // Import for parameterized tests //
import org.junit.jupiter.params.provider.MethodSource; // Import for data providers //
import java.util.stream.Stream; // Import stream to build arguments //
import org.junit.jupiter.params.provider.Arguments; // Import Arguments for parameterized tests //
import static org.junit.jupiter.api.Assertions.*; // Import assertions for tests //
@DisplayName("Computer Constructors Unit Tests") // Human friendly name for this class //
public class ComputerConstructorUnitTest { // Begin the test class //
    @BeforeAll // Run once before any test case executes //
    static void setUpOnce() { // Method to perform global setup for this class //
        System.setProperty("test.mode", "true"); // Ensure dialogs in app are skipped during tests //
    } // End of setup method //
    @ParameterizedTest(name = "Functional constructor case #{index} -> ID={0}, brand={1}, model={2}, price={12}") // Define parameterized functional test with formatted name //
    @MethodSource("functionalConstructorData") // Link the data provider for functional cases //
    @Tag("unit") // Tag as unit test //
    @Tag("functional") // Tag as functional testing //
    @DisplayName("Functional: Parameterized Computer constructor sets all fields correctly") // Set display name //
    void testComputerParameterizedConstructorFunctional( // Test method signature //
            int id, String brand, String model, String type, String size, String color, int year, // Product-related arguments //
            String cpu, String gpu, String mobo, int storage, int ram, double price // Computer-related arguments //
    ) { // Start of test body //
        Computer c = new Computer(id, brand, model, type, size, color, year, cpu, gpu, mobo, storage, ram, price); // Create a Computer using the parameterized constructor //
        assertAll( // Group assertions so all are checked //
                () -> assertEquals(id, c.getID(), "ID must match"), // Verify ID //
                () -> assertEquals(brand, c.getBrand(), "Brand must match"), // Verify brand //
                () -> assertEquals(model, c.getModel(), "Model must match"), // Verify model //
                () -> assertEquals("Computer", c.getCategory(), "Category must be 'Computer'"), // Verify enforced category //
                () -> assertEquals(type, c.getType(), "Type must match"), // Verify type //
                () -> assertEquals(size, c.getSize(), "Size must match"), // Verify size //
                () -> assertEquals(color, c.getColor(), "Color must match"), // Verify color //
                () -> assertEquals(year, c.getManufactureYear(), "Year must match"), // Verify manufacture year //
                () -> assertEquals(price, c.getPrice(), 0.0001, "Price must match"), // Verify price //
                () -> assertEquals(cpu, c.getTypeCPU(), "CPU type must match"), // Verify CPU //
                () -> assertEquals(gpu, c.getTypeGPU(), "GPU type must match"), // Verify GPU //
                () -> assertEquals(mobo, c.getTypeMotherboard(), "Motherboard type must match"), // Verify motherboard //
                () -> assertEquals(storage, c.getSizeStorage(), "Storage size must match"), // Verify storage //
                () -> assertEquals(ram, c.getSizeRAM(), "RAM size must match") // Verify RAM //
        ); // End of assertAll //
    } // End of functional constructor test //
    static Stream<Arguments> functionalConstructorData() { // Data provider for 15 functional cases //
        return Stream.of( // Build a stream of argument sets //
                Arguments.of(1, "Dell", "XPS", "Ultrabook", "30x20x2", "Silver", 2022, "Intel i7", "RTX 3050", "XPS Board", 512, 16, 5999.99), // Case 1 //
                Arguments.of(2, "HP", "Omen", "Gaming", "35x25x3", "Black", 2023, "Intel i9", "RTX 4080", "Omen Max", 2048, 32, 12999.00), // Case 2 //
                Arguments.of(3, "Apple", "MacBookPro", "Professional", "30x21x2", "Space Gray", 2021, "M1", "Integrated", "Apple Mobo", 1024, 16, 8999.50), // Case 3 //
                Arguments.of(4, "Lenovo", "ThinkPad", "Business", "31x22x2", "Black", 2020, "Intel i5", "Integrated", "ThinkPad Board", 256, 8, 3499.00), // Case 4 //
                Arguments.of(5, "Asus", "ROG", "Gaming", "36x26x3", "Black", 2024, "AMD Ryzen 9", "Radeon RX 7900", "ROG Board", 2048, 64, 13999.99), // Case 5 //
                Arguments.of(6, "Acer", "Swift", "Ultrabook", "30x20x2", "Blue", 2022, "Intel i7", "Arc A370M", "Swift Board", 512, 16, 5299.00), // Case 6 //
                Arguments.of(7, "MSI", "Creator", "Professional", "33x23x2", "White", 2023, "Intel i7", "RTX 4060", "Creator Mobo", 1024, 32, 8999.00), // Case 7 //
                Arguments.of(8, "Gigabyte", "Aero", "Creator", "33x22x2", "Silver", 2022, "Intel i9", "RTX 4070", "Aero Board", 1024, 32, 9999.00), // Case 8 //
                Arguments.of(9, "Razer", "Blade", "Gaming", "35x24x2", "Black", 2023, "Intel i9", "RTX 4090", "Blade Mobo", 2048, 64, 15999.99), // Case 9 //
                Arguments.of(10, "Samsung", "GalaxyBook", "Portable", "29x19x2", "Silver", 2021, "Intel i5", "Integrated", "Galaxy Board", 512, 8, 3999.00), // Case 10 //
                Arguments.of(11, "Huawei", "MateBook", "Portable", "29x19x2", "Gray", 2022, "Intel i7", "Integrated", "Mate Mobo", 512, 16, 4599.00), // Case 11 //
                Arguments.of(12, "Microsoft", "Surface", "2-in-1", "29x20x2", "Platinum", 2023, "Intel i7", "Integrated", "Surface Board", 1024, 32, 8999.00), // Case 12 //
                Arguments.of(13, "Alienware", "M17", "Gaming", "40x28x3", "Black", 2024, "AMD Ryzen 7", "RTX 4080", "Alien Board", 2048, 32, 13999.00), // Case 13 //
                Arguments.of(14, "Framework", "13", "Modular", "30x20x2", "Silver", 2024, "Intel i7", "Integrated", "FW Board", 1024, 32, 7999.00), // Case 14 //
                Arguments.of(15, "Tuxedo", "Infinity", "Linux", "31x21x2", "Black", 2023, "Intel i7", "RTX 4050", "TXD Board", 1024, 32, 7599.00) // Case 15 //
        ); // End of stream //
    } // End of functional data provider //
    @ParameterizedTest(name = "Boundary constructor case #{index} -> useDefault={0}, ID={1}, price={12}") // Define parameterized boundary test //
    @MethodSource("boundaryConstructorData") // Link the boundary data provider //
    @Tag("unit") // Tag as unit test //
    @Tag("boundary") // Tag as boundary testing //
    @DisplayName("Boundary: Default and edge values for Computer constructor") // Display name for boundary tests //
    void testComputerConstructorBoundary( // Method testing boundary behavior //
            boolean useDefault, int id, String brand, String model, String type, String size, String color, int year, // Product-like fields //
            String cpu, String gpu, String mobo, int storage, int ram, double price // Computer fields //
    ) { // Start method //
        Computer c = useDefault // Decide which constructor to use //
                ? new Computer() // Use default constructor when flag is true //
                : new Computer(id, brand, model, type, size, color, year, cpu, gpu, mobo, storage, ram, price); // Otherwise use parameterized constructor //
        if (useDefault) { // When using default constructor, verify defaults //
            assertAll( // Group assertions //
                    () -> assertEquals(0, c.getID()), // Default ID should be 0 //
                    () -> assertEquals("None", c.getBrand()), // Default brand should be "None" //
                    () -> assertEquals("None", c.getModel()), // Default model should be "None" //
                    () -> assertEquals("Computer", c.getCategory()), // Category enforced by constructor call in default path //
                    () -> assertEquals("None", c.getType()), // Default type should be "None" //
                    () -> assertEquals("None", c.getSize()), // Default size should be "None" //
                    () -> assertEquals("None", c.getColor()), // Default color should be "None" //
                    () -> assertEquals(0, c.getManufactureYear()), // Default year should be 0 //
                    () -> assertEquals(0.0, c.getPrice(), 0.0001), // Default price should be 0.0 //
                    () -> assertEquals("None", c.getTypeCPU()), // Default CPU should be "None" //
                    () -> assertEquals("None", c.getTypeGPU()), // Default GPU should be "None" //
                    () -> assertEquals("None", c.getTypeMotherboard()), // Default motherboard should be "None" //
                    () -> assertEquals(0, c.getSizeStorage()), // Default storage should be 0 //
                    () -> assertEquals(0, c.getSizeRAM()) // Default RAM should be 0 //
            ); // End assertions //
        } else { // For boundary parameterized values, verify pass-through assignment //
            assertAll( // Group boundary assertions //
                    () -> assertEquals(id, c.getID()), // ID matches even if edge value //
                    () -> assertEquals(brand, c.getBrand()), // Brand matches //
                    () -> assertEquals(model, c.getModel()), // Model matches //
                    () -> assertEquals(type, c.getType()), // Type matches //
                    () -> assertEquals(size, c.getSize()), // Size matches //
                    () -> assertEquals(color, c.getColor()), // Color matches //
                    () -> assertEquals(year, c.getManufactureYear()), // Year matches //
                    () -> assertEquals(price, c.getPrice(), 0.0001), // Price matches //
                    () -> assertEquals(cpu, c.getTypeCPU()), // CPU matches //
                    () -> assertEquals(gpu, c.getTypeGPU()), // GPU matches //
                    () -> assertEquals(mobo, c.getTypeMotherboard()), // Motherboard matches //
                    () -> assertEquals(storage, c.getSizeStorage()), // Storage matches //
                    () -> assertEquals(ram, c.getSizeRAM()) // RAM matches //
            ); // End assertions //
        } // End if-else //
    } // End boundary test //
    static Stream<Arguments> boundaryConstructorData() { // Data provider for 10 boundary cases (first one uses default constructor) //
        return Stream.of( // Build arguments //
                Arguments.of(true, 0, "None", "None", "None", "None", "None", 0, "None", "None", "None", 0, 0, 0.0), // Case 1: default constructor validation //
                Arguments.of(false, -1, "", "", "", "", "", -1900, "", "", "", -1, -1, -0.01), // Case 2: negatives and empties //
                Arguments.of(false, Integer.MAX_VALUE, "B", "M", "T", "S", "C", 9999, "CPU", "GPU", "MB", Integer.MAX_VALUE, Integer.MAX_VALUE, Double.MAX_VALUE), // Case 3: max ints and price //
                Arguments.of(false, Integer.MIN_VALUE, "b", "m", "t", "s", "c", -9999, "cpu", "gpu", "mb", Integer.MIN_VALUE, Integer.MIN_VALUE, -Double.MAX_VALUE), // Case 4: min ints and negative price //
                Arguments.of(false, 0, " ", " ", " ", " ", " ", 0, " ", " ", " ", 0, 0, 0.0), // Case 5: whitespace values //
                Arguments.of(false, 123, "LongBrandNameLongBrandName", "LongModelNameLongModelName", "TT", "SS", "CC", 1, "CPU-EXTREME", "RTX-000", "MB-EXTREME", 1, 1, 0.1), // Case 6: long strings //
                Arguments.of(false, 42, "Ø", "模型", "タイプ", "サイズ", "顏色", 2024, "处理器", "显卡", "主板", 999, 128, 1.0), // Case 7: non-ASCII //
                Arguments.of(false, 7, "Brand", "Model", "Type", "Size", "Color", 0, "CPU", "Arc A380", "Mobo", 0, 0, 123.45), // Case 8: zero storage/ram //
                Arguments.of(false, 8, "Brand", "Model", "Type", "Size", "Color", 2024, "CPU", "radeon rx 7600", "Mobo", 512, 16, 4999.99), // Case 9: lowercase gpu //
                Arguments.of(false, 9, "Brand", "Model", "Type", "Size", "Color", 2024, "CPU", "RTX", "Mobo", 512, 16, 4999.99) // Case 10: minimalist GPU marker //
        ); // End stream //
    } // End boundary data provider //
} // End test class //
