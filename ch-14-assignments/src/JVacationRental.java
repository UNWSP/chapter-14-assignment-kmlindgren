import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JVacationRental extends JFrame implements ItemListener {
	final int PARK_PRICE = 600;
	final int POOL_PRICE = 750;
	final int LAKE_PRICE = 825;
	final int EXTRA_ROOM_PRICE = 75;
	final int MEAL_PRICE = 200;
	int totalPrice;
	int numOfRooms;
	
	JCheckBox parkBox = new JCheckBox("Parkside", false);
	JCheckBox poolBox = new JCheckBox("Poolside", false);
	JCheckBox lakeBox = new JCheckBox("Lakeside", false);
	ButtonGroup locBoxes = new ButtonGroup();
	
	JCheckBox oneRmBox = new JCheckBox("One bedroom", false);
	JCheckBox twoRmBox = new JCheckBox("Two bedrooms", false);
	JCheckBox threeRmBox = new JCheckBox("Three bedrooms", false);
	ButtonGroup roomBoxes = new ButtonGroup();
	
	JCheckBox mealBox = new JCheckBox("Include meals", false);
	
	JLabel priceLabel = new JLabel("The price for your stay is");
	JTextField totPrice = new JTextField(4);
		
	public JVacationRental() {
		super("Lambert's Vacation Rentals");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		
		locBoxes.add(parkBox);
		locBoxes.add(poolBox);
		locBoxes.add(lakeBox);
		
		roomBoxes.add(oneRmBox);
		roomBoxes.add(twoRmBox);
		roomBoxes.add(threeRmBox);
		
		setLayout(new FlowLayout());
		add(parkBox);
		add(poolBox);
		add(lakeBox);
		add(oneRmBox);
		add(twoRmBox);
		add(threeRmBox);
		add(mealBox);
		add(priceLabel);
		add(totPrice);
		
		totPrice.setText("$" + totalPrice);
		parkBox.addItemListener(this);
		poolBox.addItemListener(this);
		lakeBox.addItemListener(this);
		oneRmBox.addItemListener(this);
		twoRmBox.addItemListener(this);
		threeRmBox.addItemListener(this);
		mealBox.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		int select = e.getStateChange();
		
		if(source == parkBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += PARK_PRICE;
			} else {
				totalPrice -= PARK_PRICE;
			}
		} else if(source == poolBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += POOL_PRICE;
			} else {
				totalPrice -= POOL_PRICE;
			}
		} else if(source == lakeBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += LAKE_PRICE;
			} else {
				totalPrice -= LAKE_PRICE;
			}
		} else if(source == oneRmBox) {
			if(select == ItemEvent.SELECTED) {
				numOfRooms = 1;
			}
		} else if(source == twoRmBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += EXTRA_ROOM_PRICE;
				numOfRooms = 2;
			} else {
				totalPrice -= EXTRA_ROOM_PRICE;
			}
		} else if(source == threeRmBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += (EXTRA_ROOM_PRICE * 2);
				numOfRooms = 3;
			} else {
				totalPrice -= (EXTRA_ROOM_PRICE * 2);
			}
		} else if(source == mealBox) {
			if(select == ItemEvent.SELECTED) {
				totalPrice += (MEAL_PRICE * numOfRooms);
			} else {
				totalPrice -= (MEAL_PRICE * numOfRooms);
			}
		} 
		totPrice.setText("$" + totalPrice);
	}
	
	public static void main(String[] args) {
		JVacationRental aFrame = new JVacationRental();
		final int WIDTH = 300;
		final int HEIGHT = 200;
		aFrame.setSize(WIDTH, HEIGHT);
		aFrame.setVisible(true);
	}
}
