package demik.springcloud.entity.domain.pojo;

/**
 * Function:目录信息封装
 *
 * @author liubing
 * Date: 2018/12/14 下午3:16
 * @since JDK 1.8
 */


public class FileInfo {
    /**
     * 文件名字
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;

    public FileInfo() {
    }

    public FileInfo(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
