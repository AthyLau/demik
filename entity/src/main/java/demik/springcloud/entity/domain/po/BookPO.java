package demik.springcloud.entity.domain.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/3/24 2:16 AM
 * @since JDK 1.8
 */
public class BookPO {
    /**
     * 教材id
     */
    private Integer bookId;
    /**
     * 教材名字
     */
    private String bookName;

    public BookPO() {
    }

    public BookPO(Integer bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookPO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
