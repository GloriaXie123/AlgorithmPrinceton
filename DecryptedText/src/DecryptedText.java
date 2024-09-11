import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class DecryptedText {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String ciphertext = in.nextLine();
            String decryptedtext = decrypt(ciphertext);
            System.out.println(decryptedtext);
        }
    }

    private static String decrypt(String ciphertext){
        StringBuilder decryptedtext = new StringBuilder();

        String[] parts = ciphertext.split("\\*");

        for(String part : parts){
            int value = Integer.parseInt(part);

            if(value >= 1 && value <= 9){
                decryptedtext .append((char)(value -1 + 'a'));
            }else if(value >= 10 && value <= 26){
                decryptedtext .append((char)(value - 10 + 'j'));
            }else{
                decryptedtext .append(part);
            }
        }



        // for(char c : ciphertext.toCharArray()){
        //     if(c >= 'a' && c <= 'i'){
        //         decryptedtext .append((char)(c - 'a' + 1 + '0'));
        //     }else if(c >= 'j' && c <= 'z'){
        //         decryptedtext .append((char)(c - 'j' + 10 + '0'));
        //     }else{
        //         decryptedtext .append(c);
        //     }
        // }

        return decryptedtext.toString();
    }

}
