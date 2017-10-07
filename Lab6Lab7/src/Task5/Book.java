package Task5;

import java.util.Scanner;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Book {
    private String title;
    private Author author;
    //private AuthorInner author; //for part 2 of task 5
    private double price;

    public Book(String title, double price){
        this.title=title;
        this.price=price;

        Scanner s= new Scanner(System.in);
        System.out.println("Enter name of author: ");
        String authorName=s.nextLine();
        System.out.println("Enter email of author: ");
        String authorEmail=s.nextLine();
        author=new Author(authorName,authorEmail);
        //author=new AuthorInner(authorName,authorEmail); //for part 2 of task 5
    }

    public String toString(){
        return "Book[name="+title+","+author+"],price="+price+"]";
    }
    /*
    //for part 2 of task 5
    public class AuthorInner {
        private String name;
        private String email;
        public AuthorInner(String name, String email){
            this.name=name;
            this.email=email;
        }

        public String toString(){
            return "Author[name="+name+",email="+email+"]";
        }
    }
    */
}
