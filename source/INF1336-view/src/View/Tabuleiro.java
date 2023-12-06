package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Match;


public class Tabuleiro extends JPanel
{
	private Menu menu;
	Match match;
	private Image dadoImage_at;
	private Image dadoImage_def;
	private JFrame cardFrame;
	
	int valorAtaque;
	int valorDefesa;

	public Tabuleiro(Menu menu, int numPlayers, Color[] playerColors, String[] playerNames)
	{
		Font font = new Font("Times New Roman", Font.BOLD,14);
        this.menu = menu;
        setLayout(null);
        JButton save = new JButton("Salvar Jogo");
		JButton dado = new JButton("Jogar Dados");
		JButton vez = new JButton("Passar Vez");
		JButton cartas = new JButton("Mostrar Cartas");
		JButton testeFim = new JButton("Teste. Fim");
		addMouseListener(new MapMouseListener());
		testeFim.addActionListener(e -> menu.endGame());
    	save.addActionListener(e -> this.menu.saveGame());
		dado.addActionListener(e-> Lancar_dados());
		vez.addActionListener(e-> PassarVez());
		cartas.addActionListener(e->playerCards(numPlayers, playerColors, playerNames));
		testeFim.setBounds(1050, 50, 110, 20);
		save.setBounds(1050,10,110,20);
		dado.setBounds(1050,130,110,20);
		vez.setBounds(1050,160, 110, 20);
		cartas.setBounds(1040, 600, 130, 20);
		testeFim.setFont(font);
		save.setFont(font);
		dado.setFont(font);
		vez.setFont(font);
		cartas.setFont(font);
		add(testeFim);
		add(save);
		add(dado);
		add(vez);
		add(cartas);
    }
	
	private void playerCards(int numPlayers, Color[] playerColors, String[] playerNames)
	{
		int cartas = 42;//teste
		int mao = cartas / numPlayers;//teste

		cardFrame = new JFrame("Cartas de "+ playerNames[0]+". Quantidade de cartas: "+ mao +" + Objetivo");
		cardFrame.setLayout(new FlowLayout());
		JLabel[] pcartas = new JLabel[mao];
		
		//JLabel l2 =new JLabel();
		JLabel lobj =new JLabel();
		
		//l.setIcon(new ImageIcon("assets/images/war_carta_placeholder.png"));
		for(int i = 0; i<mao; i++)
		{
			JLabel l =new JLabel();
			l.setIcon(new ImageIcon("assets/images/war_carta_placeholder.png"));
			pcartas[i] = l;
			cardFrame.getContentPane().add(l);
		}
		//l2.setIcon(new ImageIcon("assets/images/war_carta_af_africadosul.png"));
		// l.setIcon(new ImageIcon("assets/images/war_carta_placeholder.png"));
		lobj.setIcon(new ImageIcon("assets/images/war_carta_objetivo.png"));
		JTextArea objetivo = new JTextArea("Objetivo: (...)");
		
		//cardFrame.getContentPane().add(l2);
		cardFrame.getContentPane().add(lobj);// carta ou textArea, definir depois..
		cardFrame.getContentPane().add(objetivo);
		cardFrame.pack();
		cardFrame.setVisible(true);
	}

	private Object PassarVez()
	{
		//ordem do jogador
		JOptionPane.showMessageDialog(null, "Próximo Jogador..." , "", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Esperado mudar de Jogador");
		return null;
	}

	public void Lancar_dados()
	{		
		JFrame dDialog = new JFrame("Lançamento dos Dados");
		dDialog.setSize(300, 200);
		dDialog.setLocationRelativeTo(this);
		Container c = dDialog.getContentPane();
		
        c.setLayout(new GridLayout(3, 2));

        JLabel labelAtaque = new JLabel("Valor do Dado de Ataque:");
        JTextField textFieldAtaque = new JTextField();
        JLabel labelDefesa = new JLabel("Valor do Dado de Defesa:");
        JTextField textFieldDefesa = new JTextField();
		JButton randButton = new JButton("Aleatório");
		JButton confirmButton = new JButton("Confirmar");
		
        confirmButton.addActionListener(e ->
		{
            valorAtaque = Integer.parseInt(textFieldAtaque.getText());
            valorDefesa = Integer.parseInt(textFieldDefesa.getText());
			
			if (valorAtaque >= 1 && valorAtaque <= 6 && valorDefesa >= 1 && valorDefesa <= 6)
			{
        		// Atualiza as imagens dos dados com base nos valores escolhidos
        		String imageNameAt = "assets/images/dado_ataque_" + valorAtaque + ".png";
       			dadoImage_at = loadImage(imageNameAt);
        		String imageNameDef = "assets/images/dado_defesa_" + valorDefesa + ".png";
        		dadoImage_def = loadImage(imageNameDef);

				System.out.println("Dado Ataque: "+ valorAtaque+"\n"+"Dado Defesa: "+ valorDefesa);
        		// Redesenha o painel para exibir as novas imagens
        		this.repaint();
    		}
			else
			{
				JOptionPane.showMessageDialog(this, "Valor(es) inválido(s).", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
			}
        });

		randButton.addActionListener(e->
		{
			Random random = new Random();
			Random random2 = new Random();
			int numeroAleatorio_at = random.nextInt(6) + 1;
			int numeroAleatorio_def = random2.nextInt(6) + 1;
			// Atualiza a imagem do dado com base no número gerado
			String imageName = "assets/images/dado_ataque_" + numeroAleatorio_at + ".png";
			dadoImage_at = loadImage(imageName);
			String imageName2 = "assets/images/dado_defesa_" + numeroAleatorio_def + ".png";
			dadoImage_def = loadImage(imageName2);
			// Redesenha o painel para exibir a nova imagem
			this.repaint();
			System.out.println("Dado Ataque: "+ numeroAleatorio_at+"\n"+"Dado Defesa: "+ numeroAleatorio_def);
		});

        c.add(labelAtaque);
        c.add(textFieldAtaque);
        c.add(labelDefesa);
        c.add(textFieldDefesa);
		c.add(randButton);
		c.add(confirmButton);
		dDialog.pack();
		dDialog.setVisible(true);
    }
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D G2D = (Graphics2D) g;
		Image imgFundo = null;
		Image imgMapa = null;
		Image imgBarra = null;

		try {
			imgFundo = ImageIO.read(new File("assets/images/war_tabuleiro_fundo.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try
		{
			imgMapa = ImageIO.read(new File("assets/images/war_tabuleiro_mapa copy.png"));
			int largura = imgMapa.getWidth(null);
	        int altura = imgMapa.getHeight(null);  
	        System.out.println("Largura da imagem: " + largura + " pixels");
	        System.out.println("Altura da imagem: " + altura + " pixels");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			imgBarra = ImageIO.read(new File("assets/images/war_tabuleiro_bottom.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Construção do Mapa
		g.drawImage(imgFundo,0,0,1024,768, null);
		g.drawImage(imgMapa,0,-60,1024,768, null);
		g.drawImage(imgBarra,0,590,1024,85, null);

		Rectangle2D rt1 = new Rectangle2D.Double(1024,0,1200,700);
		Rectangle2D rt2 = new Rectangle2D.Double(1024,90,176,20);

		G2D.setColor(Color.GRAY);
		G2D.draw(rt1);
		G2D.fill(rt1);
		G2D.setColor(Color.BLUE);
		G2D.draw(rt2);
		G2D.fill(rt2);

		//
		showDices(G2D);
		
        //países

		//Am. Sul
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"Argentina", 247, 560);
        countryPosition(g,G2D,"Brasil", 265, 440);
		countryPosition(g,G2D,"Peru", 220, 480);
		countryPosition(g,G2D,"Venezuela", 162, 430);

		//Oceania
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"Austrália", 852, 593);
        countryPosition(g,G2D,"Indonésia", 865, 495);
		countryPosition(g,G2D,"Nova Zelândia", 896, 640);
		countryPosition(g,G2D,"Perth", 795, 593);

		//África
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"África do Sul", 538, 557);
        countryPosition(g,G2D,"Angola", 535, 497);
		countryPosition(g,G2D,"Argélia", 440, 359);
		countryPosition(g,G2D,"Egito", 552, 373);
		countryPosition(g,G2D,"Nigéria", 490, 420);
		countryPosition(g,G2D,"Somália", 600, 475);

		//Europa
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"Espanha", 419, 275);
        countryPosition(g,G2D,"França", 471, 235);
		countryPosition(g,G2D,"Itália", 528, 234);
		countryPosition(g,G2D,"Polônia", 554, 190);
		countryPosition(g,G2D,"Reino Unido", 430, 151);
        countryPosition(g,G2D,"Romênia", 558, 270);
		countryPosition(g,G2D,"Suécia", 535, 114);
		countryPosition(g,G2D,"Ucrânia", 587, 227);

		//Am. Norte/Central
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"Alasca", 85, 126);
        countryPosition(g,G2D,"Calgary", 158, 138);
		countryPosition(g,G2D,"Califórnia", 97, 242);
		countryPosition(g,G2D,"Groelândia", 295, 103);
		countryPosition(g,G2D,"México", 125, 350);
        countryPosition(g,G2D,"Nova Iorque", 209, 256);
		countryPosition(g,G2D,"Quebec", 275, 180);
		countryPosition(g,G2D,"Texas", 170, 231);
		countryPosition(g,G2D,"Vancouver", 131, 184);

		//Ásia
		//G2D.setColor(Color.white);
		countryPosition(g,G2D,"Arábia Saudita", 640, 400);
        countryPosition(g,G2D,"Bangladesh", 818, 385);
		countryPosition(g,G2D,"Cazaquistão", 781, 210);
		countryPosition(g,G2D,"China", 777, 281);
		countryPosition(g,G2D,"Coreia do Norte", 829, 300);
        countryPosition(g,G2D,"Coreia do Sul", 829, 329);
		countryPosition(g,G2D,"Estônia", 661, 132);
		countryPosition(g,G2D,"Índia", 783, 372);
		countryPosition(g,G2D,"Irã", 708, 330);
		countryPosition(g,G2D,"Iraque", 658, 338);
        countryPosition(g,G2D,"Japão", 926, 248);
		countryPosition(g,G2D,"Jordânia", 598, 330);
		countryPosition(g,G2D,"Letônia", 627, 185);
		countryPosition(g,G2D,"Mongólia", 828, 249);
        countryPosition(g,G2D,"Paquistão", 708, 301);
		countryPosition(g,G2D,"Rússia", 777, 135);
		countryPosition(g,G2D,"Sibéria", 880, 130);
		countryPosition(g,G2D,"Síria", 638, 272);
		countryPosition(g,G2D,"Tailândia", 888, 365);
		countryPosition(g,G2D,"Turquia", 703, 236);

		//Am. Sul
		Ellipse2D ag = createCircle(G2D, 267,570);
		Ellipse2D br = createCircle(G2D, 273,450);
		Ellipse2D pe = createCircle(G2D, 225,490);
		Ellipse2D ve = createCircle(G2D, 185,440);
		
		//Oceania
		Ellipse2D au = createCircle(G2D, 870,603);
		Ellipse2D in = createCircle(G2D, 887,505);
		Ellipse2D nz = createCircle(G2D, 930,650);
		Ellipse2D pr = createCircle(G2D, 802,603);

		//África
		Ellipse2D af = createCircle(G2D, 569,567);
		Ellipse2D an = createCircle(G2D, 547,507);
		Ellipse2D ar = createCircle(G2D, 450,369);
		Ellipse2D eg = createCircle(G2D, 560,383);
		Ellipse2D ni = createCircle(G2D, 504,430);
		Ellipse2D so = createCircle(G2D, 616,485);

		//Europa
		Ellipse2D es = createCircle(G2D, 438,285);
		Ellipse2D fr = createCircle(G2D, 483,245);
		Ellipse2D it = createCircle(G2D, 533,244);
		Ellipse2D po = createCircle(G2D, 568,200);
		Ellipse2D rn = createCircle(G2D, 457,161);
		Ellipse2D ro = createCircle(G2D, 576,280);
		Ellipse2D su = createCircle(G2D, 546,124);
		Ellipse2D uc = createCircle(G2D, 599,237);

		//Am. Norte/Central
		Ellipse2D al = createCircle(G2D, 95,136);
		Ellipse2D ca = createCircle(G2D, 173,148);
		Ellipse2D cl = createCircle(G2D, 118,252);
		Ellipse2D gr = createCircle(G2D, 319,113);
		Ellipse2D me = createCircle(G2D, 139,360);
		Ellipse2D ny = createCircle(G2D, 235,266);
		Ellipse2D qu = createCircle(G2D, 288,190);
		Ellipse2D te = createCircle(G2D, 178,241);
		Ellipse2D va = createCircle(G2D, 156,194);

		//Ásia
		Ellipse2D as = createCircle(G2D, 670,410);
		Ellipse2D ba = createCircle(G2D, 845,395);
		Ellipse2D cz = createCircle(G2D, 810,220);
		Ellipse2D ch = createCircle(G2D, 784,291);
		Ellipse2D cn = createCircle(G2D, 870,300);
		Ellipse2D cs = createCircle(G2D, 864,332);
		Ellipse2D et = createCircle(G2D, 675,142);
		Ellipse2D id = createCircle(G2D, 789,382);
		Ellipse2D ir = createCircle(G2D, 707,340);
		Ellipse2D iq = createCircle(G2D, 669,348);
		Ellipse2D ja = createCircle(G2D, 935,258);
		Ellipse2D jo = createCircle(G2D, 615,340);
		Ellipse2D le = createCircle(G2D, 640,195);
		Ellipse2D mo = createCircle(G2D, 845,259);
		Ellipse2D pa = createCircle(G2D, 730,311);
		Ellipse2D ru = createCircle(G2D, 789,145);
		Ellipse2D sb = createCircle(G2D, 892,140);
		Ellipse2D si = createCircle(G2D, 643,282);
		Ellipse2D ta = createCircle(G2D, 906,375);
		Ellipse2D tu = createCircle(G2D, 718,246);

		//Am. Sul
		G2D.fill(ag);
		G2D.fill(br);
		G2D.fill(pe);
		G2D.fill(ve);

		//Oceania
		G2D.fill(au);
		G2D.setColor(Color.white);
		G2D.fill(in);
		G2D.setColor(Color.RED);
		G2D.fill(nz);
		G2D.fill(pr);

		//África
		G2D.fill(af);
		G2D.fill(an);
		G2D.fill(ar);
		G2D.setColor(Color.green);
		G2D.fill(eg);
		G2D.fill(ni);
		G2D.fill(so);
		
		//Europa
		G2D.fill(es);
		G2D.fill(fr);
		G2D.setColor(Color.red);
		G2D.fill(it);
		G2D.fill(po);
		G2D.fill(rn);
		G2D.setColor(Color.yellow);
		G2D.fill(ro);
		G2D.fill(su);
		G2D.fill(uc);

		//Am. Norte/Central
		G2D.fill(al);
		G2D.fill(ca);
		G2D.fill(cl);
		G2D.fill(gr);
		G2D.fill(me);
		G2D.setColor(Color.GREEN);
		G2D.fill(ny);
		G2D.fill(qu);
		G2D.fill(te);
		G2D.fill(va);
		
		//Ásia
		G2D.setColor(Color.BLUE);
		G2D.fill(as);
		G2D.fill(ba);
		G2D.fill(cz);
		G2D.fill(ch);
		G2D.fill(cn);
		G2D.fill(cs);
		G2D.fill(et);
		G2D.fill(id);
		G2D.fill(ir);
		G2D.fill(iq);
		G2D.setColor(Color.GREEN);
		G2D.fill(ja);
		G2D.fill(jo);
		G2D.fill(le);
		G2D.fill(mo);
		G2D.setColor(Color.YELLOW);
		G2D.fill(pa);
		G2D.fill(ru);
		G2D.fill(sb);
		G2D.fill(si);
		G2D.fill(ta);
		G2D.fill(tu);

		int testepaises = 42;
		for(int i = 0; i< testepaises;i++)
		{
			//fillPlayerCircle(G2D, tu, playerCards(testepaises, null, null););
		}

		drawNumber(G2D, au, "1");
		drawNumber(G2D, in, "1");
		drawNumber(G2D, nz, "1");
		drawNumber(G2D, pr, "1");

		drawNumber(G2D, ag, "1");
		drawNumber(G2D, br, "1");
		drawNumber(G2D, pe, "1");
		drawNumber(G2D, ve, "1");
	
		drawNumber(G2D, es, "1");
		drawNumber(G2D, fr, "1");
		drawNumber(G2D, it, "1");
		drawNumber(G2D, po, "1");
		drawNumber(G2D, rn, "1");
		drawNumber(G2D, ro, "1");
		drawNumber(G2D, su, "1");
		drawNumber(G2D, uc, "1");

		drawNumber(G2D, al, "1");
		drawNumber(G2D, ca, "1");
		drawNumber(G2D, cl, "1");
		drawNumber(G2D, gr, "1");
		drawNumber(G2D, me, "1");
		drawNumber(G2D, ny, "1");
		drawNumber(G2D, qu, "1");
		drawNumber(G2D, te, "1");
		drawNumber(G2D, va, "1");

		drawNumber(G2D, af, "1");
		drawNumber(G2D, an, "1");
		drawNumber(G2D, ar, "1");
		drawNumber(G2D, eg, "1");
		drawNumber(G2D, ni, "1");
		drawNumber(G2D, so, "1");
	
		drawNumber(G2D, as, "1");
		drawNumber(G2D, ba, "1");
		drawNumber(G2D, cz, "1");
		drawNumber(G2D, ch, "1");
		drawNumber(G2D, cn, "1");
		drawNumber(G2D, cs, "1");
		drawNumber(G2D, et, "1");
		drawNumber(G2D, id, "1");
		drawNumber(G2D, ir, "1");
		drawNumber(G2D, iq, "1");
		drawNumber(G2D, ja, "1");
		drawNumber(G2D, jo, "1");
		drawNumber(G2D, le, "1");
		drawNumber(G2D, mo, "1");
		drawNumber(G2D, pa, "1");
		drawNumber(G2D, ru, "1");
		drawNumber(G2D, sb, "1");
		drawNumber(G2D, si, "1");
		drawNumber(G2D, ta, "1");
		drawNumber(G2D, tu, "1");
		
		//repaint();
	}

	private void countryPosition(Graphics g, Graphics2D g2d, String name, int x, int y)
	{
		Font fonte = new Font("Arial", Font.BOLD, 14);
		g2d.setColor(Color.WHITE);
		g.setFont(fonte);
		g.drawString(name,x,y-60);
	}

	private Ellipse2D createCircle(Graphics2D g2d, int x, int y)
	{
		int w = 20;
		int h = 20;
		Ellipse2D circle = new Ellipse2D.Double(x, y-60, w, h);
		g2d.draw(circle);
		return circle;
	}

	private void fillPlayerCircle(Graphics2D g2d, Ellipse2D country, Color playerColor)
	{
		g2d.setColor(playerColor);
		g2d.fill(country);
	}
	
	private void showDices(Graphics2D G2D)
	{
		if (dadoImage_at != null & dadoImage_def != null)
		{
			// Desenhe a borda colorida ao redor da imagem do dado
			G2D.drawImage(dadoImage_at, 1035, 200,32*2,32*2,null);
			G2D.drawImage(dadoImage_def, 1105, 200,32*2,32*2,null);
			
			G2D.setColor(Color.GREEN); // necessário obter a cor do jogador atacante
			G2D.drawRect(1035, 200, 32*2, 32*2);
			G2D.setColor(Color.white);// necessário obter a cor do jogador defensor
			G2D.drawRect(1105, 200, 32*2, 32*2);
		}
	}
	
	private void drawNumber(Graphics2D g2d, Ellipse2D circle, String number)
	{
		//g2d.draw(circle);
		//g2d.fill(circle);
		g2d.setColor(Color.BLACK);
		g2d.drawString(number, (int) circle.getCenterX() - 4, (int) circle.getCenterY() + 5);
	}

	private Image loadImage(String fileName)
	{
    	Image image = null;
    	try {
        	// Carregue a imagem a partir do arquivo
        	image = ImageIO.read(new File(fileName));
    	} catch (IOException e) {
        	e.printStackTrace();
    	}
    	return image;
	}	

}