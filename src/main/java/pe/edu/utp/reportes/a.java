package pe.edu.utp.reportes;

public class a {
    public static void main(String[] args) throws Exception {
        String x = a.class.getClassLoader().getResource("MandaEmail.pdf").toURI().getPath();
        System.out.println(x);
    }
}
