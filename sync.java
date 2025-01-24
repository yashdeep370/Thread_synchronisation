public class sync
{
    public static void main(String[] args) {
        Mydata d = new Mydata();
        Mythread1 t1 = new Mythread1(d);
        Mythread2 t2 = new Mythread2(d);
        t1.start();
        t2.start();
    }
}

class Mydata{
    public void display(String str)
    {
        synchronized (this) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
        }
        }
    }
}

class Mythread1 extends Thread
{
    Mydata d;
    public Mythread1(Mydata d)
    {
        this.d = d;
    }
    public void run()
    {
        d.display("hello world");
    }
}

class Mythread2 extends Thread
{
    Mydata d;
    public Mythread2(Mydata d)
    {
        this.d = d;
    }
    public void run()
    {
        d.display("welcome");
    }
}