import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {
    public static void main(String[] args) throws IOException {

        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");

        File arquivo = new File("/arquivo/arquivo.txt");

        System.out.println("::Listener:: arquivo path::" + arquivo.toPath());

        int indiceBarra = arquivo.getPath().lastIndexOf("\\") + 1;
        System.out.println("::Listener:: indiceBarra::" + indiceBarra);

        if (indiceBarra == 0) {
            indiceBarra = arquivo.getCanonicalPath().lastIndexOf("/") + 1;
        }

        System.out.println("::Listener:: indiceBarra::" + indiceBarra);

        // Basta pegar o substring com o caminho da pasta.
        String caminhoPasta = arquivo.getCanonicalPath().substring(0, indiceBarra +1);
        System.out.println("::Listener:: caminhoPasta::" + caminhoPasta);

        System.out.println("::Listener:: Arquivo::" + arquivo);
        System.out.println("::Listener:: nomeArquivo::" + arquivo.getName().replaceFirst("[.][^.]+$", ""));

        String arquivoRenomeado = arquivo.getName()
                .replaceFirst("[.][^.]+$", "")
                + "_" + dateTimeFormatter.format(dataAtual) + ".txt";

        boolean sucess = arquivo.renameTo(new File(caminhoPasta + File.separator + arquivoRenomeado));

        System.out.println("::Listener:: nomeArquivoRenomeado::" + sucess);
        System.out.println("::Listener:: nomeArquivoRenomeado::" + arquivoRenomeado);
        System.out.println("::Listener:: dataAtual::" + dataAtual.toString());

        System.out.println("::Listener:: caminhoPasta::" + arquivo.getCanonicalPath());
        System.out.println("::Listener:: caminhoPasta CanonicalPath::" + arquivo.getCanonicalPath());



//        arquivo.renameTo(new File(caminhoPasta + s));


    }
}
