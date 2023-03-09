package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardScreen implements ActionListener {
    JFrame frame = new DefaultFrame();
    JPanel mainPanel;
    JPanel complaintPanel;
    JPanel pastComplaintPanel;
    JPanel complaintStatPanel;
    JPanel fqaPanel;
    JPanel liveVidPanel;
    JPanel optPanel;
    JPanel selectedOptionPanel;
    JPanel headingPanel;
    JButton lodgeComplaintBtn;
    JButton viewPastComplaintBtn;
    JButton complaintStatusBtn;
    JButton fqaBtn;
    JButton liveVideoBtn;
    JLabel label;

    public DashboardScreen() {
        mainPanel = new JPanel(new BorderLayout());
        headingPanel = new JPanel(new GridLayout(1,1));
        optPanel = new JPanel(new GridLayout(5,1));
        selectedOptionPanel = new JPanel(new CardLayout());

        complaintPanel = new JPanel();
        complaintPanel.add(new JLabel("Lodge a complaint"));

        pastComplaintPanel = new JPanel();
        pastComplaintPanel.add(new JLabel("View past complaints"));

        complaintStatPanel = new JPanel();
        complaintStatPanel.add(new JLabel("Check complaint status"));

        fqaPanel = new JPanel();
        fqaPanel.add(new JLabel("Frequently Asked Questions"));

        liveVidPanel = new JPanel();
        liveVidPanel.add(new JLabel("Start a live video call"));

        lodgeComplaintBtn = new JButton("Lodge a Complaint");
        lodgeComplaintBtn.addActionListener(this);

        viewPastComplaintBtn = new JButton("View Past Complaints");
        viewPastComplaintBtn.addActionListener(this);

        complaintStatusBtn = new JButton("Check Complaint Status");
        complaintStatusBtn.addActionListener(this);

        fqaBtn = new JButton("FAQs");
        fqaBtn.addActionListener(this);

        liveVideoBtn = new JButton("Start Live Video Call");
        liveVideoBtn.addActionListener(this);
        

        optPanel.add(lodgeComplaintBtn);
        optPanel.add(viewPastComplaintBtn);
        optPanel.add(complaintStatusBtn);
        optPanel.add(fqaBtn);
        optPanel.add(liveVideoBtn);

        selectedOptionPanel.add(complaintPanel, "complaint");
        selectedOptionPanel.add(pastComplaintPanel, "pastcomplaint");
        selectedOptionPanel.add(complaintStatPanel, "complaintstatus");
        selectedOptionPanel.add(fqaPanel, "fqa");
        selectedOptionPanel.add(liveVidPanel, "livevideo");

        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainPanel.add(optPanel, BorderLayout.WEST);
        mainPanel.add(selectedOptionPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout)(selectedOptionPanel.getLayout());
        if (e.getSource() == lodgeComplaintBtn) {
            cl.show(selectedOptionPanel, "complaint");
        } else if (e.getSource() == viewPastComplaintBtn) {
            cl.show(selectedOptionPanel, "pastcomplaint");
        } else if (e.getSource() == complaintStatusBtn) {
            cl.show(selectedOptionPanel, "complaintstatus");
        } else if (e.getSource() == fqaBtn) {
            cl.show(selectedOptionPanel, "fqa");
        } else if (e.getSource() == liveVideoBtn) {
            cl.show(selectedOptionPanel, "livevideo");
        }
    }
}

