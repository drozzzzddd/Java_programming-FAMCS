import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public class JSON  {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        FileOutputStream output = new FileOutputStream("book.json");

        BookShelf shelf = new BookShelf();
        shelf.InsertBook(new Book("Dead souls", "Nikolai Gogol"));
        shelf.InsertBook(new Book("Three Comrades", "Erich Maria Remarque"));
        shelf.InsertBook(new Book("Les Misérables", "Victor Hugo"));
        shelf.InsertBook(new Book("Crime and Punishment", "Fyodor Dostoyevsky "));
        shelf.InsertBook(new Book("War and Peace", "Leo Tolstoy"));
        shelf.InsertBook(new Book("Eugene Onegin", "Alexander Pushkin"));
        shelf.AuthorSort();
        objectMapper.writeValue(output, shelf);
        System.out.println(shelf.AuthorBooks("Mazanik"));
        output.close();
        Map<String, Object> one_by_one = objectMapper.readValue(new File("book.json"), Map.class);

        //System.out.println(one_by_one.get("name"));
        //System.out.println(one_by_one.get("author"));

        BookShelf books = objectMapper.readValue(new File("book.json"), BookShelf.class);
        books.finalShelf();
        System.out.println("-------------------------------------");
        books.AuthorsGroupped();

    }
}
