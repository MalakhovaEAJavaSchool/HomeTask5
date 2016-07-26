import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Malahova on 26.07.2016.
 */
public class MethodReadContent {
    public static void main(String[] args)
    {
        System.out.println("Введите адрес:");
        Scanner in = new Scanner(System.in);
        URL urlAdress;
        try {
             urlAdress =  new URL(in.nextLine());
            String output = ReadContent(urlAdress.toString());
            System.out.println(output);
        } catch(MalformedURLException e){
            System.out.println(e.getMessage());
            System.out.println("Указан неверный формат адреса, введите снова:");
        }
    }
    private static String ReadContent(String urladress)
    {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try
        {
            // create a url object
            URL url = new URL(urladress);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
