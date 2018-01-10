package homework.bean;

public class Book {
    private String bname;
    private String author;
    private double price;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Book{" + "bname='" + bname + '\'' + ", author='" + author + '\'' + ", price=" + price + ", path='" + path + '\'' + '}';
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String bname, String author, double price) {

        this.bname = bname;
        this.author = author;
        this.price = price;
    }

    public Book(String bname, String author, double price, String path) {
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.path = path;
    }

    public Book() {

    }
}
