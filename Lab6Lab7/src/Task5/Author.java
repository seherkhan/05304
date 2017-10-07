package Task5;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Author {
    private String name;
    private String email;
    public Author(String name, String email){
        this.name=name;
        this.email=email;
    }

    public String toString(){
        return "Author[name="+name+",email="+email+"]";
    }
}
