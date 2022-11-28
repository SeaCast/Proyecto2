package proyecto2;

  /**
 *
 * @author Yargen
 * @version 21/11/2022
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ArbolExpresionGrafica extends JPanel 
{
    private final binaryTree miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private final int parent2child = 20, child2child = 15;
    private final Dimension empty = new Dimension(0,0);
    private FontMetrics fm = null;
    
    
    /**
     * Constructor de la clase ArbolExpresionGrafico.
     * El constructor permite inicializar los atributos de la clase ArbolExpresionGrafico
     * y llama al método repaint(), que es el encargado de pintar el Arbol.
     * @param miArbol: dato de tipo binaryTree que contiene el Arbol a
     * dibujar.
     */
    public ArbolExpresionGrafica(binaryTree miArbol) 
    {
          this.miArbol = miArbol;
          this.setBackground(Color.WHITE);
          posicionNodos = new HashMap();
          subtreeSizes = new HashMap();
          dirty = true;
          repaint();      
    }


    /**
     * Calcula las posiciones de los respectivos subárboles y de cada nodo que 
     * forma parte de él, para saber en donde van a ir dibujados
     * los rectángulos del arbol.
     */
    private void calcularPosiciones() 
    {
         posicionNodos.clear();
         subtreeSizes.clear();
         binaryNode root = this.miArbol.getRoot();
         if (root != null) 
         {
             calcularTamañoSubarbol(root);
             calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
         }
    }
    
    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de la clase
     * HashMap que va a contener la coleccion de todos los 
     * subárboles del arbol de expresión.
     * @param n:Objeto de la clase binaryNode que se utiliza como
     * referencia al calcular el tamaño de cada subárbol.
     * @return Dimension con el tamaño de cada subárbol.
     */
    private Dimension calcularTamañoSubarbol(binaryNode n) 
    {
          if (n == null) 
              return new Dimension(0,0);
 
          Dimension ld = calcularTamañoSubarbol(n.getLeft());
          Dimension rd = calcularTamañoSubarbol(n.getRight());
          
          int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
          int w = ld.width + child2child + rd.width;
          
          Dimension d = new Dimension(w, h);
          subtreeSizes.put(n, d);
          
          return d;
    }
    
    
    /**
     * Calcula la ubicación de cada nodo de cada subárbol y agrega cada nodo con 
     * un objeto de tipo Rectangule que tiene la ubicación y la información específica de dónde 
     * va a ser dibujado.
     * @param n: Objeto de tipo binaryNode que se utiliza como
     * referencia para calcular la ubicación de cada nodo.
     * @param left: int con alineación y orientación a la izquierda.
     * @param right: int con alineación y orientación a la derecha.
     * @param top: int con el tope.
     */
    private void calcularPosicion(binaryNode n, int left, int right, int top) 
    {
      if (n == null) 
          return;
      
      Dimension ld = (Dimension) subtreeSizes.get(n.getLeft());
      if (ld == null) 
          ld = empty;
      
      Dimension rd = (Dimension) subtreeSizes.get(n.getRight());
      if (rd == null) 
          rd = empty;
      
      int center = 0;
      
      if (right != Integer.MAX_VALUE)
          center = right - rd.width - child2child/2;
      else if (left != Integer.MAX_VALUE)
          center = left + ld.width + child2child/2;
      int width = fm.stringWidth(n.getData()+"");
 
      posicionNodos.put(n,new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
      
      calcularPosicion(n.getLeft(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
      calcularPosicion(n.getRight(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }
    
    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los 
     * subárboles calculadas anteriormente.
     * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de las líneas, rectangulos y del String de la información que contiene el Nodo.
     * @param n: Objeto de la clase binary Node que se utiliza como referencia para dibujar el árbol.
     * @param puntox: int con la posición en x desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param puntoy: int con la posición en y desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param yoffs: int con la altura del FontMetrics.
     */
    private void dibujarArbol(Graphics2D g, binaryNode n, int puntox, int puntoy, int yoffs) 
    {
     if (n == null) 
         return;
     
     Rectangle r = (Rectangle) posicionNodos.get(n);
     g.draw(r);
     g.drawString(n.getData()+"", r.x + 3, r.y + yoffs);
   
     if (puntox != Integer.MAX_VALUE)
       
     g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
     
     dibujarArbol(g, n.getLeft(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
     dibujarArbol(g, n.getRight(),(int)(r.x + r.width/2), r.y + r.height, yoffs);
     
     
   }
    

   /**
     * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
     * @param g: Objeto de la clase Graphics.
     */
    @Override
   public void paint(Graphics g) 
   {
         super.paint(g);
         fm = g.getFontMetrics();

         if (dirty) 
         {
           calcularPosiciones();
           dirty = false;
         }
         
         Graphics2D g2d = (Graphics2D) g;
         g2d.translate(getWidth() / 2, parent2child);
         dibujarArbol(g2d, this.miArbol.getRoot(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
         fm.getLeading() + fm.getAscent());
         fm = null;
   }
   
 }
