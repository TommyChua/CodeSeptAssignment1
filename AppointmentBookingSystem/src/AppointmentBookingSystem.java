/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apex
 */
public class AppointmentBookingSystem {

    private static Scanner in=new Scanner(System.in);           //scanner objext to input from user in console
    private static boolean OwnerFlag;       //owner flag user to determine either login user is owner or not
    private static String data2[];;
    /**
     * function to login user either it is Owner or customer
     * @return Login Data as String[] array
     */
    private static String[] Login()
    {
        boolean flag=false;
        String File="";
        String UserName,Password;
        
        System.out.println("Choose Login Type");
        System.out.println("1- Bussiness Owner");
        System.out.println("2- Customer");
        do
        {
            flag=false;
            switch(in.nextInt())
            {
                case 1:
                {
                    File="business.txt";
                    OwnerFlag=true;         //false due to owner entry
                    break;
                }
                case 2:
                {
                    File="customerinfo.txt";
                    OwnerFlag=false;            //false due to non owner
                    break;
                }
                default:
                {
                    flag=true;
                    System.out.println("Enter Valid Input");
                }
            }
        }
        while(flag);
        int count=1;
        do
        {
            flag=false;
            System.out.println("UserName :");
            UserName=in.next();     //get input username from user
            System.out.println("Password :");
            Password=in.next();        //get input password from user
            boolean authenticFlag=false;
            try
            {
                String line="",arr[];
                FileReader fr=new FileReader(File);
                BufferedReader br=new BufferedReader(fr);
                while((line=br.readLine())!=null)
                {
                    arr=line.split(",");        //make array of data split on , from file (each line)
                    if(arr[4].equals(UserName)) //compare username with username in file
                    {
                        if(arr[5].equals(Password))   //compare password with password in file
                        {
                            authenticFlag=true; //sucess authenticate
                            return arr;         //return data of user
                        }
                    }
                }
                if(!authenticFlag)
                {
                    if(count==3)    //check count (how many time user input wrong input
                    {
                        System.out.println("You entered Wrong Wresname or password 3 times Good Bye! ");
                        return null;
                    }
                    flag=true;
                    System.out.println("Wrong User name or passwrod Try Again!");
                    count++;    //count ++ if user enter wrong username or password
                }
            }
            catch(IOException e)    //handling excetion
            {
                System.out.println("Ther is an exception in File Handling: "+e);
                return null;
            }
        }
        while(flag);
        return null;
    }
    /**
     * function to register the new customers
     */
    private static void Register()
    {
        try
        {
            FileWriter fw=new FileWriter("customerinfo.txt",true);          //open text file in writer append mode
            BufferedWriter bw=new BufferedWriter(fw);       //gave access of file to buffer writer
            System.out.println("Enter First Name");       
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Last Name");       
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Phone");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Address");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter UserName");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Password");
            bw.write(in.next());
            bw.newLine();       //after all data inserted an endline to make file redy for next registration
            bw.close();
        }
        catch(IOException e)        //catch any exception occur durring this process
        {
            System.out.println("Ther is an exception in File Handling: "+e);
        }
    }
    /**
     * function to add new employee
     */
    private static void AddEmployee()
    {
        try
        {
            FileWriter fw=new FileWriter("employeeinfo.txt",true);          //open text file in writer append mode
            BufferedWriter bw=new BufferedWriter(fw);       //gave access of file to buffer writer
            System.out.println("Enter First Name");       
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Last Name");       
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Phone");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Address");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Availability time");
            bw.write(in.next());
            bw.newLine();       //after all data inserted an endline to make file redy for next registration
            bw.close();
        }
        catch(Exception e)
        {
             System.out.println("Ther is an exception in File Handling: "+e);
        }
    }
    public static void AddWorkingTime()
    {
        try
        {
            FileWriter fw=new FileWriter("TimeTable.txt",true);          //open text file in writer append mode
            BufferedWriter bw=new BufferedWriter(fw);       //gave access of file to buffer writer
            System.out.println("Enter Working Date i.e (02/02/2017)");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Start Time i.e (06:00)");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Am or Pm");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter End Time i.e (06:00)");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Am or Pm");
            bw.write(in.next());
            bw.write(",");
            bw.write("available");
            bw.newLine();
            bw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ShowSummaries()
    {
        try
        {
            FileReader fr=new FileReader("BookingSummaries.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void showWorkingTimeTable()
    {
        try
        {
            FileReader fr=new FileReader("employeeinfo.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            System.out.println("Name\tAvailabilityTime");
            while((line=br.readLine())!=null)
            {
                String arr[]=line.split(",");
                System.out.println(arr[0]+" "+arr[1]+"\t"+arr[4]);
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void showBookingTimeTable()
    {
        try
        {
            FileReader fr=new FileReader("TimeTable.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            System.out.println("Date\tTime Slot");
            while((line=br.readLine())!=null)
            {
                String arr[]=line.split(",");
                System.out.println(arr[0]+"\t"+arr[1]+" "+arr[2]+" to "+arr[3]+" "+arr[4]+" "+arr[5]);
            }
            br.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void BookSlot(ArrayList<String> data ,int slotNo)
    {
        try
        {
            //deleting line from timetable
            File inputFile = new File("TimeTable.txt");
            File tempFile = new File("myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = data.get(slotNo-1);
            String currentLine;

            while((currentLine = reader.readLine()) != null) 
            {
                if(currentLine.equals(lineToRemove)) 
                {
                    String newLine=currentLine.replace("available", "Un-available");
                    writer.write(newLine);
                    writer.newLine();
                }
                else
                {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
            writer.close(); 
            reader.close(); 
            inputFile.delete();
            tempFile.renameTo(inputFile);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void BookAppointment()
    {
        ArrayList<String> data=new ArrayList<>();
        try
        {
            FileReader fr=new FileReader("TimeTable.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            System.out.println("Date\tTime Slot");
            int i=1;
            while((line=br.readLine())!=null)
            {
                data.add(line);     //save list of bookings
                String arr[]=line.split(",");
                System.out.println(i+"-"+arr[0]+"\t"+arr[1]+" "+arr[2]+" to "+arr[3]+" "+arr[4]+" "+arr[5]);
                i++;
            }
            br.close();
            System.out.println("\n Select one Time in number i.e 3");
            int choice=in.nextInt();
            if(choice<=data.size())
            {
                String arr[]=data.get(choice-1).split(",");
                if(arr[5].equals("available"))
                {
                BookSlot(data,choice);
                BufferedWriter writer2 = new BufferedWriter(new FileWriter("BookingSummaries.txt",true));
                String s=data.get(choice-1);
                s=s.replace("available", "");
                s=s.replace(",", " ");
                writer2.write("Customer "+data2[0]+" "+data2[1]+" booked Appointment on "+s);
                writer2.newLine();
                System.out.println("Customer "+data2[0]+" "+data2[1]+" booked Appointment on "+s);
                writer2.close();
                }
                else
                    System.out.println("Slot Already Booked");
            }
            else
                System.out.println("Not Valid Slot Try Again!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean flag=false,terminate=false;
        while(!terminate)
        {
        System.out.println("Wellcome to Appointment Booking System");
        System.out.println("1-Login");
        System.out.println("2-Register");
        System.out.println("3-Terminate");
        do
        {
            flag=false;
            switch(in.nextInt())
            {
                case 1:
                {
                    data2=Login();
                    //if login data is owner's data
                    if(OwnerFlag)
                    {
                        boolean flag1;
                        System.out.println("Wellcome to Owner's Panel");
                        System.out.println("1- Add new Employee");
                        //real functionality will be in in part 2
                        System.out.println("2- Add Working Time/Date");     
                        System.out.println("3- Look Summaries of Bookings");
                        System.out.println("4- Show All Worker's avalaibility next week");
                        //till here
                        do
                        {
                            flag1=false;
                            switch(in.nextInt())
                            {
                                case 1:
                                {
                                    AddEmployee();  //add new employee access only available to Owner
                                    break;
                                }
                                case 2:
                                {
                                    AddWorkingTime();
                                    break;
                                }
                                case 3:
                                {
                                    ShowSummaries();
                                    break;
                                }
                                case 4:
                                {
                                    showWorkingTimeTable();
                                    break;
                                }
                            }
                        }
                        while(flag1);
                    }
                    else    //else its customer's login data
                    {
                        System.out.println("Customer Successfully Loged in");
                        for(int i=0;i<data2.length;i++)
                        {
                            System.out.println(data2[i]);
                        }
                        System.out.println("\nBooking Time Slots\n");
                        
                        boolean flag1;
                        System.out.println("Wellcome to Customer's Panel");
                        System.out.println("1- Show Booking Time Slots");
                        System.out.println("2- book appointment");   
                        do
                        {
                            flag1=false;
                            switch(in.nextInt())
                            {
                                case 1:
                                {
                                    showBookingTimeTable();
                                    break;
                                }
                                case 2:
                                {
                                    BookAppointment();
                                    break;
                                }
                                
                            }
                        }
                        while(flag1);
                        
                        
                    }
                    break;
                    
                }   
                case 2:
                {
                    //register new customer
                    Register();break;
                }
                case 3:
                {
                    terminate=true;     //terminate flag will true so it will terminate main while loop
                    break;
                }
                default:
                {
                    flag=true;
                    System.out.println("Enter Valid Input");
                }
            }
            
        }
        while(flag);    //if user enter wrong input it will try make him again 
        }
    }
    
}
