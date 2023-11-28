//Siqi Wen  CS202  2021/12/09
//This file contains a tree class. In this class, there is one data member,
//which is a reference to the node_li type. There is a default constructor
//that sets the data member to null; there are methods: insert; retrieve;
//remove_one; remove_all and display_all in this class, and all of these
//methods will need to call other recursive functions to complete the
//mission. For remove_one function, there is a function to help with
//a special case(when the matching node has two children), then we need
//to use this function to find the in-order successor so that we can
//delete this node and still have a binary search tree.



public class tree
{
    //data member
    private node_li root;

    //default constructor
    public tree()
    {
        this.root = null;
    }


    //This function takes a node_li reference as an argument and returns
    //a node_li reference by value. It would insert a new node that
    //contains a new term into the BST.
    public node_li insert(node_li to_add_intree)
    {
        if(root == null)
        {
            root = to_add_intree;
            return root;
        }
        return insert(root, to_add_intree);
    }


    //This function takes two node_li references as arguments and returns
    //a node_li reference by value. It would insert a new node that
    //contains a new term into the BST based on it's value. It's a
    //recursive function.
    private node_li insert(node_li root, node_li to_add_intree)
    {
        if(root == null)
        {
            root = to_add_intree;
            return root;
        }
        if(root.compare_term(to_add_intree) == -1)
            root.connectleft(insert(root.go_left(), to_add_intree));
        else
            root.connectright(insert(root.go_right(), to_add_intree));
        return root;
    }


    //This function takes a node_li reference and a String reference
    //as arguments, a boolean value will be returned. It would look
    //for a matching term in the tree, ig there's a matching term,
    //true will be return; otherwise, false will be returned.
    public boolean retrieve_tree(node_li real_root, String a_term)
    {
        root = real_root;
        if(root == null)
        {
            System.out.println("Empty tree...No terms can be retrieved...\n\n");
            return false;
        }
        else
            return retrieve_tree_recur(root, a_term);
    }


    //This function takes a node_li reference and a String reference
    //as arguments, a boolean value will be returned. It would look
    //for a matching term in the tree, ig there's a matching term,
    //true will be return; otherwise, false will be returned.
    private boolean retrieve_tree_recur(node_li root, String a_term)
    {
        boolean match = false;
        if(root == null)
        {
            return match;
        }
        if(root.compare_term_str(a_term) == 0)
        {
            match = true;
            return match;
        }
        if(root.compare_term_str(a_term) == 1)
            return retrieve_tree_recur(root.go_right(), a_term);
        else
            return retrieve_tree_recur(root.go_left(), a_term);
    }


    //This function takes a node_li reference and a String reference
    //as arguments, it would return a node_li reference. This function
    //is for removing one item in the bst.
    public node_li remove_one(node_li real_root, String a_term)
    {
        root = real_root;
        return remove_one_recur(root, a_term);
    }


    //This function takes a node_li reference and a String reference
    //as arguments, it would return a node_li reference. This function
    //is for removing one item in the bst. This is a recursive function.
    private node_li remove_one_recur(node_li root, String a_term)
    {
        if(root.compare_term_str(a_term) == 0)
        {
            if(root.go_left() == null && root.go_right() == null)
            {
                root = null;
                return root;
            }
            else if(root.go_right() == null && root.go_left() != null)
            {
                root = root.go_left();
                return root;
            }
            else if(root.go_right() != null && root.go_left() == null)
            {
                root = root.go_right();
                return root;
            }
            else
            {
                return find_ios(root.go_right(), root);
            }
        }
        if(root.compare_term_str(a_term) == 1)
            root.connectright(remove_one_recur(root.go_right(), a_term));
        else
            root.connectleft(remove_one_recur(root.go_left(), a_term));
        return root;
    }


    //This function takes two node_li references and returns one node_li
    //reference. It's purpose is to help us find the in-order successor
    //for the node we want to delete when the matching node has two children.
    private node_li find_ios(node_li temp, node_li ori_root)
    {
        if(temp.go_left() == null)
        {
            ori_root.copy_term(temp);
            temp = temp.go_right();
            return temp;
        }
        temp.connectleft(find_ios(temp.go_left(), ori_root));
        return temp;
    }


    //This function takes a node_li reference as an argument and returns
    //nothing. It would display the elements in the tree.
    public void display_tree(node_li real_root)
    {
        root = real_root;

        if(root == null)
        {
            System.out.println("Empty tree...No terms can be displayed...\n\n");
        }
        else
            display_tree_recur(root);
    }


    //This function takes a node_li reference as an argument and returns
    //nothing. It would display the elements in the tree. It's a recursive
    //function.
    private void display_tree_recur(node_li root)
    {
        if(root == null)
            return;

        display_tree_recur(root.go_left());
        root.display_term();
        display_tree_recur(root.go_right());
    }


    //This function takes a node_li reference as an argument and returns a node_li
    //reference by value. It will remove all nodes in the tree.
    public node_li remove_all_tree(node_li real_root)
    {
        root = real_root;
        return remove_all_tree_recur(root);
    }


    //This function takes a node_li reference as an argument and returns a node_li
    //reference by value. It will remove all nodes in the tree. It's a recursive
    //function.
    private node_li remove_all_tree_recur(node_li root)
    {
        if(root == null)
            return null;

        root.connectleft(remove_all_tree_recur(root.go_left()));
        root.connectright(remove_all_tree_recur(root.go_right()));

        root = null;
        return root;
    }
}