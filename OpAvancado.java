package main;

public class OpAvancado extends OpBasico{

    public double potencia(int num1, int num2){
        return Math.pow(num1,num2);
    }
    public double potencia(double num1, int num2){
        return Math.pow(num1, num2);
    }
    public double potencia(int num1, double num2){
        return Math.pow(num1, num2);
    }
    public double potencia(double num1, double num2){
        return Math.pow(num1, num2);
    }

    public int fatorial(int num){
        if(num==1)return 1;
        return (num*fatorial(num-1));
    }

    public double distancia(int x1, int y1, int x2, int y2){
        double d = potencia(x1-x2,2)+potencia(y1-y2,2);
        return Math.sqrt(d);
    }
}