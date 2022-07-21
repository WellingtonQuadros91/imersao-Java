package Aula01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		
		// leitura da imagem
		
		//InputStream inputStream = new FileInputStream(new File("C:\\ProjetoImersao\\Stickers\\entrada\\filme1-maior.jpg"));
		//InputStream inputStream1 = new URL("https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@.jpg").openStream();
		BufferedImage fotoOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem em memória com transperência e com tamanho novo
		int largura = fotoOriginal.getWidth();
		int altura = fotoOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage fotoNova = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original pra nova imagem (em memória)
		
		Graphics2D graphics = (Graphics2D) fotoNova.getGraphics();
		graphics.drawImage(fotoOriginal, 0, 0, null);
		
		// configurar fonte
		
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		// escrever uma frase na nova imagem 
		
		graphics.drawString("TOPZERA", 100, novaAltura - 100);
		
		// escrever a nova imagem em um arquivo
		ImageIO.write(fotoNova, "png", new File(nomeArquivo));
	}

}

