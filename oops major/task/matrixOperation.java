import java.util.*;
class Matrix
{
    private int row;
    private int column;
    private int mat[][];

    public Matrix(int m , int n)
    {
        this.row=m;
        this.column=n;
        mat=new int[m][n];
    }

    public Matrix(int n)
    {
        this.row=n;
        this.column=n;
        mat=new int[n][n]; 
    }
    
    public Matrix addition(Matrix b)
    {
        Matrix sum=new Matrix(row,column);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                int add=this.mat[i][j]+b.mat[i][j];
                sum.set(i, j, add);
            }
        }
        return sum;
    }

    public Matrix transpose()
    {
        Matrix Transpose=new Matrix(column, row);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                Transpose.set(j, i, mat[i][j]);
            }
        }
        return Transpose;
    }

    public void set(int a , int b , int data)
    {
        mat[a][b]=data;
    }

    public int get(int a , int b)
    {
        return mat[a][b];
    }
    
    public String toString()
    {
        String output="";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                output+=mat[i][j]+" ";
            }
        }
        return output;
    }
}

public class matrixOperation
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int r=input.nextInt();
        int c=input.nextInt();
        if(r<=0 || c<=0)
        {
            System.out.print("INVALID INPUT");
            return;
        }
        Matrix X=new Matrix(r,c);
        Matrix Y=new Matrix(r,c);

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                X.set(i, j , input.nextInt());
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                Y.set(i, j , input.nextInt());
            }
        }
        
        Matrix temp=X.addition(Y);
        System.out.println(temp.transpose());
    }
}