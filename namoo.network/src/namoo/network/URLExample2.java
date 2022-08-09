package namoo.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLExample2 {
	public static void main(String[] args) {
		String urlString = "https://t1.daumcdn.net/b2/creative/462319/bca05cbe723df27482b35188c05c05b1.jpg";
		BufferedInputStream br = null;
		BufferedOutputStream bos = null;
		InputStream in = null;
		
		
		try {
			URL url = new URL(urlString);
			in =  url.openStream();
			br = new BufferedInputStream(in);		
			
			String fileName = url.getFile();
			
			// urlString의 마지막 파일명을 동적으로 저장하는 방법
			//1.해당 url의 마지막 /의 인덱스 위치를 알아온다.
			int index = fileName.lastIndexOf('/');
			//2. 해당 url마지막 위치의 index값+1 지점을 변수에 저장한다.
			fileName = fileName.substring(index+1);
			//3. System.getProperty()는 괄호 안에 있는 파일 주소 경로를 찾아옴. user.home은 home dir을 의미
			String savePath = System.getProperty(("user.home") + File.separator+"Downloads"+File.separator+fileName);
			//													운영체제마다 / or \\일수있기 때문에 동적으로 하기 위해여 separator 사용
			
			OutputStream out = new FileOutputStream(savePath);
			
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=br.read(buffer)) != -1) {
				out.write(buffer,0,count);
			}
									
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {}
		if(br != null)
			try {
				if(in != null)in.close();
				if(br != null)br.close();
				if(bos != null)bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
