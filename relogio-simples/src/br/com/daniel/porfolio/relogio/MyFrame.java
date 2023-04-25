package br.com.daniel.porfolio.relogio;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
	
//	Calendar calendar; na real não preciso dessa instancia por que estou chamando o metodo no loop
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	public MyFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Relógico");
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setResizable(false);
		
		timeLabel = new JLabel();
		
		timeFormat = new SimpleDateFormat("HH:mm:ss");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(0x00ff00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		dayLabel.setOpaque(true);
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		dateLabel.setOpaque(true);
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	
	public void setTime() {
		while (true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
