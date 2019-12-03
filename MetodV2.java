public class MetodV2 {

    public static double[] y;
    public static double[] x;
    public static double[] y2;
    public static double[] x2;
    public static double a = 0;
    public static double b = 1;
    public static double h = 0.1;
    public static double n ;

    public static void Fredgolm(){
        n = (b-a)/h;
        x = new double[(int)n+1];
        x[0] = a;
        y = new double[(int)n];
        y[0] = Simpsona(x[0],b);
        for (int i = 1; i < n-1;i++){
            x[i] = x[i-1] + h;
            y[i] = Simpsona(x[i],b);
        }

    }

    public static void Voltera(){
        n = (b-a)/h;
        x2 = new double[(int)n+1];
        x2[0] = a;
        y2 = new double[(int)n];
        y2[0] = Trapezii(1);
        for (int i = 1;i<n;i++){
            x2[i] = x2[i-1] + h;
        }
        for (int i=1;i<n;i++){
            y2[i] = Trapezii(i+1);
        }

    }

    public static double Trapezii(int n){
        return ((h/2)*(Fun(a)+Fun(b)+2*Symma(n)));
    }

    public static double Symma(double n){
        double ret=0;
        if (n == 1) return ret;
        else
        for (int i=0;i<=(n-1);i++){
            ret += Fun(x2[i]);
        }
        return ret;
    }

    public static double Fun(double t){
        return 1+Math.pow(t,2);
    }

    public static double Simpsona(double a,double b){
        return ((b-a)/6)*(fun(a) + 4*fun((a+b)/2) + fun(b));
    }

    public static double fun(double x){
        return 1+Math.exp(x);
    }
}
