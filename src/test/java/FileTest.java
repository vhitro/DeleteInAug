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

}
