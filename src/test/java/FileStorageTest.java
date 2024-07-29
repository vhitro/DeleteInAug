import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileStorageTest {

    private FileStorage storage;

    @BeforeMethod
    public void setUp(){
        storage = new FileStorage(100);
    }

    //Основная ошибка это то, что все тестовые данные закардкожены, в реальных проектах это очень плохо, т.к. часто есть
    //необходимость делать это на больщих массивах данные, даже если и не больших, то все равно нужно иметь место где
    //у тебя тестовые методы будут лежать.
    //Для простоты ты можешь сделать DataProvider, также нужно уметь работать с конфиг файлами, файлами джейса.
    //Для этого задание, сделайть DataProvider и конфиг файл


    @Test
    public void testFileStorageInitialization(){
        Assert.assertEquals(storage.getMaxSize(),100);
        Assert.assertEquals(storage.getAvailableSize(),100, "wrong");
    }
    //все тоже, хотелось бы делать проверку при разных значениях, например ноль или отрицательное, в коде на этот случай
    //ничего не предусмотрено

    @Test
    public void testWriteFile() throws Error {
        File file = new File("example.txt", "content");
        boolean result = storage.write(file);
        Assert.assertTrue(result);
        Assert.assertEquals(storage.getAvailableSize(), 100 - file.getFileSize());
    }
    //throws Error прокидывать Error
    // это прям самое плохое, что ты можешь в коде сделать, все ошибки и исключения должны быть обработаны

    // File file = new File("example.txt", "content"); - захардкженные тестовые данные, они в тестовый метод должны
    // передаваться как параметры

    // Assert.assertTrue(result);
    // Assert.assertEquals(storage.getAvailableSize(), 100 - file.getFileSize()); - добавляй в ассерты, читабельные
    //сообщения

    @Test(expectedExceptions = Error.class)
    public void testWriteDuplicateFile() throws Error {
        File file = new File("example.txt", "content");
        storage.write(file);
        storage.write(file);
    }

    // Error.class - боль глаз, не делай ак никогда, даже под прицелом, я не буду писать почему, надеюссь ты мне потом
    //пояснишь

    //throws Error - писала выше
    // File file = new File("example.txt", "content");

    //Здесь тоже хотелось бы иметь возможность потестировать разные файлы, которые отличаются сильно,
    // и имеют одно отличие к примеру, короче говоря не хватает вариативности тоже.

    @Test
    public void testWriteFileExceedingSize() throws Error {
        String largeContent = new String(new char[201]).replace("\0","A");
        File file = new File("largefile.txt",largeContent);
        boolean result = storage.write(file);
        Assert.assertFalse(result);
    }

    //throws Error - писала

    //тоже не хватает проверок, т.е. этот тест нужно сделать параметризированным, под разные случае, когда еще много места
    //в хранилище, когда не совсем чуть чуть
}
