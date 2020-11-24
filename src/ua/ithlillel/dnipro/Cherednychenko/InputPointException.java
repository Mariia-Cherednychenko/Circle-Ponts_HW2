package ua.ithlillel.dnipro.Cherednychenko;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class InputPointException extends Exception {

    public void message() {
        super.getMessage();
        System.out.println("Incorrect input. Please try again. You should enter digits in the required format");

    }
}
