import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class test {


    public static void main(String[] args) {
        try {
            File myObj = new File("letter.txt");
            Scanner myReader = new Scanner(myObj);
            String[] array;
            String a = "";
            LinkedList<String> charList=new LinkedList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                a=a+data;
            }
            array=a.split("");
            for (String s : array) {
                if (!charList.search(s)) {
                    charList.insertToFront(s);
                }
            }
            LinkedList<String> freqAndLetters= new LinkedList<>();
            for (String s : array) {
                charList.searchChar(s);
            }
            charList.sort(freqAndLetters);
            charList.display();
            freqAndLetters.display();
            HuffmanTree<String> huff =new HuffmanTree<>();
            huff=freqAndLetters.huffmanTree();
            huff.findCodes();
            huff.codes.displayCodes();
            myReader.close();
            try {
                File source = new File("source.txt");
                Scanner sourceReader = new Scanner(source);
                String[] sourceArray;
                String sourceString = "";
                while (sourceReader.hasNextLine()){
                    String data=sourceReader.nextLine();
                    sourceString=sourceString+data;
                }
                sourceArray=sourceString.split("");

                FileWriter myWriter = new FileWriter("encoded");
                for (String str : sourceArray) {
                    myWriter.write(huff.codes.find(str).a);
                }
                myWriter.close();
                try {
                    File encoded = new File("encoded");
                    Scanner encodedReader = new Scanner(encoded);
                    String[] encodedarray;
                    String encode = "";
                    while (encodedReader.hasNextLine()) {
                        String data = encodedReader.nextLine();
                        encode=encode+data;
                    }
                    encodedarray=encode.split("");
                    FileWriter decodeWriter = new FileWriter("decoded.txt");
                    decodeWriter.write(huff.decode(encodedarray));
                    encodedReader.close();
                    decodeWriter.close();

                }
                catch (FileNotFoundException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
