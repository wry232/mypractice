import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Test {

    public static void main(String [] args) {
        testProperties();
    }



    /*
        The followings generate the followings:
        #This is a comment
        #Sun Mar 11 15:42:13 PDT 2018
        passwd=password
        username=admin
    * */
    public static void testProperties() {
        createProperties();
        Properties settings = readProperties();

        /*
        *  output:
            {passwd=password, username=admin}
            admin
            password
            null
            null
        * */
        System.out.println(settings);
        System.out.println(settings.getProperty("username"));
        System.out.println(settings.getProperty("passwd"));
        System.out.println(settings.getProperty("password"));
        System.out.println(settings.getProperty("user"));

    }

    static void createProperties() {
        String fname = "settings.properties";
        Path path = FileSystems.getDefault().getPath("./"+ fname).toAbsolutePath();
        Properties settings = new Properties();
        settings.put("username", "admin");
        settings.put("passwd", "password");

        try(OutputStream out = Files.newOutputStream(path)) {
            settings.store(out, "This is a comment");
        } catch (java.io.IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    static Properties readProperties() {
        String fname = "settings.properties";
        Path path = FileSystems.getDefault().getPath("./"+ fname).toAbsolutePath();
        Properties settings = new Properties();

        try(InputStream in = Files.newInputStream(path)) {
            settings.load(in);
        } catch (java.io.IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return settings;
    }

}
