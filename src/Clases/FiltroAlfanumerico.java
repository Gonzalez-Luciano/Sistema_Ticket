/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.text.*;

/**
 *
 * @author TuKK
 */
public class FiltroAlfanumerico extends DocumentFilter {

    private final int maxLength;

    public FiltroAlfanumerico(int maxLength) {
        this.maxLength = maxLength;
    }

    private boolean esValido(String text, int newLength) {
        return text != null && text.matches("[\\p{L}\\p{N}\\s]+") && (newLength <= maxLength);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        int newLength = fb.getDocument().getLength() + string.length(); // Nueva longitud después de la inserción
        if (esValido(string, newLength)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        int newLength = fb.getDocument().getLength() - length + text.length(); // Calcula la nueva longitud
        if (esValido(text, newLength)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
