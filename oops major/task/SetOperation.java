import java.util.*;
class Set
{
    int elements[];
    int size;

    public Set(int size)
    {
        this.size=size;
        elements=new int[size];
    }

    public int cardinality()
    {
        return size;
    }

    public Set union(Set b)
    {
        int n=this.cardinality();
        int m=b.cardinality();
        int z[]=new int[m+n];
        int i=0,j=0,k=0;

        while(i<n&&j<m)
        {
            if(this.elements[i] < b.elements[j])
            {
                z[k]=this.elements[i++];
            }
            else if(this.elements[i] > b.elements[j])
            {
                z[k]=b.elements[j++];
            }

            else
            {
                z[k]=this.elements[i];
                i++;
                j++;
            }
            k++;
        }

        while(i<n)
        {
            z[k++]=this.elements[i++];
        }

        while(j<m)
        {
            z[k++]=b.elements[j++];
        }

        Set U=new Set(k);
        for(int l=0;l<k;l++)
            U.elements[l]=z[l];
        return U;
    }

    public Set difference(Set b)
    {
        int n=this.cardinality();
        int m=b.cardinality();
        int z[]=new int[m+n];
        int i=0,j=0,k=0;

        while(i<n&&j<m)
        {
            if(this.elements[i] < b.elements[j])
            {
                z[k++]=this.elements[i++];
            }
            else if(this.elements[i] > b.elements[j])
            {
                j++;
            }
            else
            {
                i++;
                j++;
            }
        }

        while(i<n)
        {
            z[k++]=this.elements[i++];
        }

        Set D=new Set(k);
        for(int l=0;l<k;l++)
            D.elements[l]=z[l];
        return D;
    }

    public Set symDiff(Set b)
    {
        Set d1=this.difference(b);
        Set d2=b.difference(this);
        return d1.union(d2);
    }
}

class SetOperation
    {
        public static void main(String[] args)
        {
            Scanner input=new Scanner(System.in);
            int n=input.nextInt();
            int m=input.nextInt();

            if(n < 0 || m < 0)
            {
                System.out.println("INVALID INPUT");
                return;
            }

            Set A=new Set(n);
            Set B=new Set(m);

            for(int i=0;i<n;i++)
            {
                A.elements[i]=input.nextInt();
                if(i>0 && A.elements[i]<=A.elements[i-1])
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
            }

            for(int i=0;i<m;i++)
            {
                B.elements[i]=input.nextInt();
                if(i>0 && B.elements[i]<=B.elements[i-1])
                {
                    System.out.println("INVALID INPUT");
                    return;
                }
            }

            Set result=A.symDiff(B);

            for(int i=0;i<result.size;i++)
            {
                System.out.print(result.elements[i]);
                if(i!=result.size-1)
                {
                    System.out.print(" ");
                }
            }
        }
    }
