package socket.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author gongxb
 *
 * 2018Äê1ÔÂ27ÈÕ
 */
public class UrlTest {
	public static void main(String[] args) throws IOException {
			URL url=new URL("https://www.baidu.com/");
			InputStream in=url.openStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));
			String str=br.readLine();
			while(str!=null) {
				System.out.println(str);
				str=br.readLine();
			}
			br.close();
			in.close();
	}
}
