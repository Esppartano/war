package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Menu
{
    private JFrame menuFrame, selectionFrame, PlayerFrame, gameFrame;
    private final int width = 1200;
    private final int height = 700;
    // Delimita a janela
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int sw = screenSize.width;
    int sh = screenSize.height;
    int x = sw / 2 - width / 2;
    int y = sh / 2 - height / 2;
    
    public Menu()
    {    
        // Cria a janela do menu
        menuFrame = new JFrame("Menu do Jogo");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setBounds(x, y, width/4, height/2);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);
        Container c = menuFrame.getContentPane();
        
        JButton newGameButton = new JButton("Nova Partida");
        newGameButton.addActionListener(e -> selectPlayers());
        
        JButton continueGameButton = new JButton("Continuar");
        continueGameButton.addActionListener(e -> continueGame());
        //Fonte personalizada
        Font font = new Font("Times New Roman", Font.BOLD,20);
        newGameButton.setFont(font);
        continueGameButton.setFont(font);
        
     // Adiciona os botões ao painel do menu
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        newGameButton.setToolTipText("irá sobreescrever dados salvos");
        continueGameButton.setToolTipText("continue do último ponto salvo");
        newGameButton.setBounds((width/8)-75 ,(height/4)-120,150,50);
        continueGameButton.setBounds((width/8)-75 ,(height/4)-50,150,50);
        panel.setBackground(Color.white);
        c.add(newGameButton);
        c.add(continueGameButton);
        c.add(panel);
       
        // Mostra a janela do menu
        menuFrame.setVisible(true);
    }
    
    public void selectPlayers()
    {
    	selectionFrame = new JFrame("Seleção de Jogadores");
    	selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	selectionFrame.setSize(300, 400);
    	selectionFrame.setResizable(false);
    	selectionFrame.setLocationRelativeTo(menuFrame);
    	selectionFrame.setLayout(null);
    	
    	// Cria um botão "Iniciar Partida" para confirmar a seleção
        JButton startGameButton = new JButton("Iniciar Partida");
        
    	// Cria um painel para seleção do número de jogadores
        //JPanel playerSelectionPanel = new JPanel();
        JLabel selectPL = new JLabel("Selecione o número de jogadores: ");
        Container c = selectionFrame.getContentPane();
       
        //Cria os botões de jogadores
        Font font = new Font("Times New Roman", Font.BOLD,14);
        JRadioButton p3 = new JRadioButton("3 Jogadores");
        JRadioButton p4 = new JRadioButton("4 Jogadores");
        JRadioButton p5 = new JRadioButton("5 Jogadores");
        JRadioButton p6 = new JRadioButton("6 Jogadores");
        ButtonGroup party = new ButtonGroup();
        p3.setFont(font);
        p4.setFont(font);
        p5.setFont(font);
        p6.setFont(font);
        
        // Adiciona os radio buttons ao grupo   
        party.add(p3);
        party.add(p4);
        party.add(p5);
        party.add(p6);
        // Adicione mais radio buttons ao grupo conforme necessário
        selectPL.setBounds((width/8) - 125,(height/4)-200,200,100);
        p3.setBounds(50,80,100,30);
        p4.setBounds(50,110,100,30);
        p5.setBounds(50,140,100,30);
        p6.setBounds(50,170,100,30);
        startGameButton.setBounds(50,250,200,30);
        
        // Adicione os componentes ao painel
        c.add(selectPL);    
        c.add(p3);
        c.add(p4);
        c.add(p5);
        c.add(p6);
        c.add(startGameButton);
        
        // Configure o ActionListener para o botão "Iniciar Partida"
        startGameButton.addActionListener(e ->
        {
            int selectedPlayers = 0; // Valor padrão
            if (p3.isSelected()) {
                selectedPlayers = 3;
            } else if (p4.isSelected()) {
                selectedPlayers = 4;
            } else if (p5.isSelected()) {
            	selectedPlayers = 5;
            } else if (p6.isSelected()) {
            	selectedPlayers = 6;
            } 
            if (selectedPlayers == 0) {
            	JOptionPane.showMessageDialog(selectionFrame, "Escolha a quantidade dos jogadores.", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
            }else {
            	selectColor_Name(selectedPlayers);
            	selectionFrame.setVisible(false);	
            }
        });
        
       // selectionFrame.add(playerSelectionPanel);
        selectionFrame.setVisible(true);
        menuFrame.setVisible(false);
        //menuFrame.setOpacity(.2f);
    }
      
    public void selectColor_Name(int num)
    {
        PlayerFrame = new JFrame("Seleção de Jogadores");
        PlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayerFrame.setSize(300, 400);
        PlayerFrame.setResizable(false);
        PlayerFrame.setLocationRelativeTo(menuFrame);
        JPanel playerInfoPanel = new JPanel();
        JButton confirmButton = new JButton("Confirmar");
        JButton randonColor = new JButton("Randomizar");
        randonColor.setToolTipText("Defina cores aleatórias para os jogadores");
        
        playerInfoPanel.setLayout(null);
        
        // Arrays para armazenar cores e nomes dos jogadores
        Color[] playerColors = new Color[num];
        String[] playerNames = new String[num];
        JTextField[] nameFields = new JTextField[num];
        String[] colorOptions = {"Cor", "Vermelho", "Verde", "Azul", "Amarelo", "Preto", "Branco"};
        JComboBox<String>[] colorComboBoxes = new JComboBox[num];
        for (int i = 0; i < num; i++)
        {
            // Adicione um campo de texto para o nome do jogador
            JTextField nameField = new JTextField("Jogador " + (i + 1));
            nameField.setBounds(40,40*(i+1),100, 20);
            nameFields[i] = nameField;
            playerInfoPanel.add(nameField);

            // Crie um JComboBox para selecionar a cor
            JComboBox<String> colorComboBox = new JComboBox<>(colorOptions);
            colorComboBox.setBounds(150, 40*(i+1), 100, 20);
            colorComboBoxes[i] = colorComboBox;
            playerInfoPanel.add(colorComboBox);       
        }
        
        randonColor.addActionListener(e -> 
        {
            // Cria uma lista das opções de cores
            ArrayList<String> colorList = new ArrayList<>(Arrays.asList(colorOptions));

            // Remove a opção "Cor"
            colorList.remove("Cor");

            // Embaralha a lista
            Collections.shuffle(colorList);

            for (int i = 0; i < num; i++)
            {
                // Obtém a cor do início da lista
                String randomColor = colorList.get(i);

                // Encontra o índice dessa cor nas opções de cores
                int colorIndex = Arrays.asList(colorOptions).indexOf(randomColor);

                // Define a cor do jogador para a cor aleatória
                colorComboBoxes[i].setSelectedIndex(colorIndex);
            }
        });

        confirmButton.addActionListener(e ->
        {
            // Verifique se todos os jogadores fizeram sua seleção
            boolean allPlayersSelected = false;
            System.out.println(num);
            for (int j = 0; j < num; j++)
            {
                playerNames[j] = nameFields[j].getText();
                // Obtenha a cor selecionada no JComboBox
                String selectedColor = (String) colorComboBoxes[j].getSelectedItem();
                // Converta a string da cor em uma instância de java.awt.Color
                Color color = getColorForName(selectedColor);
                playerColors[j] = color;
                if (playerColors[j] == null || playerNames[j].isEmpty())
                {
                    allPlayersSelected = false;
                    System.out.println(allPlayersSelected);
                    break;
                }
                else
                    allPlayersSelected = true;
            }
                if (allPlayersSelected==true)
                    startGame(num, playerColors, playerNames);
                else 
                    JOptionPane.showMessageDialog(PlayerFrame, "Preencha o nome e escolha a cor para todos os jogadores.", "Atenção!!!", JOptionPane.WARNING_MESSAGE);
        });

        randonColor.setBounds(40,280,210,30);
        confirmButton.setBounds(40, 320, 210, 30);
        playerInfoPanel.add(confirmButton);
        playerInfoPanel.add(randonColor);
        PlayerFrame.getContentPane().add(playerInfoPanel);
        PlayerFrame.setVisible(true);
    }

    // Função para converter o nome da cor em uma instância de java.awt.Color
    private Color getColorForName(String colorName)
    {
        return switch (colorName)
        {
            case "Vermelho" -> Color.RED;
            case "Verde" -> Color.GREEN;
            case "Azul" -> Color.BLUE;
            case "Amarelo" -> Color.YELLOW;
            case "Preto" -> Color.BLACK;
            case "Branco" -> Color.WHITE;
            case "Cor" -> null;
            default -> null;
        };
    }
    
    public void startGame(int numPlayers, Color[] playerColors, String[] playerNames)
    {
        // Crie a janela do jogo
        gameFrame = new JFrame("WAR - Jogo");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(width,height);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(menuFrame);
        
        for(int i = 0; i<numPlayers;i++)
        {
            System.out.println(playerNames[i]+" "+playerColors[i]+"\n");
        }
        
        // Adição do tabuleiro
        gameFrame.getContentPane().add(new Tabuleiro(this, numPlayers, playerColors, playerNames));
       
        // Mostra a janela do jogo e oculta a janela de seleção de jogadores
        gameFrame.setVisible(true);
        PlayerFrame.setVisible(false);    
    }

    public void saveGame()
    {
        JOptionPane.showMessageDialog(null,"Jogo salvo" , "Salvando...", JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("Jogo Salvo");
    }
    
    private void continueGame()
    {
      // Implemente a lógica para continuar o jogo aqui
  		//resgata o jogo salvo
      // Mostra a janela do jogo e oculta a janela do menu
      gameFrame.setVisible(true);
      menuFrame.setVisible(false);
    }

    public void endGame()
    {
        String nomeVencedor = "Jogador teste"; 
        //Color corVencedor = Color.RED; // Substituir pela cor real do vencedor

        JOptionPane.showMessageDialog(null, nomeVencedor  + " venceu a partida." , "Vitória!!!", JOptionPane.INFORMATION_MESSAGE);
        int opcao = JOptionPane.showConfirmDialog(null, "Desejam continuar jogando?", "Continuar ou Sair?", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION)
        {
            gameFrame.setVisible(false);
            selectionFrame.setVisible(True);
            // Reinicia a partida e retorna à janela de seleção de jogadores
        } else {
            // Encerra o jogo ou saia do programa
            System.exit(0);
        }    
}
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Menu());     
    }
}

