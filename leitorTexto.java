//Pacote Principal
package leitorTexto;

//Importa��es necess�rias
import java.io.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

//Classe LeitorTexto
public class leitorTexto {	
	
	//M�todo principal
	public static void main(String[] args) {
		
		//Entredas de largura e comprimento para a cria��o da imagem
		int largura = Integer.parseInt(JOptionPane.showInputDialog("Qual � a largura da imagem?"));
		int comprimento = Integer.parseInt(JOptionPane.showInputDialog("Qual � o comprimento da imagem?"));
		
		//Imagem em buffer at� a composi��o final
		BufferedImage img = new BufferedImage(comprimento, largura, BufferedImage.TYPE_INT_RGB);
	
		//Entrada do nome do arquivo texto para a forma��o a partir deste
		String nomeArquivo = JOptionPane.showInputDialog("Escreva o nome do arquivo");
		
		//String para o caminho da imagem
		String nomeCompleto = "C:\\Users\\eduar\\Desktop\\" + nomeArquivo + ".txt";
		
		//Linha para a forma��o da imagem atraves da leitura da mesma
		String linha = null;
		
		try {
			
			//Cria um leitor para o arquivo texto
			FileReader arquivo = new FileReader(nomeCompleto);
			
			//Cria um buffer para a entrada de valores do arquivo texto para o programa
			BufferedReader texto = new BufferedReader(arquivo);
			
			//Enquanto a linha do texto for diferente de nulo 
			while((linha = texto.readLine()) != null) {
				
				//Separe as strings das linhas a partir de um espa�o " "
				String[] textoSplit = linha.split(" ");
				
				//Pega, no primeiro espa�o da linha a posi��o X
				int posicaoX = Integer.parseInt(textoSplit[0]);
				//Pega, no segundo espa�o da linha a posi��o Y
				int posicaoY = Integer.parseInt(textoSplit[1]);
				
				//Pega, nas seguintes posi��es as cores vermelha, verde e azul
				int red = Integer.parseInt(textoSplit[2]);
				int green = Integer.parseInt(textoSplit[3]);
				int blue = Integer.parseInt(textoSplit[4]);
				
				//Cria um pixel para a forma��o da imagem
				int pixel = (red<<16) | (green<<8) | blue; 
				
				//Coloca, na imagem criada, um pixel de determinada cor na posi��o determinada
				img.setRGB(posicaoY, posicaoX, pixel);			
				
				//Imprime na tela o processo de cria��o da imagem
				System.out.println("x:" + posicaoX + " y: " + posicaoY + " - r:" + red + " g:" + green + " b:" + blue);				
				
				//Abre um arquivo para a imagem a ser criada
				File arquivoImagem = new File("C:\\Users\\eduar\\Desktop\\Output.jpg");
				
				//Escreve, na imagem a ser criada, o pixel, o tipo da imagem, e o arquivo para impress�o
			    ImageIO.write(img, "jpg", arquivoImagem);
			}
			
			//Fecha o arquivo
			texto.close();
		} catch (FileNotFoundException ex) {
			
			//Caso o arquivo n�o exista
			System.out.println("N�o foi poss�vel achar o arquivo...");
		} catch (IOException ex) {
			
			//Caso ocorra um erro inesperado
			System.out.println("Ocorreu um erro inesperado...");
		}
	}

}
