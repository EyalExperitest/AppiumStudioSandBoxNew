package main.java.tools;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

public class URLMonitor {

	public URLMonitor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		String urlString ="http://localhost:4723/wd/hub/sessions";
		String stringFromURL = URLReader.getStringFromURL(urlString);
		System.out.println(stringFromURL);

		System.out.println("Stoping commands");
		String currentStringFromURL=stringFromURL;
		long t0=System.currentTimeMillis();
		while (currentStringFromURL.equals(stringFromURL)){
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			currentStringFromURL= URLReader.getStringFromURL(urlString);
			
		}
		long t1=System.currentTimeMillis();
		System.out.println(currentStringFromURL);
		long totalSeconds =(t1-t0)/1000;
		long seconds =totalSeconds%60;
		long minutes = totalSeconds/60;
		System.out.println("Time : ["+minutes+":"+seconds+"]");
	}

}
