import java.io.*;//importing java file
import java.util.Scanner;//importing java scanner to take input
/**
 * Write a description of class Files here.
 *
 * @author (Sujal)
 * @version (a version number or a date)
 */
public class Files
{
    private static final String crypt1 = "cipherabdfgjk";
    private static final String crypt2 = "lmnoqstuvwxyz";

    //creating a runFileTest method which can store menu method
    public void runFilesTests(){
        
        Menu();// storing menu method
        
        
    }
    //creating main method to run the code
    public static void main(String[] args) {
        System.out.println('\u000c');//clear all previous text
        //creating instance of class and displaying different method
        Files m = new Files();
        m.runFilesTests();
    }
    /*
     * creating a read Form File method which will read a text from file and 
     * display them on a screen also method will read that file which user
     * want to. So user have to give a name of file 
     */
    public void readFromFile() {  
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        System.out.println("Enter file name. eg lol");
        Scanner s = new Scanner(System.in);
        String fileName = s.nextLine();
        String Name = fileName + ".txt";
        System.out.println("Reading file :- "+ Name);
        try
        {
            fileReader = new FileReader(Name);
            bufferedReader = new BufferedReader(fileReader);
            String nextLine = bufferedReader.readLine();
            while (nextLine != null )
            {
                System.out.println(nextLine);
                nextLine = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file was not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading from file: " + e);
        }
        finally{
            if (bufferedReader != null){
                try{
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                }
            }
        }
    }
    /*
     * creating write to a file method in which user have to type string
     * and that will be written on a file. 
     */
    public void writeFile() {
         FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        boolean valid = false;
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Write a text that you want to write on Wirtetxt file. OR press space when you are done with file");
        Scanner s = new Scanner(System.in);
        String myString = s.nextLine();
        try
        {
            outputStream = new FileOutputStream("Writetxt.txt");
            printWriter = new PrintWriter(outputStream);
            do{
                printWriter.println(myString);
                myString = s.nextLine();
                if(!myString.isEmpty()){
                    valid = false;
                }
                else if (myString.isEmpty()){
                    valid = true;
                }
            }while(!valid);
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            if (printWriter != null){
                printWriter.close();
            }
        }
    }
    /*
     * creating a method that will de-code a file and show to user and copy file to another
     */
       public void hacking(){
        //creating filereader instance and initialize value null
        FileReader fileReader = null;
        //creating bufferreader instance and initialize value null
        BufferedReader bufferedReader = null;
        //creating fileoutputstream instance and initialize value null
        FileOutputStream outputStream2 = null;
        //creating printwriter instance and initialize value null
        PrintWriter printWriter2 = null;
        //using try catch and finally for reading a file and decipher it and show to user and copy to another file 
        try{
            //reading a file
            fileReader = new FileReader("mystery.txt");
            bufferedReader = new BufferedReader(fileReader);
            //puting file value in string
            String nextLine = bufferedReader.readLine();
            //printing on another file
            outputStream2 = new FileOutputStream("deciphered.txt");
            printWriter2 = new PrintWriter(outputStream2);
            //using while loop which end when line is null
            while(nextLine != null ){
                //using cipherDecipher method to desipher a string and show to user
                String nextLineD = cipherDecipherString((nextLine));
                System.out.println(nextLineD);
                nextLine = bufferedReader.readLine();
                printWriter2.println(nextLineD);
            }
            }
            catch (IOException e)
            {
                //iff eroor print something + error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
            }
            finally
            {
                //using if statment if line is empty close file 
               if (printWriter2 != null){
               printWriter2.close();
               }
            }
            
            
        System.out.println("");
    }
    
    private static String cipherDecipherString(String text)
    {
    // declare variables we need
    int i, j;
    boolean found = false;
    String temp="" ; // empty String to hold converted text

    for (i = 0; i < text.length(); i++) // look at every character in text
    {
        found = false;
        if ((j = crypt1.indexOf(text.charAt(i))) > -1) // is char in crypt1?
        {           
            found = true; // yes!
            temp = temp + crypt2.charAt(j); // add the cipher character to temp
        } 
        else if ((j = crypt2.indexOf(text.charAt(i))) > -1) // and so on
        {
            found = true;
            temp = temp + crypt1.charAt(j);
        }

        if (! found) // to deal with cases where char is NOT in crypt2 or 2
        {
            temp = temp + text.charAt(i); // just copy across the character
        }
    }
    return temp;
    }
    /*
     * creating a method which read a file and split text and integer and
     * printing average and text and copy it to another file too.
     */
    public void detail(){
        FileReader fileReader = null;//creating filereader instance and initialize value null
        BufferedReader bufferedReader = null;//creating bufferreader instance and initialize value null
        FileOutputStream outputStream2 = null;//creating fileoutputsream instance and initialize value null
        PrintWriter printWriter2 = null;//creating Printwriter instance and initialize value null
        //declearing variable
        float average = 0.0f;
        int sum = 0;
        // using try to catch error
        try{
            //reading file
            fileReader = new FileReader("details.txt");
            bufferedReader = new BufferedReader(fileReader);
            // storing line in string variable
            String nextLine = bufferedReader.readLine();
            //copying file and pasting to another
            outputStream2 = new FileOutputStream("detail copy file.txt");
            printWriter2 = new PrintWriter(outputStream2);
            //using while loop which end when tere is no line
            while(nextLine != null ){
                String[] list = nextLine.split(" ");//using split method for spliting term after every space
                //puting value of line in variable
                String name = list[0];
                String FamilyName = list[1];
                int Score = Integer.parseInt(list[2]);
                int Score2 = Integer.parseInt(list[3]);
                int Score3= Integer.parseInt(list[4]);
                int Score4 = Integer.parseInt(list[5]);
                int Score5 = Integer.parseInt(list[6]);;
                //adding every integer
                sum = Score + Score2 + Score3 + Score4 + Score5;
                //doing average of interger in float
                average = sum/5.0f;
                //printing to file and showing to user
                nextLine = bufferedReader.readLine();
                System.out.print(FamilyName + " , ");
                System.out.print(name + ": Average score is " + average +"\n");
                printWriter2.print(FamilyName + " , ");
                printWriter2.print(name + ": Average score is "+ average +"\n");
                
            }
            }
        catch (IOException e)
            {
                //if error print something
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
            }
        finally
            {
               //using if statment if line is empty close file  
               if (printWriter2 != null){
               printWriter2.close();
               }
        }
            System.out.println("");//printing a empty line
    }
    /*
     * creating a method which will confirm file exist and can be read
     */
    public void fileExist(){
    System.out.println("Enter file name. eg lol");//printing some line
    //making file name equals to user input and storing in a variable
    Scanner s = new Scanner(System.in);
    String name = s.next() + ".txt";
    File file = new File(name);
    boolean valid = false;//declaring boolean
    //using if statement which will show file exist or not if true then it can be read or no and showing result to user
    if (file.exists())
        {
            System.out.println("file exist ");
            valid = true ;
            if (file.canRead())
        {
            System.out.println("file can be read ");
            valid = true;
        }
        else
        {
            System.out.println("file can not be read ");
            valid = false;
            return;
        }
        }
        else
        {
            System.out.println("File does not exist ");
            valid = false;
            return;
        } 
        //empty line
        System.out.println("");
    }
    /*
     * creating a method which will take a 2d array and past in a text file 
     */
    public void arrayFile(){
        //creating 2d array
        int[][] twoD = {{1,2,3,4,5,6},
                        {7,8,9,0,1,2},
                        {3,4,5,6,7,8},
                        {9,0,1,2,3,4},
                        {5,6,7,8,9,0}, 
                        {1,4,2,7,4,2}}; 

        FileOutputStream outputStream = null;//creating fileOutputStrem instance and initialize value null
        PrintWriter printWriter = null;//creating PrintWriter instance and initialize value null
        //using try catch and finally to transfer array to file
        try
        {
            outputStream = new FileOutputStream("Array.txt");//pasting to a file
            printWriter = new PrintWriter(outputStream); 
            //using for loop to read integer
            for (int i=0; i<twoD.length; i++)
            {
                for(int j = 0 ; j<twoD.length; j++){
                    printWriter.print(twoD[i][j] + ",");//printing to file
                    
                }
            }
            System.out.println("Array has been written on Array.txt file"); //printing something  
        }
        catch (IOException e)
        {
            // if error then print something + error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
           //using if statment if line is empty close file
           if (printWriter != null)
              printWriter.close();
        }
         
        System.out.println("");//epmty line
    }
    
    public void readObject(){
        //creating filereader instance and initialize value null
        FileReader fileReader = null;
        //creating bufferedreader instance and initialize value null
        BufferedReader bufferedReader = null;
        //creating fileOutputStream instance and initialize value null
        FileOutputStream outputStream = null;
        //creating 2nd fileOutputStream instance and initialize value null
        FileOutputStream outputStream2 = null;
        //creating printwriter instance and initialize value null
        PrintWriter printWriter2 = null;
        //creating 2nd printwriter instance and initialize value null
        PrintWriter printWriter = null;
        //using try and catch method to create a file and print some line
        try{  
            //writing on a file
            outputStream = new FileOutputStream("DVD.txt");
            printWriter = new PrintWriter(outputStream);
            //text that is to be written to file 
            printWriter.println("DVD Title  ");
            printWriter.println("Director name ");
            printWriter.println("Runtime ");
            }
        catch (IOException e)
            {
                //if error print something
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
            }
        finally
            {
               //using if statment if line is empty close file  
               if (printWriter != null){
               printWriter.close();
               }
        }
                try{
            //writing on a file
            fileReader = new FileReader("DVD.txt");
            bufferedReader = new BufferedReader(fileReader);
            //reading a file
            String nextLine = bufferedReader.readLine();
            outputStream2 = new FileOutputStream("DVD.txt");
            printWriter2 = new PrintWriter(outputStream2);
            //using while loop which end when next line is empty
            while(nextLine != null ){
                //printing on file and showing user file text
                System.out.println(nextLine);
                String list = nextLine;
                Scanner s = new Scanner(System.in);
                String sac = s.nextLine();
                String full = list + " = " + sac;
                
                System.out.println(full);
                printWriter2.println(full);
                nextLine = bufferedReader.readLine();
                
            }

            }
            catch (IOException e)
            {
                //do something when there are error
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
            }
            finally
            {
               //using if statment if line is empty close file 
               if (printWriter2 != null ){
               printWriter2.close();
               }
            }
            System.out.println("");//printing a empty line
    }
    
    //creating a menu method to tide up all method
    public void Menu(){
        //declare variable 
      int userInput;
      //using do while loop which end when user input is 0
        do{
        //printing some line
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");    
        System.out.println("please select one of the options below");
        System.out.println("1. Read from file, write to a file, copy file");
        System.out.println("2. Decipher a file");
        System.out.println("3. Process numerical data in text file");
        System.out.println("4. Check if file exist or can be read"); 
        System.out.println("5. 2-D Array to file ");
        System.out.println("6. Read and write objects from a file ");
        System.out.println("0. Exit");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*_*_*_*_*_*_*_*-*-*-*-*-*-*-");    
        //taking user input and storing in a variable
        Scanner s = new Scanner(System.in);
        userInput = s.nextInt();
        //using switch statement 
        switch(userInput){
            case 1://when user enter 1 open readfrom file and write file and copy file method
                readFromFile();
                writeFile();
                break;
                
            case 2://when user enter 2 open hacking method 
                hacking();
                break;
         
            case 3://when user enter 3 open detail method
                detail();
                break;
                 
              
            case 4://when user enter 4 open fileExist method
                fileExist();
                break;
                
            case 5 :
                arrayFile();//when user enter 5 open arrayfile method
                break;
            case 6 :
                readObject();
                break;
            case 0://when user enter 0 print some line
                System.out.println("'Goodbye'");
                System.out.println("Have a nice day :-)");                
                System.exit(0);
                break;
           
                default:// if user print invalid input
                System.out.println("Not Valid Input");
                                            }
               
                    
      }while(userInput != 0);
                                    
    }
    

}
