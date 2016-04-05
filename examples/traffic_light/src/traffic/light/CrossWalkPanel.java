package traffic.light;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import traffic.light.TrafficLight.Alignment;

public class CrossWalkPanel extends JPanel {

	private static final long serialVersionUID = -7137708533029709629L;
	protected TrafficLight trafficLight;
	protected PedestrianLight pedLight;

	
	public CrossWalkPanel() {
		super();
		trafficLight = new TrafficLight(Alignment.HORIZONTAL);
		pedLight = new PedestrianLight(PedestrianLight.Alignment.VERTICAL);
	}
	
	public TrafficLight getTrafficLight() {
		return trafficLight;
	}

	public PedestrianLight getPedLight() {
		return pedLight;
	}

	public void paint(Graphics g) {
		paintCrossing(g);
		paintTrafficLights(g);
		paintPedestrainLights(g);
		g.dispose();
	}

	protected void paintPedestrainLights(Graphics g) {
		pedLight.updatePosition(new Point(210, 80));
		pedLight.paint(g);
	}

	protected void paintTrafficLights(Graphics g) {
		trafficLight.updatePosition(new Point(170, 280));
		trafficLight.paint(g);
	}

	protected void paintCrossing(Graphics g) {
	
		int width = getSize().width;

		int streetYOffset = 150;
		int streetWidth = 100;
		
		Dimension streetEastWest = new Dimension(width, streetWidth);
		g.setColor(Color.darkGray);
		paint(streetEastWest, 0, streetYOffset, true, g);

		
		g.setColor(Color.white);

		Dimension laneSeparator = new Dimension(20, 4);
		for (int i=0; i<4; i++) {
			paint(laneSeparator, i * 2 * laneSeparator.width , streetYOffset -2 + streetWidth / 2, true, g);			
		}

		Dimension stopLine = new Dimension(10, streetWidth/2 +2);
		paint(stopLine, 7 * laneSeparator.width , streetYOffset -2 + streetWidth / 2, true, g);			
		
		Dimension zebraStripe = new Dimension(80, 10);
		
		paint(zebraStripe, 9 * laneSeparator.width , streetYOffset + 5, true, g);			
		paint(zebraStripe, 9 * laneSeparator.width , streetYOffset + 25 , true, g);			
		paint(zebraStripe, 9 * laneSeparator.width , streetYOffset + 45 , true, g);			
		paint(zebraStripe, 9 * laneSeparator.width , streetYOffset + 65 , true, g);			
		paint(zebraStripe, 9 * laneSeparator.width , streetYOffset + 85 , true, g);		
		
		
		paint(stopLine, 11 * laneSeparator.width + zebraStripe.width - stopLine.width, streetYOffset, true, g);			

		for (int i=0; i<4; i++) {
			paint(laneSeparator, (i * 2 + 11) * laneSeparator.width + zebraStripe.width, streetYOffset -2 + streetWidth / 2, true, g);			
		}	
	
	}

	
	protected void paint(Dimension area, int x, int y, boolean horizontally, Graphics g) {
		g.fillRect(x, y, 
				horizontally ? area.width : area.height, 
				horizontally ? area.height : area.width);

	}
}
