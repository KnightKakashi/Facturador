/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.*;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * La clase JComboBoxImagenes extiende DefaultListCellRenderer para crear un JComboBox personalizado
 * que muestra tanto texto como imágenes.
 * @author dam2
 */

//
public class JComboBoxImagenes extends DefaultListCellRenderer {
    private String[] items;
    private ImageIcon[] icons;

    /**
     * Constructor para inicializar el JComboBoxImagenes con elementos de texto e iconos.
     *  @param items Array de elementos de texto que se mostrarán en el JComboBox 
     * @param icons Array de iconos correspondientes a cada elemento de texto 
     */
    public JComboBoxImagenes(String[] items, ImageIcon[] icons) {
        this.items = items;
        this.icons = icons;
    }

    /** 
     * Sobrescribe el método getListCellRendererComponent para personalizar la representación de cada celda 
     * en el JComboBox. 
     * @param list El JList que estamos pintando.
     * @param value El valor devuelto por list.getModel().getElementAt(index).
     * @param index El índice de la celda. * @param isSelected Verdadero si la celda especificada fue seleccionada.
     * @param cellHasFocus Verdadero si la celda especificada tiene el foco.
     * @return Un componente cuyo método paint() renderizará el valor especificado. 
     */
    
    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        //Configuración básica
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        //Asignar texto y, si existe, el icono
        if(index >= 0 && index < items.length) {
            label.setText(items[index]);
            if(icons[index] != null) {
                label.setIcon(icons[index]);
            } else {
                label.setIcon(null); // Asegurar que no quede un icono previo
            }
        }

        return label;
    }
}