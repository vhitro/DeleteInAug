public class File {
    private final String filename;
    private final String content;
    private final int fileSize;
    private final String extension;

    /**
     * Construct object with passed filename and content, set extension based
     * on filename and calculate size as half content length.
     *
     * @param filename File name (mandatory) with extension (optional), without directory tree (path separators:
     * https://en.wikipedia.org/wiki/Path_(computing)#Representations_of_paths_by_operating_system_and_shell)
     * @param content  File content (could be empty, but must be set)
     */

    public File(String filename, String content) {
        if (content == null || content.isEmpty()){
            throw new IllegalArgumentException("Content cannot be empty");
        }
        this.filename = filename;
        this.content = content;
        this.fileSize = content.length() / 2;
        //filename.split("\.")[filename.split("\.").length - 1]:
        // Это выражение извлекает последний элемент из массива строк,
        // который был создан методом split(). В случае с "example.txt" это будет строка "txt".
        this.extension = filename.split("\\.")[filename.split("\\.").length - 1];
    }

    /**
     * Get exactly file size
     *
     * @return File size
     */
    public int getFileSize() {
        return this.fileSize;
    }

    /**
     * Get File filename
     *
     * @return File filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Get File extebtion
     * @return
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * Get File content
     * @return
     */
    public String getContent() {
        return this.content;
    }
}
