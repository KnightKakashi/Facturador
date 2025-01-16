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
 *
 * @author dam2
 */


//
public class JComboBoxImagenes extends DefaultListCellRenderer {
    private String[] items;
    private ImageIcon[] icons;

    public JComboBoxImagenes(String[] items, ImageIcon[] icons) {
        this.items = items;
        this.icons = icons;
    }

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        // Configuración básica
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Asignar texto y, si existe, el icono
        if (index >= 0 && index < items.length) {
            label.setText(items[index]);
            if (icons[index] != null) {
                label.setIcon(icons[index]);
            } else {
                label.setIcon(null); // Asegurar que no quede un icono previo
            }
        }

        return label;
    }
}