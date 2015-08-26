import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DataParser {
	
	public static void main(String[] args) throws FileNotFoundException, JSONException, ParseException {
		String input = "C:\\Users\\Ring\\Desktop\\url_180w_8.txt";
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(input))));
		
		int count = 1;
		while (scanner.hasNextLine()) {
			System.out.println("line " + count++);
			JSONObject json = parseData(scanner.nextLine());
			System.out.println(json);
		}
		
		scanner.close();
	}
	
	/**
	 * 
	 * @param jsonString
	 * @return  
	 * 			如果无微博信息，返回 null 
	 * @throws JSONException
	 * @throws ParseException
	 */
	public static JSONObject parseData(String jsonString) throws JSONException, ParseException {
		SimpleDateFormat dateFormater = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", 
				new Locale("EN", "CH"));
		JSONArray dataCards = new JSONObject(jsonString).getJSONArray("cards");
		JSONObject resultJson = new JSONObject();
		JSONArray weiboList = new JSONArray();
		Date lastScan = null;
		Date currentScan = null;
		int size = dataCards.length();
		
		if (size == 0) {
			return null;
		}
		
		for (int i = 0; i < size; i++) {
			JSONObject info = new JSONObject();
			JSONObject dataMblog = dataCards.getJSONObject(i).getJSONObject("mblog");
			Date postDate = dateFormater.parse(dataMblog.getString("created_at"));
			
			if (!resultJson.has("url")) {
				JSONObject dataUser = dataMblog.getJSONObject("user");
				
				resultJson.put("url", "http://weibo.com/u/" + dataUser.getString("idstr"));
				resultJson.put("nick_name", dataUser.getString("name"));
				resultJson.put("care_num", dataUser.getInt("friends_count"));
				resultJson.put("fans_num", dataUser.getInt("followers_count"));
				resultJson.put("posts_num", dataUser.getInt("statuses_count"));
			}
			
			
			
			info.put("posttime", postDate.getTime());
			info.put("wbtext", dataMblog.getString("text"));
			info.put("comment", dataMblog.getInt("comments_count"));
			info.put("agree", dataMblog.getInt("attitudes_count"));
			info.put("forward", dataMblog.getInt("reposts_count"));
			
			if (dataMblog.has("retweeted_status") 
					&& !dataMblog.isNull("retweeted_status") 
					&& !dataMblog.getJSONObject("retweeted_status").has("deleted") // 源微博没有被删除
					&& dataMblog.getJSONObject("retweeted_status").getJSONObject("visible").getInt("type") != 1 // 具有访问权限
					) {
				JSONObject dataRetweeted = dataMblog.getJSONObject("retweeted_status");
				Date postDateIn = dateFormater.parse(dataRetweeted.getString("created_at"));
				
				info.put("posttime_in", postDateIn.getTime());
				info.put("wbtext_in", dataRetweeted.getString("text"));
				info.put("forward_in", dataRetweeted.getInt("reposts_count"));
				info.put("comment_in", dataRetweeted.getInt("comments_count"));
				info.put("agree_in", dataRetweeted.getInt("attitudes_count"));
				info.put("at", "@" + dataRetweeted.getJSONObject("user").getString("name"));
			}
			
			weiboList.put(new JSONObject().append("weibo_info", info));
		}
		resultJson.put("type", "weibo");
		resultJson.put("weibo_list", weiboList);
		
		return resultJson;
	}
}
