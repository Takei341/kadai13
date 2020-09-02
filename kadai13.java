import java.util.ArrayList;

public class kadai13 {
    public static void main(String[] args) {
        Suuchi s = new Suuchi();
        Observer o1 = new NishinHyouji();
        Observer o2 = new JyuurokushinHyouji();

        s.attach(o1);
        s.attach(o2);
        int i = 0;
        while (i<100){
            s.putValue(i);
            i+=(int)(Math.random()*30)-10;
        }
    }
}

abstract class Subject{
    public ArrayList<Observer> observers;

    Subject(){
        observers = new ArrayList <Observer>();
    }
    public void attach(Observer o){
        observers.add(o);
    }
    public void detach(Observer o){
        observers.remove(o);
    }
    public void tsuuchi(){
        for(Observer observer:observers){
            observer.update(this);
        }
    }
}

class Suuchi extends Subject{
    boolean suuchiState;
    int atai;

    public boolean getState(){
        return suuchiState;
    }
    public void putValue(int atai){
        if(atai>this.atai){
            this.atai = atai;
            this.tsuuchi();
        } else {System.out.println("確認用メッセージ：更新していません");}
    }
    public int getValue(){
        return atai;
    }
}

interface Observer{
    public void update(Subject s);
}

class NishinHyouji implements Observer{
    public void update(Subject s){
        print(((Suuchi)s).getValue());
    }

    private void print(int n){
        System.out.println(n+"を2進数で表示します");
    }
}

class JyuurokushinHyouji implements Observer{
    public void update(Subject s){
        print(((Suuchi)s).getValue());
    }

    private void print(int n){
        System.out.println(n+"を16進数で表示します");
    }
}