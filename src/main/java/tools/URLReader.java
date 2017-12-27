package main.java.tools;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        String urlString = "http://eyalneumann.experitest.local:4723/wd/hub/sessions";
		String getStringFromURL = URLReader.getStringFromURL(urlString);
		System.out.println(getStringFromURL);
    }

	/**
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String getStringFromURL(String urlString) throws MalformedURLException, IOException {
		URL oracle = new URL(urlString);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        StringBuffer outputBuffer=new StringBuffer("");
        String inputLine;
        while ((inputLine = in.readLine()) != null){
        	//System.out.println(inputLine);
        	outputBuffer.append(inputLine);
        }
        in.close();
        
        String getStringFromURL = outputBuffer.toString();
		return getStringFromURL;
	}
}