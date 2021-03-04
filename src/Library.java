import java.util.Random;

public class Library {
    public static void main (String[] args) {
        Book[] books;
        Reader reader = new Reader();
        books = Book.getRandomBooks(10);
        for(int i=0; i < books.length; i++) {
            reader.readBook(books[i]);
        }

        Book chosenBook = reader.choiceBook(books);
        reader.readBook(chosenBook);
        reader.assessment(chosenBook);
    }

}

class Book{

    String name;
    String author;
    int seriesNumber;
    int pagesNumber;

    @Override
    public String toString() {
        return "Book {" +
                "name = " + name + ", author = " + author + ", seriesNumber = " + seriesNumber + ", pagesNumber = " + pagesNumber + "}";
    }

    Book(String name, int pagesNumber){
        this.name = name;
        this.pagesNumber = pagesNumber;
        this.seriesNumber = 0;
        this.author = null;
    }

    Book(String name, int pagesNumber, int seriesNumber){
        this.name = name;
        this.pagesNumber = pagesNumber;
        this.seriesNumber = seriesNumber;
        this.author = null;
    }

    Book(String name, int pagesNumber, int seriesNumber, String author){
        this.name = name;
        this.pagesNumber = pagesNumber;
        this.seriesNumber = seriesNumber;
        this.author = author;
    }

    static Book[] getRandomBooks(int booksCount) {
        String[] authors = {"Pushkin", "Gogol", "Dostoevsky", "Lermontov", "Tolstoy"};
        Book[] result = new Book[booksCount];
        Random rand = new Random();
        for(int i = 0; i < booksCount; i++) {

            int numberOfConstructors = rand.nextInt(3);

            String name = "Book #" + (i + 1);
            int pagesNumber = rand.nextInt(285) + 15;
            int seriesNumber = rand.nextInt(99) + 1;
            String author = authors[rand.nextInt(authors.length)];

            switch (numberOfConstructors) {
                case 0:
                    result[i] = new Book(name, pagesNumber);
                    break;
                case 1:
                    result[i] = new Book(name, pagesNumber, seriesNumber);
                    break;
                case 2:
                    result[i] = new Book(name, pagesNumber, seriesNumber, author);
                    break;

            }


        }
        return result;
    }
}

class Reader {
    Book choiceBook(Book[] arrayOfBooks) {
        Random random = new Random();
        int n = random.nextInt(arrayOfBooks.length - 1);
        return arrayOfBooks[n];
    }

    void readBook(Book book) {
        System.out.println(book);
    }

    void assessment(Book book) {
        int mark = 0;
        Random random = new Random();

            if (book.seriesNumber == 0) {
                mark = mark - random.nextInt(10);
            }
            else {
                mark = mark + book.seriesNumber;
            }

            if (book.author == null) {
                mark = mark - random.nextInt(10);
            }
            else {
                mark = mark + book.author.length();
            }

            mark = mark + book.name.length() + book.pagesNumber;

        System.out.println("Книга: " + book.name + ", оценка книги читателем: " + mark + ".");

    }
}