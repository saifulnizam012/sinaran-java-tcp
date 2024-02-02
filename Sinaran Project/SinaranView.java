import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class SinaranView extends JFrame implements ActionListener{

	private JPanel contentPane;
	JTextArea txtrChat;
	JTextField tfInput;
	String userInput;
	boolean userResponded;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinaranView frame = new SinaranView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SinaranView() {
		this.setTitle("Cuba Teka !");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1100,700);
        this.contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(100,100,100,100));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("SINARAN AND FRIENDS");
		lblTitle.setVisible(true);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));
		lblTitle.setBounds(308, 10, 467, 35);
		contentPane.add(lblTitle);
		
		tfInput = new JTextField();
		tfInput.setVisible(true);
		tfInput.setBounds(652, 450, 319, 32);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		tfInput.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(651, 80, 350, 289);
		contentPane.add(scrollPane);
		
		txtrChat = new JTextArea();
		txtrChat.setVisible(true);
		txtrChat.setEditable(false);
		scrollPane.setViewportView(txtrChat);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(true);
		Image img = new ImageIcon(this.getClass().getResource("/petlaie.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(318, 51, 201, 229);
		contentPane.add(lblNewLabel);
		
		JLabel lblMuhammadPetlai = new JLabel("Shamiel");
		lblMuhammadPetlai.setVisible(true);
		lblMuhammadPetlai.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMuhammadPetlai.setBounds(119, 272, 121, 35);
		contentPane.add(lblMuhammadPetlai);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVisible(true);
		Image imgg = new ImageIcon(this.getClass().getResource("/shamiel.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(imgg));
		lblNewLabel_1.setBounds(97, 65, 173, 197);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPetlai = new JLabel("Fareez");
		lblPetlai.setVisible(true);
		lblPetlai.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPetlai.setBounds(369, 272, 87, 35);
		contentPane.add(lblPetlai);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setVisible(true);
		Image imggg = new ImageIcon(this.getClass().getResource("/saiful2.jpg")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(imggg));
		lblNewLabel_1_1.setBounds(147, 317, 330, 180);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblMuhammadPetlai_1 = new JLabel("Saiful");
		lblMuhammadPetlai_1.setVisible(true);
		lblMuhammadPetlai_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMuhammadPetlai_1.setBounds(248, 504, 163, 35);
		contentPane.add(lblMuhammadPetlai_1);
		
		JLabel lblMuhammadPetlai_1_1 = new JLabel("Reply here..");
		lblMuhammadPetlai_1_1.setVisible(true);
		lblMuhammadPetlai_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMuhammadPetlai_1_1.setBounds(652, 394, 181, 35);
		contentPane.add(lblMuhammadPetlai_1_1);
		
		JButton btnDisconnect = new JButton("DISCONNECT");
		btnDisconnect.setVisible(true);
		btnDisconnect.setBackground(new Color(255, 0, 0));
		btnDisconnect.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDisconnect.setBounds(326, 587, 449, 43);
		contentPane.add(btnDisconnect);
		btnDisconnect.addActionListener(this);
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==tfInput)
			{
				userResponded = true;
				userInput = tfInput.getText();
				tfInput.setText("");
			}
			else if(e.getActionCommand().equals("DISCONNECT")){
				dispose();
				System.exit(0);
			}

		}
}