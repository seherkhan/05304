import java.util.List;

/**
 * Created by Seher Khan on 9/12/2017.
 */
public class Name{
    String FirstName;
    String MiddleIni;
    String LastName;

    public Name(String f, String m, String l){
        FirstName=f;
        MiddleIni=m;
        LastName=l;
    }


    public void flFormat(){
        String str="";
        str+=FirstName+" "+LastName;
        System.out.print(str);
    }
    public void lfmFormat(){
        String str="";
        str+=LastName+", "+FirstName+", "+MiddleIni+".";
        System.out.print(str);
    }
    public void fmlFormat(){
        String str="";
        str+=FirstName+" "+MiddleIni+". "+LastName;
        System.out.print(str);
    }


    public boolean equals(Name o) {
        //String thisName=this.FirstName+" "+this.MiddleIni+". "+this.LastName;
        //String otherName=o.FirstName+" "+o.MiddleIni+". "+o.LastName;
        if(this.FirstName.equals(o.FirstName)&&this.MiddleIni.equals(o.MiddleIni)&&this.LastName.equals(o.LastName))
            return true;
        return false;
    }

    public String hashFunction(Name[] names, int ID){
        for(int i=0; i<names.length;i++){
            //if(names[0].)

        }
        return "";
    }
}

