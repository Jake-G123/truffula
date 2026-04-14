import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }
  @Test
  void testFakePath() {
    String[] args = {"/test/here"};

    // Act  & Assert: Check that a path that doesnt exist throws filenotfound
    assertThrows(IllegalArgumentException.class, () -> {
      new TruffulaOptions(args);
    });
  }
  @Test
  void testNoPath() {
    String[] args = {"-h"};

    // Act  & Assert: Check that a missing path throws illegalarg.
    assertThrows(IllegalArgumentException.class, () -> {
      new TruffulaOptions(args);
    });
  }
  @Test
  void testFakeArgs(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String[] args = {"test", directory.getAbsolutePath()};

    // Act  & Assert: Check that the illegal args error pops up.
    assertThrows(IllegalArgumentException.class, () -> {
      new TruffulaOptions(args);
    });
  }
}
