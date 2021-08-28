import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class XD {
    private static final Random random = new Random();

    public static void maina(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            double num = Math.random() * 5.0D;
            builder.append(random.nextBoolean() ? num : -num).append(",\n");
        }
        FileWriter writer = new FileWriter("xd.txt");
        writer.write(builder.toString());
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append("private double x").append(i).append(";").append("\n");
        }
        FileWriter writer = new FileWriter("xd.txt");
        writer.write(builder.toString());
        writer.close();
    }
}
