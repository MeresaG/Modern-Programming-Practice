package lesson6.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HomeFrame extends JFrame {

	String[] links;
	// context for CardLayout
	JPanel cards;
	JPanel buttonBar;

	// Main components
	JSplitPane splitPane, mainSplitPane;
	JList<ListItem> sideBarList;

	// config
	private final static int WIN_HEIGHT = 350;
	private final static int WIN_WIDTH = 600;
	final static String APP_TITLE = "Book Club";

	// Dispaly Panel and different cards
	JPanel cardPanel;
	JPanel loginPanel;
	JPanel viewTitlesPanel;
	JPanel addBookPanel;

	String[] sideBarItems = { "Login", "View Titles", "Add Book" };
	
	ListItem item1 = new ListItem(sideBarItems[0], true);
	ListItem item2 = new ListItem(sideBarItems[1], false);
	ListItem item3 = new ListItem(sideBarItems[2], false);

	JTextArea statusBar;

	// Overall container
	Container contentPane;

	// LogIn form details
	// Labels
	private String[] bookAttributes = { "Author First Name", "Author Last Name", "Book Title" };
	private JTextField[] bookFields = new JTextField[bookAttributes.length];

	private String[] row1Labels = { "Username", "Password" };
	private JTextField[] fields = new JTextField[row1Labels.length];

	private JButton loginButton;

	public HomeFrame() {
		super(APP_TITLE);
		
		// setside bar
		setSideBarList();

		// Instantiate the panels
		initializePanels();

		// crate the splitPane
		createSplitPane();

		// add to the content
		contentPane.add(mainSplitPane);
		setSize(WIN_WIDTH, WIN_HEIGHT);

	}

	// Initialize Panels
	private void initializePanels() {

		cardPanel = new JPanel(new CardLayout());
		contentPane = getContentPane();

		// Login form
		createLoginForm();

		// Title display from
		createTitlesDispaly();

		// add book Panel
		setAddBookPanel();

		// Set the card
		cardPanel.add(loginPanel, item1.getItemName());
		cardPanel.add(viewTitlesPanel, item2.getItemName());
		cardPanel.add(addBookPanel, item3.getItemName());


		// add the text area as well
		statusBar = new JTextArea(4, 30);

	}

	public void setAddBookPanel() {
		addBookPanel = new JPanel(new BorderLayout());
		JLabel panelTitle = new JLabel(" Add Book");
		panelTitle.setForeground(Util.LINK_AVAILABLE);
		addBookPanel.add(panelTitle, BorderLayout.NORTH);

		JPanel bookFormPanel = createAddBookForm();

		addBookPanel.add(bookFormPanel, BorderLayout.CENTER);

		// add add button
		JButton addBookBtn = new JButton("Add Book");
		addBookBtn.addActionListener(new addBookListiner());
		JPanel addBookBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addBookBtnPanel.add(addBookBtn);

		// add to book Panel at the bottom
		addBookPanel.add(addBookBtnPanel, BorderLayout.SOUTH);

	}

	private JPanel createAddBookForm() {

		JPanel centeredPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel bookFormPanel = new JPanel(new GridLayout(4, 1));

		// First Name
		bookFields[0] = new JTextField(10);
		JLabel firstNameLabel = new JLabel("First Name");
		bookFormPanel.add(firstNameLabel);
		bookFormPanel.add(bookFields[0]);

		bookFields[1] = new JTextField(10);
		JLabel lastNameLabel = new JLabel("Last Name");
		bookFormPanel.add(lastNameLabel);
		bookFormPanel.add(bookFields[1]);

		bookFields[2] = new JTextField(10);
		JLabel bookTitleLabel = new JLabel("Book Title");
		bookFormPanel.add(bookTitleLabel);
		bookFormPanel.add(bookFields[2]);

		return (JPanel) centeredPanel.add(bookFormPanel);
	}

	private void createTitlesDispaly() {

		viewTitlesPanel = new JPanel(new BorderLayout());
		JLabel panelTitle = new JLabel("View Title");
		panelTitle.setForeground(Util.LINK_AVAILABLE);
		viewTitlesPanel.add(panelTitle, BorderLayout.NORTH);

		JList<String> listOfBooks = new JList<String>(Data.bookTitles.toArray(new String[Data.bookTitles.size()]));
		// add the books

		viewTitlesPanel.add(listOfBooks, BorderLayout.CENTER);

	}

	private void createLoginForm() {

		loginPanel = new JPanel(new BorderLayout());

		JLabel panelTitle = new JLabel("Login ");
		panelTitle.setForeground(Util.LINK_AVAILABLE);

		// form with buttons
		JPanel formWithButton = new JPanel(new BorderLayout());
		JPanel onlyForm = new JPanel();
		for (int i = 0; i < row1Labels.length; i++) {
			onlyForm.add(getElementWithLabel(row1Labels[i], i));
		}

		// Label Part
		JButton submitButton = new JButton("Login");
		submitButton.addActionListener(new loginActionListiner());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(submitButton);

		// button and form
		formWithButton.add(onlyForm, BorderLayout.NORTH);
		formWithButton.add(buttonPanel, BorderLayout.CENTER);

		// title and form
		loginPanel.add(panelTitle, BorderLayout.NORTH);
		loginPanel.add(formWithButton, BorderLayout.CENTER);

	}

	public void createListinersToSideBar() {

		sideBarList.addListSelectionListener(event -> {

			String value = sideBarList.getSelectedValue().getItemName();
			boolean allowed = sideBarList.getSelectedValue().highlight();

			CardLayout cl = (CardLayout) (cardPanel.getLayout());

			if (!allowed) {
				value = item1.getItemName();
				sideBarList.setSelectedIndex(0);
			}
			cl.show(cardPanel, value);
		});

	}

	private JPanel getElementWithLabel(String labelName, int jtextFieldIndex) {

		// Label Part
		JLabel label = new JLabel(" " + labelName);
		if (labelName.equals("Password"))
			fields[jtextFieldIndex] = new JPasswordField(10);
		else
			fields[jtextFieldIndex] = new JTextField(10);

		// Name Label and form
		JPanel nameForm = new JPanel();
		nameForm.setLayout(new BorderLayout());
		nameForm.add(fields[jtextFieldIndex], BorderLayout.NORTH);
		nameForm.add(label, BorderLayout.CENTER);

		return nameForm;

	}

	// create splitPanes
	private void createSplitPane() {

		// Now create the splitPane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideBarList, cardPanel);
		splitPane.setDividerLocation(WIN_WIDTH - 500);

		// create the text area
		mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, statusBar);
		mainSplitPane.setDividerLocation(WIN_HEIGHT - 100);
	}

	@SuppressWarnings("serial")
	private void setSideBarList() {

		DefaultListModel<ListItem> model = new DefaultListModel<>();
		model.addElement(item1);
		model.addElement(item2);
		model.addElement(item3);

		sideBarList = new JList<ListItem>(model);

		sideBarList.setCellRenderer(new DefaultListCellRenderer() {

			@SuppressWarnings("rawtypes")
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof ListItem) {
					ListItem nextItem = (ListItem) value;
					setText(nextItem.getItemName());
					if (nextItem.highlight()) {
						setForeground(Util.LINK_AVAILABLE);
					} else {
						setForeground(Util.LINK_NOT_AVAILABLE);
					}
					if (isSelected) {
						setForeground(Color.BLACK);
						setBackground(new Color(236, 243, 245));
					}
				} else {
					setText("illegal item");
				}
				return c;
			}

		});

		// attach listners
		createListinersToSideBar();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateList(ListItem[] items) {
		DefaultListModel<ListItem> model = (DefaultListModel) sideBarList.getModel();
		int size = model.getSize();
		if (items != null) {
			java.util.List<Integer> indices = new ArrayList<>();
			for (ListItem item : items) {
				int index = model.indexOf(item);
				indices.add(index);
				ListItem next = (ListItem) model.get(index);
				next.setHighlight(true);
				setForeground(Util.LINK_AVAILABLE);
			}
			for (int i = 0; i < size; ++i) {
				if (!indices.contains(i)) {
					ListItem next = (ListItem) model.get(i);
					next.setHighlight(false);
					setForeground(Util.LINK_NOT_AVAILABLE);
				}
			}
		} else {
			for (int i = 0; i < size; ++i) {
				ListItem next = (ListItem) model.get(i);
				next.setHighlight(true);
				setForeground(Util.LINK_AVAILABLE);

			}
		}
	}

	private class loginActionListiner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String username = fields[0].getText().trim();
			String password = fields[1].getText().trim();

			List<User> logins = Data.logins;

			if (username.equals("") || password.equals("")) {
				statusBar.setText("Username and Password fields must be nonempty");
				statusBar.setForeground(Color.red);
			} else {

				User tryingUser = new User(username, password, Auth.BOTH);
				User systemUser = null;
				for (User user : logins) {

					if (tryingUser.equals(user)) {
						systemUser = user;
						break;
					}
				}
				if (systemUser == null) {
					statusBar.setText("Login failed!");
					statusBar.setForeground(Color.red);
				} else {

					if (systemUser.authorization.equals(Auth.SELLER)) {
						// update add book
						updateList(new ListItem[] { item3, item1 });
					} else if (systemUser.authorization.equals(Auth.MEMBER)) {
						updateList(new ListItem[] { item2, item1 });
					} else {
						updateList(new ListItem[] { item3, item2, item1 });
					}
					statusBar.setText("Login Successful!");
					statusBar.setForeground(Color.green);
					repaint();
				}
			}

		}
	}

	private class addBookListiner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String firstName = bookFields[0].getText().trim();
			String lastName = bookFields[1].getText().trim();
			String bookTitle = bookFields[2].getText().trim();

			if (firstName.isEmpty() || lastName.isEmpty() || bookTitle.isEmpty()) {
				statusBar.setText("All fields are required");
				statusBar.setForeground(Color.red);
			} else {
				Data.addBookTitle(bookTitle);
				viewTitlesPanel.add(new JList<String>(Data.bookTitles.toArray(new String[Data.bookTitles.size()])));
				System.out.println(Data.bookTitles.toString());
				statusBar.setText("The book  has been added to the collection!");
				statusBar.setForeground(Color.green);
			}

		}
	}

}
