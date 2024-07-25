import java.util.ArrayList;

public class FileStorage {

    private int availableSize;
    private int maxSize;
    private final ArrayList<File> list;

    public int getAvailableSize() {
        return availableSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Construct object and set max storage size and available size according passed values (default value=100)
     *
     * @param size FileStorage size
     */



    public FileStorage(int size) {
        //this.availableSize = this.maxSize = 100;
        this.maxSize = size;
        this.availableSize = this.maxSize;
        this.list = new ArrayList<File>();
    }

    /**
     * Write file in storage if filename is unique and size is not more than available size
     * @param file to save in file storage
     * @return result of file saving
     * @throws Error in case of already existent filename
     */
    public boolean write(File file) throws Error {
        if (list.contains(file)) {
            throw new Error();
        } else if (file.getFileSize() >= this.availableSize) {
            return false;
        } else {
            this.list.add(file);
            this.availableSize -= file.getFileSize();
            return true;
        }
    }
}
