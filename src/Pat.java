import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Pat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("@((?:(?!\\s).)+)");
		Matcher m = p.matcher(args[0]);
		
		int offset = 0;
		System.out.println(args[0]);
		while (m.find(offset)) {
			System.out.println(m.group(1));
			offset = m.end(0);
		}
	}
}
