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
        try
        {
            URL url = new URL(urladress);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
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
