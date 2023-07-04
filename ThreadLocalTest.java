import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTest {
    public static final ThreadLocal<SimpleDateFormat> dateFormat
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    public static void main(String ... args) {
        String dateStamp = dateFormat.get().format(new Date());

    }
}
