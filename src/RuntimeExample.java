import java.io.IOException;

public class RuntimeExample {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Runtime runtime= Runtime.getRuntime();
//        Process process= null;
//        process= runtime.exec("notepad.exe");
//        process.waitFor();
//        System.out.println("hi"+process.exitValue());

//        Runtime.Version version= Runtime.version();
//        System.out.println(version.minor());
//        System.out.println(version.major());
//        System.out.println(version.security());
//        System.out.println(version.build());
        ProcessBuilder processBuilder= new ProcessBuilder("notepad.exe","testfile");
        processBuilder.start();
        System.out.println();
        
    }

}
