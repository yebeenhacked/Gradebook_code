import java.util.Scanner;
import java.util.HashMap;
public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        
        
        
        
        
        
        
        
        
        
        //set up optionsArray
        String[] options = new String [16];
        options[0] = "change section";
        options[1] = "add section";
        options[2] = "add student";
        options[3] = "add assignment to student";
        options[4] = "add assignment to section";
        options[5] = "set score";
        options[6] = "mark tardy";
        options[7] = "mark absent";
        options[8] = "get overall score";
        options[9] = "get overall score avg";
        options[10] = "get assignment score";
        options[11] = "get assignment score avg";
        options[12] = "get tardy count";
        options[13] = "get absent count";
        options[14] = "get contact info";
        options[15] = "exit";
        //main loop to get input:
        while(true){
            //print options
            System.out.println("Type one of the following commands:");
            
              for(int i=0; i<options.length;i++){
                System.out.println(options[i]);
            }
            
           
            String input = console.nextLine();
            
            //find out which option the selected
            int optionSelectIndex;
            for(optionSelectIndex=0; optionSelectIndex<options.length;optionSelectIndex++){
                if (options[optionSelectIndex].equalsIgnoreCase(input)){
                    break;
                }
            }

            boolean retBool =false;
            double retDouble =-1;
            String retString = "notFound";
            if(optionSelectIndex == 0){
                System.out.println("Enter a section name");
                String sectionName= console.nextLine();
                retBool=gradebook.changeSection(sectionName);
            }
            else if(optionSelectIndex == 1){
                System.out.println("Enter a section name");
                String sectionName= console.nextLine();
                retBool=gradebook.addSection(sectionName);
            }
            else if(optionSelectIndex == 2){
                System.out.println("Enter student first name:");
                String firstName= console.nextLine();
                System.out.println("Enter student last name:");
                String lastName= console.nextLine();
                System.out.println("Enter student username:");
                String userName= console.nextLine();
                long phoneNumber= getPhoneNumber();
                retBool=gradebook.addStudent(firstName,lastName,userName,phoneNumber);
            }
            else if(optionSelectIndex == 3){
                System.out.println("Enter student username:");
                String userName= console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsPossible = getUInt();
                retBool=gradebook.addAssignmentToStudent(userName,assignmentName,ptsPossible);
            }
            else if(optionSelectIndex == 4){
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsPossible = getUInt();
                retBool=gradebook.addAssignmentToSection(assignmentName,ptsPossible);
            }
            else if(optionSelectIndex == 5){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsEarned = getUInt();
                retBool=gradebook.setScore(userName,assignmentName,ptsEarned);
            }
            else if(optionSelectIndex == 6){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retBool=gradebook.markTardy(userName);
            }
            else if(optionSelectIndex == 7){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retBool=gradebook.markAbsent(userName);
            }
            else if(optionSelectIndex == 8){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getOverallScore(userName);
            }
            else if(optionSelectIndex == 9){
                retDouble=gradebook.getOverallScoreAvg();
            }
            else if(optionSelectIndex == 10){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                retDouble=gradebook.getAssignmentScorePercent(userName,assignmentName);
            }
            else if(optionSelectIndex == 11){
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                retDouble=gradebook.getAssignmentScoreAvg(assignmentName);
            }
            else if(optionSelectIndex == 12){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getTardyCount(userName);
            }
            else if(optionSelectIndex == 13){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getAbsentCount(userName);
            }
            else if(optionSelectIndex == 14){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retString=gradebook.getContactInfo(userName);
            }
            else if(optionSelectIndex == 15){
                System.out.println("exiting Gradebook Test");
                return;
            }
            else{
                System.out.println("not a valid option");
                continue;
            }
            if(retBool){
                System.out.println("action completed successfully");
            }
            else if (retDouble != -1){
                System.out.println("Result from command: " + retDouble);
            }else if (!retString.equalsIgnoreCase("notFound")){
                System.out.println("Result from command: " + retString);
            }
            else{
                System.out.println("retString: "+ retString + "retDouble: " + retDouble + "retBool: "+retBool);
                System.out.println("There was an error with the command, operation not completed");
            }
        }

    }
    static long getPhoneNumber(){
        while(true){
            try{
                System.out.println("enter a phone number including area code as a 10 digit number");
                long phoneNumber = Long.parseLong(console.nextLine());
                if(phoneNumber<1000000000l || phoneNumber>9999999999l){
                    System.out.println("not a valid phone number enter a number including area code without space or - etc");
                    continue;
                }
                return phoneNumber;
            }catch(NumberFormatException ex){
                System.out.println("not an integer");
            }
        }
    }
    static int getUInt(){
        while(true){
            try{
                System.out.println("Enter amount of points");
                int number = Integer.parseInt(console.nextLine());
                if(number<0){
                    System.out.println("not a positive integer");
                    continue;
                }
                return number;
            }catch(NumberFormatException ex){
                System.out.println("not an integer");
            }
        }
    }
}


/////////////////////////////////////////////////////////////////////////////////////
class Gradebook{
    Scanner scan  = new Scanner(System.in);
     
     HashMap<String,sec> Main = new HashMap<String,sec>();
    String csec;
     

    
    
    
    
    
    ////////////////////change section///////////////////////////////////////////////
    public boolean changeSection(String sectionName){
    
    
    if(Main.get(sectionName) == null){
       return false; //
    }else{
        csec = Main.get(sectionName).name;
        return true;
    }
    }
    //////////////////////////////add sec//////////////////////////////////////
   
    public boolean addSection(String sectionName){
      
    if(Main.size() >=6 || Main.get(sectionName) != null){
        return false; //
    }else{
        Main.put(sectionName ,new sec(sectionName));
        csec = sectionName;
        return true;
    }
    
}
    
///////////////////////////////////add student to current section///////////////////// 
    public boolean addStudent(String firstName, String lastName, String username, long phoneNumber){

        if(Main.size() == 0 || Main.get(csec).students.get(username) != null){
        return false; //
        }else{
            Main.get(csec).students.put(username , new student(firstName,lastName,username,phoneNumber));
            return true;
        }
    }

  //returns overall score (total points earned for all assignments/ total points possible) as a percentage for specified student
    //returns -1 if the student was not found or if the student did not have any assignments assigned or there are no sections.
    public double getOverallScore(String username) {
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null || Main.get(csec).students.get(username).assiments.size() == 0){
            return -1;
        }
        
        return Main.get(csec).students.get(username).ah();
        
    }
///// //returns overall score as a percentage for the current section - (the average of each students overall score.)
    //Each student should have the same weight even if they have different number of points possible
    //IE: get each student's overall score as a percentage and calculate the average percentage for the students .
    //do not count students with no assignments assigned in the average.
    //returns -1 if there were no assignments in the section or there are no sections.///
    public double getOverallScoreAvg(){
        if(Main.size() == 0 || Main.get(csec).check() == false){
            return -1;
        }
        
        return Main.get(csec).average();
    }


//////////////////////////////////////////add assiments/////////////////////////
    public boolean addAssignmentToStudent(String username, String assignmentName, int pointsPossible){
        
        
        
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null || Main.get(csec).students.get(username).assiments.get(assignmentName) != null){
        return false; //
        }else{
            Main.get(csec).students.get(username).assiments.put(assignmentName , new as(assignmentName , pointsPossible));
            return true;
        }
  
    }

  //////////////////////////////////////add////////////////////////////////////
    
    public boolean addAssignmentToSection(String assignmentName, int pointsPossible){
       if(Main.size() == 0 || Main.get(csec).students.size() == 0 || Main.get(csec).hasathing(assignmentName)) {
           return false;
       }
       Main.get(csec).addathing(assignmentName ,pointsPossible );
       return true;
       
        }
       
       
    

  ///////////////////////////////////set grade//////////////////////////
    public boolean setScore(String username, String assignmentName, int pointsEarned){
        
        
        
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null || Main.get(csec).students.get(username).assiments.get(assignmentName) == null){
        return false;//FIXME
        }else{
            
            Main.get(csec).students.get(username).assiments.get(assignmentName).had = pointsEarned;
            return true;
        }
        
        
        
    }

    //returns score on assignment specified as a percentage for the specified student in the current section
    //returns -1 if the student was not found or the student did not have an assignment with the specified assignment name or there are no sections
    public double getAssignmentScorePercent(String username, String assignmentName){
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null ||Main.get(csec).students.get(username).assiments.get(assignmentName) == null){
        return -1;
        }else{
        return Main.get(csec).students.get(username).assiments.get(assignmentName).had;
        }
    }
    

    //returns the average score as a percentage for the current section.
    //only the student with the assignment assigned to them will be counted in the average.
    //returns -1 if no student had an assignment with the specified assignment name  or there are no sections
    public double getAssignmentScoreAvg(String assignmentName){
        
        if(Main.size() == 0 || Main.get(csec).checkas(assignmentName) == false){
            return -1;
        }
        
        return Main.get(csec).averageas(assignmentName);
    
    }

    //adds 1 to the specified student's tardy count.
    //returns: true if successful, false if the student was not found in the current section  or there are no sections
    public boolean markTardy(String username) {
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null){
        return false;//
        }else{
            Main.get(csec).students.get(username).tards++;
            return true;
        }
    }

    //adds 1 to the specified student's absent count.
    //returns: true if successful, false if the student was not found in the current section  or there are no sections
    public boolean markAbsent(String username){
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null){
        return false;//
        }else{
            Main.get(csec).students.get(username).abs++;
            return true;
        }
    }

    //returns the student tardy count for the specified student, it returns -1 if the student was not found  or there are no sections
    public int getTardyCount(String username){
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null){
        return -1;//
        }else{
            return Main.get(csec).students.get(username).tards;
             
        }
    }

    //returns the student tardy count for the specified student, it returns -1 if the student was not found  or there are no sections
    public int getAbsentCount(String username){
        if(Main.size() == 0 || Main.get(csec).students.get(username) == null){
        return -1;//
        }else{
            return Main.get(csec).students.get(username).abs;
             
        }
    }
	
	//returns string in the following format: "username:dbaker,firstName:David,lastName:Baker,phoneNumber:5172441344"
	//returns "notFound" if the username was not found
	String getContactInfo(String username){
		return "notFound"; //FIXME
	}	
    
}

////////////////////////////////end of grade book////////////////////////////////////

class as{
    int possible;
    int had = 0;
    String name;
    

as(String x,int y){
    this.name = x;
    this.possible = y;
    
}
    
    
}

///////////////////////////////end of assiemnts////////////////////////////////////////

class student{
    String name;
    String lastname;
    String username;
    long phone;
    int tards= 0 ;
    int abs = 0;
    HashMap<String, as> assiments = new HashMap<String, as>();
    
    
    
    student(String a, String b, String c, long d){
        this.name = a;
        this.lastname = b;
        this.username = c;
        this.phone = d;
        
        
    }
    
    boolean hasas(String name){
        for(String i: assiments.keySet()){
            if(assiments.get(i).name.equals(name)){
                return true;
            }
            
        }
        return false;
    }
    
    double ah(){
        double a = 0;
        double b = 0;
        for(String i: assiments.keySet()){
            a = a + assiments.get(i).had;
            b = b + assiments.get(i).possible;
        }
        return (a/b)*100;
    }
    
    double ahas(String name){
        double a = 0;
        double b = 0;
        
            a = a + assiments.get(name).had;
            b = b + assiments.get(name).possible;
        
        return (a/b)*100;
    }
} 


///////////////////////////////////end of student/////////////////////////////////////

class sec{
    sec(String x){
        this.name = x;
    }
    
    String name;
    
    
    HashMap<String, student> students = new HashMap<String, student>();
    
    
    boolean hasathing(String name){
        for(String i: students.keySet()){
            if(students.get(i).hasas(name)){
                return true;
            }
            
        }
        return false;
    }
    
    boolean addathing(String name , int points){
        for(String i: students.keySet()){
            students.get(i).assiments.put(name , new as(name , points));
                
            
            
        }
       return true;
    }
    boolean check(){
        for(String i: students.keySet()){
            if(students.get(i).assiments.size() > 0){
                return true;
            }
        }
        return false;
    }
        
        boolean checkas(String name){
        for(String i: students.keySet()){
            if(students.get(i).assiments.get(name) != null){
                return true;
            }
        }
        
       return false;
    }
    
    
    double average(){
        double a = 0;
        double b = 0;
        for(String i: students.keySet()){
            if(students.get(i).assiments.size() > 0 ){
                a = a + students.get(i).ah();
                b++;
            }
        }
       return a/b;
    }
    double averageas(String name){
        double a = 0;
        double b = 0;
        for(String i: students.keySet()){
            if(students.get(i).assiments.size() > 0 && students.get(i).assiments.get(name) != null){
                a = a + students.get(i).ahas(name);
                b++;
            }
        }
       return a/b;
    }
    
    
}



/*change section
am
add section
pm
change section
am
add section
pm
add section
am
add section
section3
add section
section4
add section
section5
add section
section6
add section
section7
add section
section4
change section
section5
change section
am
add section
pm2
change section
bob
exit
*/
