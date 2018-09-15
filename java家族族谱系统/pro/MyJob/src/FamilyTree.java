import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.EmeraldDuskSkin;


public class FamilyTree {
	public static void main(String[] args) {
		 try {
	            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
	            JFrame.setDefaultLookAndFeelDecorated(true);
	            JDialog.setDefaultLookAndFeelDecorated(true);
	           SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
//	          SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
//	          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
//	          SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
//	            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
//	            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
	        } catch (Exception e) {
	            System.err.println("Something went wrong!");
	        }
	      FTFrame f = new FTFrame();
	      f.Layout();
	      f.showBrithday();
	}
}
