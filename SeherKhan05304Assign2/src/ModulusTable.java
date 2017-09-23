/**
 * Created by Seher Khan 05304 on 9/16/2017 as a part of Assignment 2, Question 3.
 * This class is used to create objects that consist of two integers (n and m). The object created by this class represents the m*m modulo-n multiplication table.
 */
public class ModulusTable {
    private int modulus; //n
    private int tableSize; //m

    /**
     * This constructor creates a ModulusTable object by taking two int arguments
     * Pre-conditions: mod>=1, tabSize>=1
     * Post-conditions: an object of type Multiplication exists in memory
     * @param mod is represents the n in mod-n
     * @param tabSize is represents the number up to which multiplication has to be done
     */
    public ModulusTable(int mod, int tabSize){
        this.modulus=mod;
        this.tableSize=tabSize;
    }

    /**
     * This method overrides the toString() method of the object class. It is used to display the m*m modulo-n multiplication table that this ModulusTable object represents.
     * Preconditions: calling object is of type Modulus Table and not null
     * Postconditions: string exists in memory which represents the m*m mod-n multiplication table
     * @return String representation of the object
     * */
    public String toString(){
        String str=""; //[0][0]=""
        for(int i=0; i<=tableSize;i++){
            for(int j=0; j<=tableSize;j++){
                if(i==0&&j==0)
                    str+=" ";
                else if (i==0)
                    str+=j;
                else if (j==0)
                    str+=i;
                else
                    str+=(i*j%modulus);

                if(j==0&&i>=10||i==0&&j>=10)
                    str+="  ";
                else
                    str+="   ";
                }
            str+="\n";
        }
        return str;
    }
}
