public class Random {

    public static int getRandomInt(int min, int max){
        java.util.Random random = new java.util.Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(){
        System.out.println(getRandomInt(0,10));
    }
}
