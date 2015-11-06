import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {
	public static void main(String[] args) {
		String s = "大家加油转发啊~~。@sun_77_、@唯有好知己！@最美的牵挂_Niky //@宇泉侑  锦江旅行家毕业季的分享 我毕业了...|宇泉侑";
		Pattern p = Pattern.compile("//@([^：；！（）￥……~·，。？、“”‘’'\"+=%,.\\^<>&*\\/\\\\|\\[\\]{}《》!?`\\s]+?)[:：\\s]");
				
		Matcher matcher = p.matcher(s);
		for (int i = 0; matcher.find(i);) {
			String name = matcher.group(1);
			String text = s.substring(matcher.end());

			System.out.println(s.substring(matcher.start(), matcher.end()));
			
			i = matcher.end();
		}
	}
}
