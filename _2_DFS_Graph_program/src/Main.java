import java.util.*;

public class Main
{
    static void input(int[][] a, int  n)
    {
        Scanner ob = new Scanner(System.in);
        int i, j;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                a[i][j] = ob.nextInt();
    }

    static void setNeg(int[] a, int n)
    {
        int i;
        for(i=0;i<n;i++)
            a[i] = -1;
    }

    static int check(int element, int[] visited, int n)
    {
        int i;
        for(i=0;i<n;i++)
            if(visited[i] == element)
                return 1;
        return 0;
    }

    static void findDFS(int[][] a, int[] stack, int[] visited, int n)
    {
        int index = 0, j, flag, k=0;
        stack[index] = 0;
        while(index != -1)
        {
            flag = check(stack[index], visited, n);
            if(flag == 0){
                visited[k++] = stack[index];
                stack[index--] = -1;       //pop
                for(j=n-1;j>=0;j--){
                    flag = check(j, visited, n);
                    if(a[visited[k-1]][j] == 1 && flag == 0)
                            stack[++index] = j;     //push
                }
            }
            else{
                stack[index--] = -1;      //pop
            }
        }
    }

    static void print(int[] visited, int n)
    {
        int i;
        System.out.println("DFS Elements Are: ");
        for(i=0;i<n;i++)
        {
            char m = (char)(visited[i] + 65);
            System.out.print(m +" ");
        }
    }

    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        int[][] a;
        int[] stack, visited;
        int i = 0, n;
        System.out.print("Enter Size of Stack: ");
        n = ob.nextInt();
        stack = new int[n*n];
        visited = new int[n];
        a = new int[n][n];
        System.out.println("Enter Graph Statistics: ");
        input(a, n);
        setNeg(visited, n);
        setNeg(stack, n);
        findDFS(a, stack, visited, n);
        print(visited, n);
    }
}