//import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
final class MyEncryption
{
    private int key = 3;
    int cipherType =0;
    //    0--->not encrypted
//    1---> ceaserCipher
//    2--->transpositionCipher
    public int getKey(){return key;}
    public void setKey(int key){this.key = key;}
    public String ceaserCipher(String plainText,int key)
    {
        cipherType=1;
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        plainText = plainText.toLowerCase();
        String encryptedText="";
        char encryptedCharacter = 0;
        for (int i = 0; i < plainText.length(); i++)
        {
            if (Character.compare(plainText.charAt(i),' ')==0)
            {
                encryptedText += ' ';
            }
            else
            {
                int position = alphabet.indexOf(plainText.charAt(i));
                int newPosition = (position + key) % 26;
                encryptedCharacter = alphabet.charAt(newPosition);
                encryptedText += encryptedCharacter;
            }
        }
        return encryptedText;
    }
    public String ceaserCipher(String plainText)
    {
        cipherType=1;
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        plainText = plainText.toLowerCase();
        String encryptedText="";
        char encryptedCharacter = 0;
        for (int i = 0; i < plainText.length(); i++)
        {
            if (plainText.charAt(i)==' ')
            {
                encryptedText += plainText.charAt(i);
            }
            int position = alphabet.indexOf(plainText.charAt(i));
            int newPosition = (position+key)%26;
            encryptedCharacter = alphabet.charAt(newPosition);
            encryptedText += encryptedCharacter;
        }
        return encryptedText;
    }
    public String decryptionCeaserCipher(String encrpytedText, int key)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String plainText="";
        char decryptedCharacter = 0;
        for (int i = 0; i < encrpytedText.length(); i++)
        {
            if (encrpytedText.charAt(i)==' ')
            {
                plainText += ' ';
            }
            else
            {
                int position = alphabet.indexOf(encrpytedText.charAt(i));
                int newPosition = java.lang.Math.abs(position-key)%26;
                decryptedCharacter = alphabet.charAt(newPosition);
                plainText += decryptedCharacter;
            }
        }
        return plainText;
    }
    public String transpositionCipher(String plainText,String strKey)
    {
        cipherType=2;
        plainText = plainText.toLowerCase();
        String encryptedText="";
        int col = strKey.length();
        int row = plainText.length()/col;
        if ((plainText.length()%col)>0)
        {
            row = row +1;
        }
        char [][] matrix = new char[row][col];
        int k =0;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (k<plainText.length())
                {
                    matrix[i][j] = plainText.charAt(k);
                    k++;
                }
//                else
//                {
//                    matrix[i][j] = '*';
//                }
            }
        }
        for (int i = 0; i < col; i++)
        {
            for (int j = 0; j <row; j++)
            {
                encryptedText = encryptedText + matrix[j][i];
            }
        }
        return encryptedText;
    }
    public String decryptionTranspositionCipher(String encryptedString, String strKey)
    {
        String plainText="";
        int col = strKey.length();
        int row = encryptedString.length()/col;
        if ((encryptedString.length()%col)>0)
        {
            row = row +1;
        }
        char [][] matrix = new char[row][col];
        int k = 0;
        for (int i = 0; i <col; i++)
        {
            for (int j = 0; j <row; j++)
            {
                if (k<encryptedString.length())
                {
                    matrix[j][i] = encryptedString.charAt(k);
                    k++;
                }
            }
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                plainText = plainText + matrix[i][j];
            }
        }
        return plainText;
    }

    public String findEncryption(String plainText, String cipherText)
    {
//        int []d=new int[plainText.length()];
//        for (int i = 0; i < plainText.length(); i++)
//        {
//            d[i]=0;
//        }
//        for (int i = 0; i < plainText.length(); i++)
//        {
//            d[i] = plainText.charAt(i)-cipherText.charAt(i);
//        }
//        int flag=0;
//        for (int i = 0; i < plainText.length()-1; i++) {
//            flag=d[i]-d[i+1];
//            if (flag!=0){break;}
//        }
//        if (flag==0)
//        {
//            return ("Transposition Cipher");
//        }
//        else
//        {
//            return ("Ceasar Cipher.");
//        }
        if (cipherType==1)
        {
            return ("Ceasar Cipher.");
        } else if (cipherType==2) {
            return ("Transposition Cipher.");
        }
        else
        {
            return ("Cipher type not found.");
        }

    }
}

public class MyEncryptionMain
{
    public static void main(String[] args)
    {
        Scanner sin = new Scanner(System.in);
        System.out.println("Enter Input String:");
        String str = sin.nextLine();
        System.out.println("Enter Key:");
        int k = sin.nextInt();
        MyEncryption me = new MyEncryption();
        String ceserciph = me.ceaserCipher(str,k);
        System.out.println("Encrypted string:");
        System.out.println(ceserciph);
        String decr = me.decryptionCeaserCipher(ceserciph,k);
        System.out.println("Decrypted String:");
        System.out.println(decr);
        System.out.println(me.findEncryption(str,ceserciph));

        sin.nextLine();
        System.out.println("Enter Input String for transposition cipher:");
        String str2 = sin.nextLine();
        System.out.println("Enter Key:");
        String key = sin.nextLine();
        MyEncryption me2 = new MyEncryption();
        String trans = me2.transpositionCipher(str2,key);
        System.out.println("Encrypted String:");
        System.out.println(trans);
        String decr2 = me2.decryptionTranspositionCipher(trans,key);
        System.out.println("Decrypted String:");
        System.out.println(decr2);
        System.out.println(me2.findEncryption(str2,trans));
    }
}