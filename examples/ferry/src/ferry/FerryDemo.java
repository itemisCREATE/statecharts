/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package ferry;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ferry.ferryctrl.FerryctrlStatemachine;
import ferry.ferryctrl.IFerryctrlStatemachine;
import ferry.ferryctrl.SynchronizedFerryctrlStatemachineWrapper;

/**
 * 
 * @author Enste
 * 
 */

public class FerryDemo extends JFrame {
	
	private static final long serialVersionUID = 7593810673488331359L;
	
	private SynchronizedFerryctrlStatemachineWrapper statemachine;
	
	private TimerService timer;
	
	private Background background;
	
	private Ferry ferry;
	
	private Good goose,wolf,corn;
	
	private Clip horn;
	
	private boolean updateOk,adjustCorn,adjustGoose,adjustWolf;
	
	public static void main(String[] args) {
		new FerryDemo();
	}
	
	public FerryDemo() {
		initJava();
		initSCT();
		run();
	}
	
	private void initJava() {
		Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
		String t = System.getProperty("file.separator");
		updateOk = true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("The river crossing puzzle");
		setSize(1000,600);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocation((int)Math.round(s.getWidth()*0.5-getWidth()*0.5),(int)Math.round(s.getHeight()*0.5-getHeight()*0.5));
		ferry = new Ferry();
		add(ferry);
		ferry.setSize(250,125);
		ferry.setLocation((int)Math.round(getContentPane().getWidth()*0.5-0.5*ferry.getWidth()),(int)Math.round(getContentPane().getHeight()-getContentPane().getHeight()*0.39-0.5*ferry.getHeight()));
		background = new Background();
		add(background);
		background.setBounds(0,(int)Math.round(getContentPane().getHeight()*0.5),getContentPane().getWidth(),(int)Math.round(getContentPane().getHeight()*0.5));
		ferry.setYLeft((int)Math.round(0.075*getContentPane().getWidth()));
		ferry.setYRight((int)Math.round(getContentPane().getWidth()-getContentPane().getWidth()*0.075-ferry.getWidth()));
		try {
			corn = new Good(ImageIO.read(new File("src"+t+"corn.png")),(int)Math.round((getContentPane().getWidth()*0.1)*0.9),(int)Math.round((getContentPane().getHeight()*0.5/3)*0.9));
			corn.setLocation(0,0);
			add(corn);
			corn.repaint();
			goose = new Good(ImageIO.read(new File("src"+t+"goose.png")),(int)Math.round((getContentPane().getWidth()*0.1)*0.9),(int)Math.round((getContentPane().getHeight()*0.5/3)*0.9));
			goose.setLocation(0,(int)Math.round(getContentPane().getHeight()*0.5/3));
			add(goose);
			goose.repaint();
			wolf = new Good(ImageIO.read(new File("src"+t+"wolf.png")),(int)Math.round((getContentPane().getWidth()*0.1)*0.9),(int)Math.round((getContentPane().getHeight()*0.5/3)*0.9));
			wolf.setLocation(0,(int)Math.round(getContentPane().getHeight()*1.0/3));
			add(wolf);
			wolf.repaint();
			
			horn = AudioSystem.getClip();
			horn.open(AudioSystem.getAudioInputStream(new File("src"+t+"boat_horn.wav")));
		} catch(Exception ex) {ex.printStackTrace();}
		background.getLeftShoreButton().addActionListener(e -> buttonPressed(background.getLeftShoreButton()));
		background.getRightShoreButton().addActionListener(e -> buttonPressed(background.getRightShoreButton()));
		ferry.getLeftFerryButton().addActionListener(e -> buttonPressed(ferry.getLeftFerryButton()));
		ferry.getRightFerryButton().addActionListener(e -> buttonPressed(ferry.getRightFerryButton()));
		corn.addActionListener(e -> buttonPressed(corn));
		goose.addActionListener(e -> buttonPressed(goose));
		wolf.addActionListener(e -> buttonPressed(wolf));
	}
	
	private void initSCT() {
		statemachine = new SynchronizedFerryctrlStatemachineWrapper();
		timer = new TimerService();
		statemachine.setTimer(timer);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(new IFerryctrlStatemachine.SCInterfaceOperationCallback() {
			
			@Override
			public void synchronize() {
				update();
				
			}
		});
		statemachine.init();
	}
	
	private void run() {
		statemachine.enter();
		RuntimeService.getInstance().registerStatemachine(statemachine, 100);
		ferry.setFerryLocation(0);
	}
	
	private void buttonPressed(JButton bt) {
		if(bt == background.getLeftShoreButton()) {
			playHorn();
			statemachine.getSCInterface().raiseLeftShoreButton();
		} else if(bt == background.getRightShoreButton()) {
			playHorn();
			statemachine.getSCInterface().raiseRightShoreButton();
		} else if(bt == ferry.getLeftFerryButton()) {
			playHorn();
			statemachine.getSCInterface().raiseLeftFerryButton();
		} else if(bt == ferry.getRightFerryButton()) {
			playHorn();
			statemachine.getSCInterface().raiseRightFerryButton();
		} else if(bt == corn) {
			if(statemachine.getSCIFerry().getIsLeft()) statemachine.getSCICorn().raiseLoadleft();
			else statemachine.getSCICorn().raiseLoadright();
			if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_corn_region_Corn_Left)) {
				adjustCorn = false;
				corn.setLocation(0,0);
				bt.setText("Load");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_corn_region_Corn_Onboard)) {
				adjustCorn = true;
				bt.setText("Unload");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_corn_region_Corn_Right)) {
				adjustCorn = false;
				corn.setLocation(getContentPane().getWidth()-corn.getWidth(),0);
				bt.setText("Load");
			}
		} else if(bt == goose) {
			if(statemachine.getSCIFerry().getIsLeft()) statemachine.getSCIGoose().raiseLoadleft();
			else statemachine.getSCIGoose().raiseLoadright();
			if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_goose_region_Goose_Left)) {
				adjustGoose = false;
				goose.setLocation(0,(int)Math.round(getContentPane().getHeight()*0.5/3));
				bt.setText("Load");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_goose_region_Goose_Onboard)) {
				adjustGoose = true;
				bt.setText("Unload");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_goose_region_Goose_Right)) {
				adjustGoose = false;
				goose.setLocation(getContentPane().getWidth()-goose.getWidth(),(int)Math.round(getContentPane().getHeight()*0.5/3));
				bt.setText("Load");
			}
		} else if(bt == wolf) {
			if(statemachine.getSCIFerry().getIsLeft()) statemachine.getSCIWolf().raiseLoadleft();
			else statemachine.getSCIWolf().raiseLoadright();
			if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_wolf_region_Wolf_Left)) {
				adjustWolf = false;
				wolf.setLocation(0,(int)Math.round(getContentPane().getHeight()*1.0/3));
				bt.setText("Load");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_wolf_region_Wolf_Onboard)) {
				adjustWolf = true;
				bt.setText("Unload");
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_Playing_State_wolf_region_Wolf_Right)) {
				adjustWolf = false;
				wolf.setLocation(getContentPane().getWidth()-wolf.getWidth(),(int)Math.round(getContentPane().getHeight()*1.0/3));
				bt.setText("Load");
			}
			corn.repaint();
			goose.repaint();
			wolf.repaint();
		}
	}
	
	private void playHorn() {
		if(horn != null && !horn.isRunning() && !statemachine.getSCIFerry().getMoving()) {
			try {
				horn.setMicrosecondPosition(0);
				horn.start();
			} catch(Exception e) {e.printStackTrace();}
		}
	}
	
	private void restart() {
		statemachine.exit();
		RuntimeService.getInstance().cancelTimer();
		System.gc();
		initSCT();
		run();
		wolf.setLocation(0,(int)Math.round(getContentPane().getHeight()*1.0/3));
		goose.setLocation(0,(int)Math.round(getContentPane().getHeight()*0.5/3));
		corn.setLocation(0,0);
		JButton[] btarr = {corn,goose,wolf};
		for(JButton bt : btarr) {
			bt.doClick();
			bt.doClick();
		}
	}
	
	private void update() {
		if(updateOk) {
			updateOk = false;
			if(statemachine.isStateActive(FerryctrlStatemachine.State.main_region_Moving_Left)) {
				ferry.setFerryLocation(ferry.getFerryLocation() - 0.01);
				if(ferry.getFerryLocation()<0.0) {
					statemachine.getSCIFerry().raiseLeftBumper();
					ferry.setFerryLocation(0.0);
				}
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.main_region_Moving_Right)) {
				ferry.setFerryLocation(ferry.getFerryLocation() + 0.01);
				if(ferry.getFerryLocation()>1.0) {
					statemachine.getSCIFerry().raiseRightBumper();
					ferry.setFerryLocation(1.0);
				}
			}
			if(adjustCorn) {
				corn.setLocation((int)Math.round(ferry.getX()+ferry.getWidth()*0.5-corn.getWidth()*0.5),(int)Math.round(ferry.getY()-corn.getHeight()));
			}
			if(adjustGoose) {
				goose.setLocation((int)Math.round(ferry.getX()+ferry.getWidth()*0.5-goose.getWidth()*0.5),(int)Math.round(ferry.getY()-goose.getHeight()));
			}
			if(adjustWolf) {
				wolf.setLocation((int)Math.round(ferry.getX()+ferry.getWidth()*0.5-corn.getWidth()*0.5),(int)Math.round(ferry.getY()-corn.getHeight()));
				
			}
			corn.repaint();
			goose.repaint();
			wolf.repaint();
			if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_End_of_Game_endgame_region_Win)) {
				int var = JOptionPane.showOptionDialog(this, "Excellent! You won the Game!\nDo you want to play again?","You won the Game!",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,new String[]{"Yes", "No"}, "Yes");
				if(var==JOptionPane.YES_OPTION) {
					restart();
				} else {
					System.exit(0);
				}
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_End_of_Game_endgame_region_Lost_Wolf_Goose)) {
				int var = JOptionPane.showOptionDialog(this, "Ups! Your wolf has eaten your goose\n Do you want to try it again?","You lost",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,new String[]{"Yes", "No"}, "Yes");
				if(var==JOptionPane.YES_OPTION) {
					restart();
				} else {
					System.exit(0);
				}
			} else if(statemachine.isStateActive(FerryctrlStatemachine.State.gameplay_region_End_of_Game_endgame_region_Lost_Goose_Corn)) {
				int var = JOptionPane.showOptionDialog(this, "Ups! Your goose has eaten your corn\n Do you want to try it again?","You won the Game!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,new String[]{"Yes", "No"}, "Yes");
				if(var==JOptionPane.YES_OPTION) {
					restart();
				} else {
					System.exit(0);
				}
			}
			updateOk = true;
		}
	}
}
