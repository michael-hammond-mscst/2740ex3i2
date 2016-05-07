package mhammond2740ex3i2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class DriverExamForm extends JFrame {

	private JPanel contentPane;
	private JList responsesList;
	private DefaultListModel responsesListModel;
	private JLabel resultLabel;
	private JTextField inputAnswerTextField;
	private JButton prevButton;
	private JButton nextButton;
	private JLabel questNumLabel;
	private DriverExam exam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverExamForm frame = new DriverExamForm();
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
	public DriverExamForm() {
		setTitle("MHammond Ex3I: Driver Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setBackground(UIManager.getColor("Label.background"));
		list.setEnabled(false);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 32, 31, 200);
		contentPane.add(list);
		
		responsesList = new JList();
		responsesList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		responsesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_responsesList_valueChanged(arg0);
			}
		});
		responsesList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		responsesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		responsesList.setBounds(52, 32, 52, 200);
		contentPane.add(responsesList);
		
		JLabel lblResponses = new JLabel("Responses:");
		lblResponses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponses.setBounds(10, 0, 94, 26);
		contentPane.add(lblResponses);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResults.setBounds(133, 0, 59, 26);
		contentPane.add(lblResults);
		
		resultLabel = new JLabel("");
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		resultLabel.setBounds(133, 26, 177, 26);
		contentPane.add(resultLabel);
		
		JButton btnPass = new JButton("Pass");
		btnPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPass_actionPerformed(e);
			}
		});
		btnPass.setBounds(133, 59, 132, 23);
		contentPane.add(btnPass);
		
		JButton btnCorrect = new JButton("Correct");
		btnCorrect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCorrect_actionPerformed(e);
			}
		});
		btnCorrect.setBounds(133, 93, 132, 23);
		contentPane.add(btnCorrect);
		
		JButton btnIncorrect = new JButton("Incorrect");
		btnIncorrect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIncorrect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnIncorrect_actionPerformed(e);
			}
		});
		btnIncorrect.setBounds(133, 127, 132, 23);
		contentPane.add(btnIncorrect);
		
		JButton btnListInccorect = new JButton("List Inccorect");
		btnListInccorect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListInccorect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnListInccorect_actionPerformed(arg0);
			}
		});
		btnListInccorect.setBounds(133, 161, 132, 23);
		contentPane.add(btnListInccorect);
		
		questNumLabel = new JLabel("#0:");
		questNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questNumLabel.setBounds(10, 244, 31, 17);
		contentPane.add(questNumLabel);
		
		inputAnswerTextField = new JTextField();
		inputAnswerTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inputAnswerTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_inputAnswerTextField_focusGained(arg0);
			}
		});
		inputAnswerTextField.setBounds(52, 241, 52, 22);
		contentPane.add(inputAnswerTextField);
		inputAnswerTextField.setColumns(10);
		
		prevButton = new JButton("Prev");
		prevButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_prevButton_actionPerformed(e);
			}
		});
		prevButton.setEnabled(false);
		prevButton.setBounds(114, 209, 65, 23);
		contentPane.add(prevButton);
		
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_NextButton_actionPerformed(e);
			}
		});
		nextButton.setBounds(114, 240, 65, 23);
		contentPane.add(nextButton);
		
		DriverExamObjMapper mapper = new DriverExamObjMapper("DriverExam.txt");
		this.exam = mapper.getDriverExam();
		this.responsesListModel = exam.getAnswers();
		responsesList.setModel(this.responsesListModel);
	}
	
	protected void do_btnListInccorect_actionPerformed(ActionEvent arg0) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if (invalid >= 0) {
			resultLabel.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		} else {
			String wrong = new String();
			int [] missed = exam.questionsMissed();
			int i = 0;
			while (i < missed.length && missed[i] > 0) {
				int a = missed[i];
				i++;
				wrong += (Integer.toString(a) + "  ");
			}
			resultLabel.setText("Incorrect: # " + wrong);
		}						
	}	
	
	protected void do_btnCorrect_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if (invalid >= 0) {
			resultLabel.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else {
			resultLabel.setText("You got " + this.exam.totalCorrect() + " correct");
		}
	}
	
	protected void do_btnPass_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if (invalid >= 0) {
			resultLabel.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else {
			if (exam.passed()) resultLabel.setText("You passed");
			else resultLabel.setText("You failed");
		}
	}
	
	protected void do_btnIncorrect_actionPerformed(ActionEvent e) {
		this.exam.setResponses((DefaultListModel) responsesList.getModel());
		int invalid = this.exam.validate();
		if (invalid >= 0) {
			resultLabel.setText("Invalid response #" + Integer.toString(invalid + 1));
			responsesList.setSelectedIndex(invalid);
		}
		else {
			resultLabel.setText("You got " + this.exam.totalIncorrect() + " incorrect");
		}
	}
	
	protected void do_NextButton_actionPerformed(ActionEvent e) {
        this.responsesListModel.setElementAt(
                inputAnswerTextField.getText().toUpperCase(), 
                responsesList.getSelectedIndex());
        responsesList.setSelectedIndex(responsesList.getSelectedIndex() + 1);
        questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText(responsesList.getSelectedValue().toString());
        
        prevButton.setEnabled(true);
        if (responsesList.getSelectedIndex() == responsesListModel.getSize() - 1)
            nextButton.setEnabled(false);
        inputAnswerTextField.requestFocus();
	}
	
	protected void do_prevButton_actionPerformed(ActionEvent e) {
        this.responsesListModel.setElementAt(
                inputAnswerTextField.getText().toUpperCase(), 
                responsesList.getSelectedIndex());
        responsesList.setSelectedIndex(responsesList.getSelectedIndex() - 1);
        questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText(responsesList.getSelectedValue().toString());    

        nextButton.setEnabled(true);
        if (responsesList.getSelectedIndex() == 0) 
            prevButton.setEnabled(false);
        inputAnswerTextField.requestFocus();
	}
	
	protected void do_responsesList_valueChanged(ListSelectionEvent arg0) {
        questNumLabel.setText("#" + Integer.toString((responsesList.getSelectedIndex() + 1)));
        inputAnswerTextField.setText(responsesList.getSelectedValue().toString());    

        prevButton.setEnabled(true);
        nextButton.setEnabled(true);
        if (responsesList.getSelectedIndex() == responsesListModel.getSize() - 1)
            nextButton.setEnabled(false);
        if (responsesList.getSelectedIndex() == 0) 
            prevButton.setEnabled(false);
        inputAnswerTextField.requestFocus();  
	}
	
	protected void do_inputAnswerTextField_focusGained(FocusEvent arg0) {
		inputAnswerTextField.selectAll();
	}
}