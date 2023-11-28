//Siqi Wen  CS202  2021/12/09
//This file contains a node class, which is derived from the class library.
//In this class, there are two data members: two references to its own type
//(left and right). There is a default constructor that set the references
//to null; there are methods that return the data members as references by
//value; there are also methods that connect the data member with the argument.



public class node_li extends library
{
    //data members
    private node_li left;
    private node_li right;

    //default constructor
    public node_li()
    {
        this.left = null;
        this.right = null;
    }


    //This function takes no argument and returns a node reference by value.
    public node_li go_left()
    {
        return this.left;
    }


    //This function takes no argument and returns a node reference by value.
    public node_li go_right()
    {
        return this.right;
    }


    //This function takes a node_li reference as an argument and
    //returns nothing. It would connect the data member with the
    //argument.
    public void connectleft(node_li connection)
    {
        this.left = connection;
    }


    //This function takes a node_li reference as an argument and
    //returns nothing. It would connect the data member with the
    //argument.
    public void connectright(node_li connection)
    {
        this.right = connection;
    }
}
