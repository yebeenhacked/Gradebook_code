import java.util.*;

public class Main {  
  public static void main(String args[]) { 
    Scanner scan = new Scanner(System.in);
    hold a = new hold();
    
    
    
    
    
    
    
    
    
    System.out.println("pick an option or a shops");
    /////////////////////////////////////////////////////////////////////
    boolean t = true;
    while(t){
    
    System.out.println("current store:" + a.cs);
    System.out.println("add shops");
    System.out.println("change shop");
    System.out.println("add copons");
    System.out.println("SHOPS:");
    for(String i : a.shops.keySet()){
    System.out.println(i);
   
    }
    System.out.println("or exit");
    ////////////////////////////////////start testing inppus.//////////////////////
    String input = scan.nextLine();
   
    ////////////////////////////end of add shops///////////////////////////////////
    ////////////////////////////chagen cs .///////////////////////////////////
    
    switch(input){
        //////////////////////////////add shops/////////////////////////
        case "add shops":
            while(true){
        String input2 = scan.nextLine();
        if(a.addshop(input2)){
            a.addshop(input2);
            break;
        }else if(input2.equals("exit")){
            break;
            
        }else{
            System.out.println("Sorry, but you already have that shop. Enter another shop name or type exit" );
        }
        
        }
        break;
        /////////////////////////////////change cs/////////////////////
        case "change shop":
            String input3 = scan.nextLine();
            if(a.changeshops(input3)){
                a.changeshops(input3);
            }else{
                System.out.println("Sorry, but that shops does not exsist in our data base");
            }
            break;
        
        
        
        
        
        
        
        
      case "exit":
          t = false;
    }
    
    
    
    
    
    
    
    
    }
    //////////////////////////////////////////////////////
    
  } 
}

class hold{
    
    HashMap<String, shop> shops = new HashMap<String, shop>();
    String cs; 
    Scanner scan = new Scanner(System.in);
    
    /////////////////////////////////////test/////////////////////////////
    boolean test(HashMap a){
        if(a.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    /////////////////////////////////////add shop//////////////////////////////
    boolean addshop(String in){
        if(shops.containsKey(in) == true){
        return false;
        }else{
        shops.put(in, new shop(in));
        cs = in;
        return true;
        }
    }
    
    ////////////////////////////////change shops/////////////////////////////
    boolean changeshops(String in){
        if(shops.containsKey(in) == true){
            cs = in;
            return true;
        }else{
           return false; 
        }
        
    }
    //////////////////////////add copones//////////////////////////
    boolean addco(){
        System.out.println("name of copon");
        String name = scan.nextLine();
        if(shops.get(cs).coponlist.containsKey(name)){
            System.out.println("copon already exsists");
            return false;
        }
        String dis;
        System.out.println("name of item copon for");
        String item = scan.nextLine();
        
        int line = 0;
        
        int price = 0;
        System.out.println("percent off in decimal, if not percent of type 0");
        int effect = scan.nextInt();
        scan.nextLine();
        if(effect ==0){
        System.out.println("discrption of what copon does");
         dis = scan.nextLine();
        }else{
         dis = "";
        }
        System.out.println("enter year exspires");
        int year;
        System.out.println("enter month exspiers");
        String month = scan.nextLine();
        System.out.println("enter day exspires");
        int day;
        
        System.out.println("shops it is used at");
        String shops = scan.nextLine();  
        
        
        
        
        return true;
    }
    
    
}


class shop{
    
    shop(String name){
        this.name = name;
        
    }
    
HashMap<String, copons> coponlist = new HashMap<String, copons>();
HashMap<String, sales> saleslist = new HashMap<String, sales>();
String name;

void applysaleco(copons a){
    if(a.effect == 0){
     System.out.println(a.dis);
    }else{
        System.out.println(a.price * a.effect);
        
    }
}

void printm(){
    for (String i : saleslist.keySet()){
        System.out.println(saleslist.get(i).dis);
    }
    for (String i : coponlist.keySet()){
        System.out.println(coponlist.get(i).dis);
    }
    
    
}



}

class copons{

    copons( int line , int price, int effect, String dis, int year, String month, int day, String name, String shops , String item){
    this.item = item;
    this.price= price;
    this.effect = effect;
    this.dis = dis;
    this.year = year;
    this.month = month;
    this.day = day;
    this.name = name;
    this.shops = shops; 
    }
String item;
int line;
int price;
int effect = 000;
String dis;
int year;
String month;
int day;
String name;
String shops;  

}

class sales{
        
        sales(int line, int price, int effect, String dis, int year, String month, int day, String name, String shops){
    this.line = line;
    this.price= price;
    this.effect = effect;
    this.dis = dis;
    this.year = year;
    this.month = month;
    this.day = day;
    this.name = name;
    this.shops = shops; 
    }


int line;
int price;
int effect = 000;
String dis;
int year;
String month;
int day;
String name;
String shops;  
 
}
  
