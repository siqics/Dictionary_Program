import java.util.Scanner;


//Siqi Wen  CS202  2021/12/09
//This file contains a library class which is a base class to class node.
//In this class, there are three protected data members: String term;
//String meaning and String example. There are also method that will
//read in information from the user; compare the user's input for a
//term with the data member and return the value to show which one is
//bigger or if they're equal; a method to copy the data from the argument
//into the data members and also a display method to display the information
//in the data members.



public class library
{
    //data members
    protected String term;
    protected String meaning;
    protected String example;

    //default constructor
    public library()
    {
        this.term = null;
        this.meaning = null;
        this.example = null;
    }


    //This function takes a Scanner reference as an argument, passed
    //by value, nothing will be returned. It would read in information
    //from the user and store the info into the data members.
    public void get_term_info(Scanner input)
    {
        System.out.print("\nEnter the term you want to add into the library: ");
        this.term = input.nextLine();
        this.term = term.toLowerCase();
        System.out.println("\nThe term you entered WAS: " + term + "\n\n");

        System.out.print("\nEnter the meaning for this term: ");
        this.meaning = input.nextLine();

        System.out.print("\nEnter an example for this term: ");
        this.example = input.nextLine();
    }


    //This function takes a String reference as an argument, an integer
    //will be returned. It would compare the data member with the argument.
    //0 will be returned if they match, if the argument is bigger than the
    //data member, then 1 will be returned, otherwise, -1 will be returned.
    public int compare_term_str(String to_compare)
    {
        to_compare = to_compare.toLowerCase();

        if(to_compare.compareTo(term) == 0)
            return 0;
        if(to_compare.compareTo(term) > 0)
            return 1;
        else
            return -1;  
    }

    //This function takes a node_li reference as an argument, an integer
    //will be returned. It would compare the data member with the argument.
    //0 will be returned if they match, if the argument is bigger than the
    //data member, then 1 will be returned, otherwise, -1 will be returned.
    public int compare_term(node_li hold)
    {
        hold.term = (hold.term).toLowerCase();

        if((hold.term).compareTo(term) == 0)
            return 0;
        if((hold.term).compareTo(term) > 0)
            return 1;
        else
            return -1;  

    }


    //This function takes a node_li reference as an argument and returns nothing.
    //It would copy the data from the argument into the data members.
    public void copy_term(node_li hold)
    {
        this.term = hold.term;
        this.meaning = hold.meaning;
        this.example = hold.example;
    }


    //This function takes no argument and returns nothing. It will
    //display the information for a term.
    public void display_term()
    {
        if(this.term != null && this.meaning != null && this.example != null)
        {
            System.out.print("\n\n\n\nThe term is:\n" + term + "\n");
            System.out.print("\nThe meaning is:\n" + meaning + "\n");
            System.out.print("\nHere is an example:\n" + example + "\n");
        }
    }
}
