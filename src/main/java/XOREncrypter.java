public class XOREncrypter {
    public static void main(String[] args) {
        String text = "Take five";
        String key = "Dave Brubeck";
        String encrypt = encrypt(text, key);
        System.out.println(encrypt);
    }

    public static String encrypt(String text, String keyWord) {
        byte[] arr = text.getBytes();
        byte[] keyArr = keyWord.getBytes();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < arr.length; ++i) {
            String hex = Integer.toHexString(255 & (byte)(arr[i] ^ keyArr[i % keyArr.length]));
            if (hex.length() == 1) {
                builder.append('0');
            }

            builder.append(hex);
        }

        return builder.toString();
    }
}
