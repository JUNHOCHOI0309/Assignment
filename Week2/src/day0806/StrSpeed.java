package day0806;

//과제 3
public class StrSpeed {
    //String 사용
    public static String buildStringWithString(int count){
        String str = "";
        for(int i = 0; i < count; i++){
            str += "a";
        }
        return str;
    }

    //StringBuffer 사용
    public static String buildStringBufferWithStringBuffer(int count){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < count; i++){
            sb.append("a");
        }
        return sb.toString();
    }

    //StringBuilder 사용
    public static String buildStringBuilderWithStringBuilder(int count){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append("a");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long start, end;

        //String
        start = System.nanoTime();
        buildStringWithString(1000000);
        end = System.nanoTime();
        System.out.println("String: " + (end - start)  + "ns");

        //StringBuffer
        start = System.nanoTime();
        buildStringBufferWithStringBuffer(1000000);
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start)  + "ns");

        //StringBuilder
        start = System.nanoTime();
        buildStringBuilderWithStringBuilder(1000000);
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start)  + "ns");
    }


}
