import java.io.File;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JFileChooser;

public class ApplicationRunner {

    public static void main(String[] args) throws FileNotFoundException {


        JFileChooser chooser=new JFileChooser();

        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){


            File file=chooser.getSelectedFile();

            Scanner scanner=new Scanner(file);

            ArrayList<Object> words=new ArrayList<Object>();

            while(scanner.hasNext()){

                words.add(scanner.next());

            }

            scanner.close();

            words=Filter.applyFilter(words, new ShortWordFilter());

            System.out.println("Filtered words:");

            for(Object str:words){

                System.out.println(str);

            }

        }

    }

}
import java.util.ArrayList;

public interface Filter {

    boolean accept(Object x);

    static ArrayList<Object> applyFilter(ArrayList<Object> objects, Filter f) {

        //creating an array list to store the result

        ArrayList<Object> result = new ArrayList<Object>();

        //looping through each object

        for (Object ob : objects) {

            //if f accepts ob, adding ob to result

            if (f.accept(ob)) {

                result.add(ob);

            }

        }

        return result;

    }

}
public class ShortWordFilter implements Filter{

    @Override

    public boolean accept(Object x) {

        if(x instanceof String){

            //type casting

            String str=(String) x;

            return str.length()<5;

        }

        return false;

    }



}
