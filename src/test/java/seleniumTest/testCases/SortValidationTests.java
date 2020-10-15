package seleniumTest.testCases;

public class SortValidationTests {

    public static void main(String []args){
        int a [] = {5,2,3,4,5,6,7,8,9,10};
        int b[]= {7,9,8,7,6,5,4,3,2,1};
        boolean result = SortAsc(a);
        if (result ==true)
            System.out.println("Correct result");
        else if (!result)
            System.out.println("Wrong result");
        boolean result1= SortDesc(b);
        if (result1 ==true)
            System.out.println("Correct result1");
        else if(!result1)
            System.out.println("Wrong result1");
        int c = max(a);
            System.out.println("Max number is: "+ c);
        int d = min(a);
        System.out.println("Min number is: "+d);
    }
    public static boolean SortAsc(int a[]){
        boolean result=true;
        for (int index=0; index < a.length; index++)
        {
            if (a[index]>a[index+1])
                result= false;
            break;
        }
        return result;
    }
    public static boolean SortDesc(int a[]){
        boolean result=true;
        for (int i=0; i < a.length; i++)
        {
            if (a[i]<a[i+1])
                result = false;
            break;
        }
        return result;
    }
    public static int max(int a[]){
        int max=a[0];
        for (int i=0; i<a.length; i++)
        {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }
    public static int min(int a[]){
        int min=a[0];
        for (int i=0; i<a.length; i++)
        {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }

}
