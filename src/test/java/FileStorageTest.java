import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileStorageTest {

    private FileStorage storage;

    @BeforeMethod
    public void setUp(){
        storage = new FileStorage(100);
    }


    @Test
    public void testFileStorageInitialization(){
        Assert.assertEquals(storage.getMaxSize(),100);
        Assert.assertEquals(storage.getAvailableSize(),100, "wrong");
    }
    @Test
    public void testWriteFile() throws Error {
        File file = new File("example.txt", "content");
        boolean result = storage.write(file);
        Assert.assertTrue(result);
        Assert.assertEquals(storage.getAvailableSize(), 100 - file.getFileSize());
    }
    @Test(expectedExceptions = Error.class)
    public void testWriteDuplicateFile() throws Error {
        File file = new File("example.txt", "content");
        storage.write(file);
        storage.write(file);
    }
    @Test
    public void testWriteFileExceedingSize() throws Error {
        String largeContent = new String(new char[201]).replace("\0","A");
        File file = new File("largefile.txt",largeContent);
        boolean result = storage.write(file);
        Assert.assertFalse(result);
    }
}
