package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapMouseListener extends MouseAdapter implements MouseListener {
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		 // Obtém as coordenadas do clique
        int x = e.getX();
        int y = e.getY();

        // Verifica se as coordenadas estão dentro da área de um território
        if (isInsideTerritory(x, y)) {
            // O clique está dentro de um território, faça algo aqui
            System.out.println("Clique dentro de um território");
        }
	}
    
        private boolean isInsideTerritory(int x, int y) {
            // Implemente lógica para verificar se as coordenadas estão dentro de um território
            // Por exemplo, você pode ter uma lista de polígonos representando territórios e verificar a inclusão.
            // Aqui, estou usando um exemplo simples de um retângulo para demonstração.
            int territoryX = 100; // Coordenada X do canto superior esquerdo do território
            int territoryY = 100; // Coordenada Y do canto superior esquerdo do território
            int territoryWidth = 50; // Largura do território
            int territoryHeight = 50; // Altura do território

            return x >= territoryX && x <= territoryX + territoryWidth &&
                   y >= territoryY && y <= territoryY + territoryHeight;
        }   
        
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
