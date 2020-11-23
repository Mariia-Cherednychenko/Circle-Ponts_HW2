package ua.ithlillel.dnipro.Cherednychenko;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

public class InputPointException extends IOException {
    public void message() {
        System.out.println("Inorrect input. Please try again. You should enter digits in the required format");
    }
}
