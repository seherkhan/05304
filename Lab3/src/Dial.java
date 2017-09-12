public class Dial {
     private int value;

             //constr
             public Dial(){
            }

             //This method generates a random int value from the interval [0,4) for the dial
             public void spin(){
                value = (int) Math.floor(Math.random()*4);
            }

             //getter method for member variable value
             public int getValue(){
                return value;
            }

             public char getPicture(){

                        if(value==0)
                        //Return heart
                                return '\u2661';
                else if(value==1)
                        //Return diamond
                                return '\u2662';
                else if(value==2)
                        //Return spade
                                return '\u2664';
                else
                    //Return club
                            return '\u2667';
            }
 }
