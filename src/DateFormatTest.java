import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateFormatTest {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formater = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		System.out.println(formater.format(new Date()));
	}
}
