import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String name;
    private String author;

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setName(String name_) {
        this.name = name_;
    }

    public void setAuthor(String author_) {
        this.author = author_;
    }

    public Book(String name_, String author_) {
        this.name = name_;
        this.author = author_;
    }

    @Override
    public String toString() {
        return name + "" + author;
    }

    @Override
    public boolean equals(Object b2) {
        if (!(b2 instanceof Book)) return false;
        if (this.name == ((Book)b2).getName() && this.author == ((Book)b2).author)
            return true;
        return false;
    }

    @Override
    public int compareTo(Book b2) {
        return this.name.compareTo(b2.name);
    }
}

class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

class BookShelf{
    private  ArrayList<Book>  Shelf;
    public BookShelf(Book magnitude){
        Shelf.add(magnitude);
}

public BookShelf(){
        Shelf = new ArrayList<Book>();
}

public void getShelf(FileWriter fileWriter) throws IOException{
        for(int k =0; k<Shelf.size(); k++){
            fileWriter.write(Shelf.get(k).toString() + "\n");
        }
}

public void finalShelf(){
        for(int k=0; k < Shelf.size(); k++){
            System.out.println(Shelf.get(k).toString());
        }
}

    public ArrayList<Book> getShelf() {
        return Shelf;
    }

    public void InsertBook (Book insert){
        Shelf.add(insert);
    }

    public void NameSort(){
        Collections.sort(Shelf);
    }

    public void AuthorSort() {
        Shelf.sort((Book lhs, Book rhs)->{
            if (lhs.getAuthor().equals(rhs.getAuthor())) {
                return lhs.getName().compareTo(rhs.getName());
            }
            else return lhs.getAuthor().compareTo(rhs.getAuthor());
        });
    }

    public int AuthorBooks(String author_){
        List<Book> books = Shelf.stream().filter(book -> book.getAuthor().equals(author_)).toList();
        for (int k = 0; k < books.size(); k++) {
            System.out.println(books.get(k));
        }
        return books.size();
    }

    public void AuthorsGroupped(){
        Map<String, List<Book>> booksByAuthor = new HashMap<>(Shelf.stream().collect(Collectors.groupingBy(Book::getAuthor)));
        for (Map.Entry<String, List<Book>> item : booksByAuthor.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    public String binarySearch(Book to_search){
        int index = Collections.binarySearch(Shelf, to_search);
        if (index > 0) return Shelf.get(index).toString();
        else return "No";
    }

    @Override public String toString(){
        StringBuilder str = new StringBuilder();
        for (int k = 0; k < Shelf.size(); k++) {
            str.append(Shelf.get(k).toString() + "\n");
        }
        return str.toString();

    }
}