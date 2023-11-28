import java.util.Scanner;


//Siqi Wen CS202 11/29/2021
//This is the Main file. In here, there is a menu that will be shown to
//the user. Based on the user's choice, specific functions will be called
//to complete specific tasks. For example: the user can enter some information
//for a conditionals object or a loops object or a function_header object and
//add this object to the LLL; the user can remove a specific node by entering
//an object's name; the user can change an object's name to a new object name;
//the user can also display all objects information in the LLL. 
//There is also an again() function to help the user check the menu again or
//do some tasks again.





public class Main 
{
    public static void main(String[] args) 
    {
        //Welcome messages and menu
        System.out.println("\n\n\nWelcome to our Syntax Translating Program!\nThis program would ask you some information and then translate the C++ syntax into Python.\n\n\n");

        Scanner one_input = new Scanner(System.in);

        Scanner task = new Scanner(System.in);
        int a_task = 0;

        syntax main_ref = null;               //for dynamic binding
        list the_list = new list();

        String compare_name = new String();
        String new_name = new String();

        node real_head = null;                //to update the head (of the LLL)

        tree BST = new tree();
        node_li real_root = null;
        String compare_term = new String();
        

        do
        {
            Scanner an_input = new Scanner(System.in);

            System.out.println("\nHere is the menu:\n\n");
            System.out.println("These options are for Program 4!!\n\n");
            System.out.println("Enter 1 - Add a conditional object into the LLL\n\n");
            System.out.println("Enter 2 - Add a loop object into the LLL\n\n");
            System.out.println("Enter 3 - Add a function header object into the LLL\n\n");
            System.out.println("Enter 4 - Retrieve an object in the LLL\n\n");
            System.out.println("Enter 5 - Remove an object in the LLL\n\n");
            System.out.println("Enter 6 - Change an object's name\n\n");
            System.out.println("Enter 7 - Display all objects in the LLL\n\n");
            System.out.println("\n\n\n\nThese options are for Program 5!!\n\n");
            System.out.println("Enter 8 - Add a new term into the dictionary.\n\n");
            System.out.println("Enter 9 - Retrieve a term in the dictionary.\n\n");
            System.out.println("Enter 10 - Remove a term in the dictionary.\n\n");
            System.out.println("Enter 11 - Remove all terms in the dictionary.\n\n");
            System.out.println("Enter 12 - Display all terms in the library.\n\n");
            System.out.println("Enter 13 - Exit\n\n");

            do
            {
                System.out.print("\n\nEnter a number(1-13): ");
                a_task = task.nextInt();
            }while(a_task < 1 || a_task > 13);

            if(a_task == 1)     //Add a conditional object into the LLL
            {
                System.out.println("\n\n\nYou are adding a conditional object into the LLL.\n");
                main_ref = new conditionals();
                main_ref.get_info(an_input);
                real_head = the_list.add(main_ref);
                System.out.println("\n\n\n\n\n\nHere is the syntax translation for the conditionals object:\n\n\n");
                main_ref.display();

                System.out.println("\n\n\n\n\n\n\nBELOW IS THE WHOLE LLL:");
                the_list.display_all(real_head);
            }

            if(a_task == 2)     //Add a loop object into the LLL
            {
                System.out.println("\n\n\nYou are adding a loop object into the LLL.\n");
                main_ref = new loops();
                main_ref.get_info(an_input);
                real_head = the_list.add(main_ref);
                System.out.println("\n\n\n\n\n\nHere is the syntax translation for the loops object:\n\n\n");
                main_ref.display();

                System.out.println("\n\n\n\n\n\n\nBELOW IS THE WHOLE LLL:");
                the_list.display_all(real_head);
            }

            if(a_task == 3)     //Add a function header object into the LLL
            {
                System.out.println("\n\n\nYou are adding a function header object into the LLL.\n");
                main_ref = new function_header();
                main_ref.get_info(an_input);
                real_head = the_list.add(main_ref);
                System.out.println("\n\n\n\n\n\nHere is the syntax translation for the function header object:\n\n\n");
                main_ref.display();

                System.out.println("\n\n\n\n\n\n\nBELOW IS THE WHOLE LLL:");
                the_list.display_all(real_head);
            }

            if(a_task == 4)     //Retrieve an object in the LLL
            {
                System.out.print("\n\n\nEnter the name of the object that you want to retrieve: ");
                compare_name = an_input.nextLine();

                if(the_list.retrieve_one(real_head, compare_name))
                {
                    System.out.println("\n\nCongrats!\nThere is a match with the object name: " + compare_name + "\n\n\n");
                }
                else
                {
                    System.out.println("\n\nSorry...There is no match with: " + compare_name + "\n\n\n");
                }
            }

            if(a_task == 5)     //Remove an object in the LLL
            {
                System.out.print("\n\n\nTo delete a node, you have to enter the object name for the node first!\n");
                System.out.print("\nEnter the object name of the node that you want to remove: ");
                compare_name = an_input.nextLine();
                if(the_list.retrieve_one(real_head, compare_name))
                {
                    System.out.println("\n\n\nCongrats! We found a match!\n");
                    real_head = the_list.remove_one_obj(real_head, compare_name);
                    System.out.println("\n\n\n\nCongrats!! We removed the object: " + compare_name + " !!\n\n\n\n");

                    System.out.println("\n\n\n\nBELOW IS THE NEW LLL:");
                    the_list.display_all(real_head);
                }
                else
                {
                    System.out.println("\n\nSorry...There is no match with: " + compare_name + "\n\n\n");
                    System.out.println("So we could not remove any node...\n\n\n\n");
                }

            }

            if(a_task == 6)     //Change an object's name
            {
                System.out.print("\n\n\nEnter the name of the object that you want to change: ");
                compare_name = an_input.nextLine();
                if(the_list.retrieve_one(real_head, compare_name))
                {
                    System.out.println("\n\n\nCongrats! We found a match!\n");
                    System.out.print("\n\n\nEnter the new name you want the object to have: ");
                    new_name = an_input.nextLine();

                    the_list.change_the_name(real_head, compare_name, new_name);
                    System.out.println("\n\n\nCongrats! We changed the object name successfully!\n\n\n");

                    System.out.println("\n\n\n\nBELOW IS THE NEW LLL:");
                    the_list.display_all(real_head);
                }
                else
                {
                    System.out.println("\n\nSorry...There is no match with: " + compare_name + "\n\n\n");
                }
            }


            if(a_task == 7)     //Display all objects in the LLL
            {
                the_list.display_all(real_head);
            }

            if(a_task == 8)     //Add a new term into the dictionary.
            {
                node_li hold = new node_li();
                hold.get_term_info(an_input);

                real_root = BST.insert(hold);
                System.out.println("\n\nHere is the tree:\n\n");
                BST.display_tree(real_root);
            }


            if(a_task == 9)     //Retrieve a term in the dictionary.
            {
                System.out.print("\n\n\nEnter the term you want to retrieve: ");
                compare_term = an_input.nextLine();

                if(BST.retrieve_tree(real_root, compare_term))
                {
                    System.out.println("\n\nCongrats!\nThere is a matching term: " + compare_term + "\n\n\n");
                }
                else
                {
                    System.out.println("\n\nSorry...There is no match with: " + compare_term + "\n\n\n");
                }
            }

            if(a_task == 10)     //Remove a term in the dictionary.
            {
                System.out.print("\nEnter the term that you want to remove: ");
                compare_term = an_input.nextLine();

                if(BST.retrieve_tree(real_root, compare_term))
                {
                    System.out.println("\n\nThere is a matching term: " + compare_term + "\n\n\n");
                    real_root = BST.remove_one(real_root, compare_term);
                    System.out.println("Congrats! We removed the term: " + compare_term + "\n\n\n");
                    if(real_root != null)
                        System.out.println("\n\nHere is the NEW TREE:\n\n");
                    BST.display_tree(real_root);
                }
                else
                {
                    System.out.println("\n\nSorry...There is no match with: " + compare_term + "\n\n\n");
                }
            }

            if(a_task == 11)     //Remove all terms in the dictionary.
            {
                if(real_root == null)
                {
                    System.out.println("Empty tree...No terms can be removed...\n\n");
                }

                real_root = BST.remove_all_tree(real_root);
                if(real_root == null)
                    System.out.println("Congrats! All terms were removed.\n\n");
            }

            if(a_task == 12)     //Display all terms in the library.
            {
                if(real_root != null)
                    System.out.println("\n\nHere is the TREE:\n\n");
                BST.display_tree(real_root);
            }


            if(a_task != 13)
                System.out.println("\n\n\nCheck the menu again?");

        }while(a_task != 13 && again(one_input));

        System.out.println("\n\n\n\n\nThank you for using our program!\nHave a great day!\n\n\n\n\n");

        task.close();
    }


    //This function asks the user if they want to do it again by
    //prompting the user for an input, true or false will be returned.
    static boolean again(Scanner input)
    {
        //Scanner input = new Scanner(System.in);
        char answer;                              //Create a character variable
        do
        {
	        System.out.print("\n\nPlease enter Y/y or N/n: ");
            answer = input.next().charAt(0);                   //Read in the user's answer.
            answer = Character.toUpperCase(answer);            //Convert the character to an uppercase letter
    	    if (answer != 'Y' && answer != 'N')
    		    System.out.println("\n\nYou entered a wrong letter. Please enter Y/y or N/n.");
        }while(answer != 'Y' && answer != 'N'); //continue until the uppercase letter is Y or N
        //input.close();
        if (answer == 'Y')                      //This function will return true if answer is Y
    	    return true;
        return false;                           //Return false if answer is N
    }
}
