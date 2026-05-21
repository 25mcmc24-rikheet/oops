import java.util.*;

class Element<T>
{
    int row;
    int col;
    T value;

    Element(int row,int col,T value)
    {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

class SparseMatrix<T>
{
    int rows;
    int cols;

    ArrayList<Element<T>> list;

    SparseMatrix(int rows,int cols)
    {
        this.rows = rows;
        this.cols = cols;

        list = new ArrayList<>();
    }

    void addElement(int row,int col,T value)
    {
        list.add(new Element<>(row,col,value));
    }

    void displaySparse()
    {
        System.out.println("Row Col Value");

        for(Element<T> e : list)
        {
            System.out.println(
                e.row + " " +
                e.col + " " +
                e.value);
        }
    }
}

public class sparseMatrix
{
    public static void main(String[] args)
    {
        SparseMatrix<Integer> s =
            new SparseMatrix<>(3,3);

        s.addElement(0,0,5);
        s.addElement(0,2,8);
        s.addElement(1,1,3);

        s.displaySparse();
    }
}