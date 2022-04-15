import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {

    public static void main(String[] args) {

        String FileName="";
        int countWord = 0;
        int Countline = 0;
        int characterCount = 0;

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);


        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            FileName=selectedFile.getName();
            String s = selectedFile.getAbsolutePath();
            System.out.println(s);


            try
            {
                File file=new File(s);
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null)
                {
                    Countline+=1;
                    String[] arr=line.split(" ");
                    countWord=countWord+arr.length;
                    characterCount=characterCount+line.length();

                }
                fr.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }

        System.out.println("Name of file = " +FileName);
        System.out.println("Number of line = " + Countline);
        System.out.println("Total word count = " + countWord);
        System.out.println("Total number of characters = " + characterCount);


    }

}


