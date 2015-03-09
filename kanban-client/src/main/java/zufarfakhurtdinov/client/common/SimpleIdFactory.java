package zufarfakhurtdinov.client.common;

import java.util.Random;

/**
 * Created by dr on 26.06.2014.
 */
public class SimpleIdFactory implements IdFactory {
    private static final Random random = new Random();

    @Override
    public String getId() {
        byte[] bytes = new byte[8];
        random.nextBytes(bytes);
        char[] chars = new char[8];
        for(int i = 0; i < bytes.length; i++) {
            chars[i] = (char)bytes[i];
        }
        return new String(chars);
    }
}
