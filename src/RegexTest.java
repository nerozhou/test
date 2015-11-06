import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest {
	public static void main(String[] args) {
		String s = "@阳光的瑶宸 //@许乃威的职场心理学: 一是招聘时严把关；二是新进员工集中规划职业生涯讲解公司企业文化；三是学堂式管理设班长、文娱委员、学习委员...;四是关注培训课程，穿插娱乐课程：五是关注培训师的培训质量，每天发培训心得；六是关心新员工的兴趣爱好，用心记录，分享特长";
		Pattern p = Pattern.compile("//@([^：；！（）￥……~·，。？、“”‘’'\"+=%,.\\^<>&*\\/\\\\|\\[\\]{}《》!?`\\s]+?)[:：]");
				
		Matcher matcher = p.matcher(s);
		for (int i = 0; matcher.find(i);) {
			String name = matcher.group(1);
			String text = s.substring(matcher.end());

			System.out.println(s.substring(matcher.start(), matcher.end()));
			
			i = matcher.end();
		}
	}
}
