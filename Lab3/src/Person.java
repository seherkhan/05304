/**
 * Created by Seher Khan on 9/12/2017.
 */
public class Person implements Comparable{
    private int ID;
    private Name name;
    private MartialStatus martialStatus;
    private Department deptName;
    private Grade grade;

    public Person(){

    }

    public Person(int ID, Name name){
        this.ID=ID;
        this.name=name;
    }
    public Person(int ID, Name name, MartialStatus martialStatus, Department deptName, Grade grade){
        this.ID=ID;
        this.name=name;
        this.martialStatus=martialStatus;
        this.deptName=deptName;
        this.grade=grade;
    }


    //The following method returns 0 whenever two Person objects are equal. That is, both name and ID are the same.
    //Recommendations:
    //- As we add more attributes, eg. martial status, etc, for two Person objects to be equal, each of those attributes must be equal
    //- the compareTo function should also help us order objects. However to tell whether something
    //  is less or greater, we need to decide on the basis of which attribute we make this comparision.
    @Override
    public int compareTo(Object o) {
        if(((Person)o).name.equals(this.name)&&((Person)o).ID==this.ID)
            return 0;
        else
            return 1; //return 1 whenever unequal
    }

    //implementation of hash function for person
    //looks up ID in a Person array and returns the first index where the Person object occurs
    public static int hashFunction(int lookID, Person[] ppl){
        for(int i=0; i<ppl.length;i++) {
            if (ppl[i].ID == lookID)
                return i;
        }
        return -1; //if ID not found
    }
}

enum MartialStatus{
    SINGLE,MARRIED,WIDOWED
}
enum Grade{
    ONE,TWO,THREE,FOUR
}
enum Department{
    MARKETING,FINANCE,HR,SALES,ADMIN
}
