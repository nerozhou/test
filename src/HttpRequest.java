import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequest {
	public static String baseUrl = "http://xtu32:12345/ltp";
	
	public static void main(String[] args) {
		try {
			System.out.println(doPost(baseUrl, "等我"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Request
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, String params) throws Exception {
		URL localURL = new URL(url + params);
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			System.out.println("HTTP Request is not success, Response code is "
					+ httpURLConnection.getResponseCode());
		}

		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}
		return resultBuffer.toString();
	}

	/**
	 * Post Request
	 * 
	 * @return
	 * @throws Exception
	 */
	//HttpRequest.doPost("http://172.16.120.188:12345/ltp", 
	//"s=" + s + "&x=n&t=ner");
	public static String doPostByte(String url, byte[] parameterData)
			throws Exception {
		//url = "http://172.16.120.188:12345/ltp";
		//parameterData = "s=" + s + "&x=n&t=ner";
		URL localURL = new URL(url);
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		httpURLConnection.setRequestProperty("Content-Length",
				String.valueOf(parameterData.length));

		OutputStream outputStream = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;
		try {
			outputStream = httpURLConnection.getOutputStream();
			outputStream.write(parameterData);
			outputStream.flush();
			if (httpURLConnection.getResponseCode() >= 300) 
			{
				throw new Exception(
//						"\nHTTP Request is not success, Response code :"
//								+ httpURLConnection.getResponseCode()+"\nResponse Message:"+httpURLConnection.getResponseMessage()
						//抛出信息为http返回的错误码和错误信息
						httpURLConnection.getResponseCode()+":"+
						httpURLConnection.getResponseMessage()
						
						
						);
			}
			

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		}

		finally 
		{
			if (outputStream != null) {
				outputStream.close();
			}

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		return resultBuffer.toString();
	}
	/**
	 * Post Request
	 * 
	 * @return
	 * @throws Exception
	 */
	//HttpRequest.doPost("http://172.16.120.188:12345/ltp", 
	//"s=" + s + "&x=n&t=ner");
	public static String doPost(String url, String parameterData)
			throws Exception {
		//url = "http://172.16.120.188:12345/ltp";
		//parameterData = "s=" + s + "&x=n&t=ner";
		URL localURL = new URL(url);
		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		httpURLConnection.setRequestProperty("Content-Length",
				String.valueOf(parameterData.length()));

		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		try {
			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);

			outputStreamWriter.write(parameterData.toString());
			outputStreamWriter.flush();
			if (httpURLConnection.getResponseCode() >= 300) {
				throw new Exception(
//						"\nHTTP Request is not success, Response code :"
//								+ httpURLConnection.getResponseCode()+"\nResponse Message:"+httpURLConnection.getResponseMessage()
						//抛出信息为http返回的错误码和错误信息
						httpURLConnection.getResponseCode()+":"+
						httpURLConnection.getResponseMessage()
						
						
						);
			}
			

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		}

		finally 
		{

			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}

			if (outputStream != null) {
				outputStream.close();
			}

			if (reader != null) {
				reader.close();
			}

			if (inputStreamReader != null) {
				inputStreamReader.close();
			}

			if (inputStream != null) {
				inputStream.close();
			}

		}

		return resultBuffer.toString();
	}

	/*
	 * 给定一个词性标志，判断是否为名词
	 * 例如：n为名词，nr为人名，nd为方向名词，这些都属于名词 所以返回true
	 */
	public boolean isNoun(String posTag)
	{
		/*
		Set<String> nounSet = new HashSet<String>();
		nounSet.add("n");//一般性名词
		nounSet.add("nd"); //方向名词
		nounSet.add("nh"); //人名
		nounSet.add("ni");//组织名称
		nounSet.add("nl"); //位置名词
		nounSet.add("ns"); //地理名称
		nounSet.add("nt"); //时间名称
		nounSet.add("nz"); //其他固有名词
		return nounSet.contains(posTag);
		*/
		return posTag.contains("n");
		
	}
}
