 class Book{
    String title;
    String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}

class Bookrepo{
    public void save(Book book){
        System.out.println("Book saved: " + book.title);

    }
        // Implementation for saving book
}

class Bookprinter{
    public void print(Book book){
        System.out.println("book title:" + book.title);
        System.out.println("book author:" + book.author);
     }
}

public class SRP {
    public static void main(String[] args) {
        Book book = new Book("jav" , "yash");
        Bookprinter printer = new Bookprinter();
        printer.print(book);
        Bookrepo repo = new Bookrepo();
        repo.save(book);
        
    }
}