import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame implements ActionListener {
    private JRadioButton birdButton;
    private JRadioButton catButton;
    private JRadioButton rabbitButton;
    private JRadioButton pigButton;
    private JRadioButton dogButton;  // New radio button for Dog
    private JLabel resultLabel;
    private JLabel imageLabel;  // Label to display the image

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");
        dogButton = new JRadioButton("Dog");  // Initialize Dog button

        // Group the radio buttons
        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);
        petGroup.add(dogButton);  // Add Dog to the group

        // Add action listeners
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);
        dogButton.addActionListener(this);  // Add action listener for Dog

        // Create a label to display the result
        resultLabel = new JLabel("Select a pet:");

        // Label for displaying images
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));

        // Add components to the frame
        add(resultLabel);
        add(birdButton);
        add(catButton);
        add(rabbitButton);
        add(pigButton);
        add(dogButton);  // Add Dog button to the frame
        add(imageLabel);  // Add image display label to the frame

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton selectedButton = (JRadioButton) e.getSource();
        resultLabel.setText("You selected: " + selectedButton.getText());
    
        // Update image based on the selected pet
        String petName = selectedButton.getText();
        ImageIcon petImage = null;
    
        switch (petName) {
            case "Bird":
                petImage = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\ASSIGNMENT\\bird.jpg");
                break;
            case "Cat":
                petImage = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\ASSIGNMENT\\cat.jpg");
                break;
            case "Dog":
                petImage = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\ASSIGNMENT\\dog.jpg");
                break;
            case "Pig":
                petImage = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\ASSIGNMENT\\pig.jpg");
                break;
            case "Rabbit":
                petImage = new ImageIcon("C:\\Users\\User\\OneDrive\\Desktop\\ASSIGNMENT\\rabbit.jpg");
                break;
        }
    
        // Resize the image
        if (petImage != null) {
            Image scaledImage = petImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetSelector::new);
    }
}
