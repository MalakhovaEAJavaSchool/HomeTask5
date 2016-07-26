import javafx.application.Application;

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
        boolean good = false;
        try(Scanner in = new Scanner(System.in)) {
            URL urlAdress =  new URL(in.nextLine());
            in.nextLine();
            String output = ReadContent(urlAdress.toString());
            System.out.println(output);
            good = true;
        } catch(MalformedURLException e){
            System.out.println("Указан неверный формат адреса, введите снова:");
            System.out.println(e.getMessage());
        } catch (Exception ex){
            System.out.println("Произошло непредвиденное исключение:");
            System.out.println(ex.getMessage());
        } finally {
            if (!good){
                System.out.println("Повторите попытку снова");
            }
            else{
                System.out.println("УСПЕХ!!!");
            }

        }

    }
    private static String ReadContent(String urladress) throws Exception
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
        finally {
            return content.toString();
        }
        /*catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
