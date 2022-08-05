package namoo.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
	public static void main(String[] args) {
		String urlString = "https://www.naver.com/index.html";

		BufferedReader br =null;
		
		try {
			URL url = new URL(urlString);
			InputStream in =  url.openStream();
			
			//InputStreamReader을 브릿지로 사용해야함
			br = new BufferedReader(new InputStreamReader(in));
			
			String html = null;
			while((html=br.readLine()) != null) {
				System.out.println(html);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {}
		if(br != null)
			try {
				if(br != null)br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
