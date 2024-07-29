import org.testng.Assert;
import org.testng.annotations.Test;


public class FileTest {

    @Test
    public void testFileCreation(){
        File file = new File("exampleOne.txt","Test text for exampleOne txt file!");
        Assert.assertEquals(file.getFilename(), "exampleOne.txt");
        Assert.assertEquals(file.getFileSize(),"Test text for exampleOne txt file!".length()/2 );
        Assert.assertEquals(file.getExtension(),"txt");
        Assert.assertEquals(file.getContent(), "Test text for exampleOne txt file!");
    }

    // getExtension() и getContent() - в начальном коде гетеров на это нет, и тебе нужно подумать, как достать значения
    //на которые кто то забыл написать геттер

    @Test
    public void testFileSizeCalculation(){
        File file = new File("example.txt","12345678");
        Assert.assertEquals(file.getFileSize(),4);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFileCreationWithEmptyContent() {
        new File("empty.txt", "");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFileCreationWithNullContent() {
        new File("null.txt", null);
    }


    //три последних теста пока коментить не буду, делать то, на что я коменты уже написала
}
