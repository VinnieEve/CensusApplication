package PackageOne;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*Title: <Java / SWT GUI Project on Calculator>
 * Cppbuzz.com
 * 21/04/2021
 */

/*Third-party library used: SWT
 * https://projects.eclipse.org/projects/eclipse.platform.swt


/**
 * @author Vinnie Everton
 * @version 1.0
 * 
 *          An application that functions similar to a Census form.
 * 
 */

public class CensusApplication {

	/**
	 * This will be used to create the instance of classes of the SWT widgets.
	 * Following that, a constructor will be created.
	 */
	public class Census {
		private Display display;
		private Shell shell;
		private Group grpStart2;
		private Group grpStart;
		private Text txtMonthly;
		private Text txtExpens;
		private Text txtHouse;
		private Text txtName;
		private Text txtDoB;
		private Text txtNumber;
		private Button btnSubmit;
		private Button btnClear;
		private Label lbExpens;
		private Label LbHouse;
		private Label lbName;
		private Label lbDoB;
		private Label lbNumber;
		private Label lbMonthly;
		private Label lbBala;
		private Label lbDetails;
		private Label lbDoB2;
		private Label lbNumber2;
		private ScrolledComposite scrolledComposite;
		private Composite shellComposite;

		/**
		 * A constructor that will be used to create SWT widgets.
		 */
		public Census() {
			/*
			 * These widgets relate to the shell and the display of the GUI. Below that, you
			 * have handleEvent, which will handle what happens regarding the size of the
			 * scrolledComposite
			 */

			display = new Display();
			shell = new Shell(display);
			shell.setSize(700, 400);
			shell.setText("Census");
			shell.setLayout(new FillLayout());
			scrolledComposite = new ScrolledComposite(shell, SWT.H_SCROLL | SWT.V_SCROLL);
			scrolledComposite.setExpandVertical(true);
			scrolledComposite.setExpandHorizontal(true);
			shellComposite = new Composite(scrolledComposite, SWT.NONE);
			shellComposite.setLayout(new GridLayout(2, false));
			scrolledComposite.setContent(shellComposite);
			scrolledComposite.addListener(SWT.Resize, new Listener() {

				public void handleEvent(Event event) {
					scrolledComposite.setMinSize(shellComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				}
			});

			/*
			 * These are all the other widgets being used in the application. Widgets such
			 * as text field and buttons have been created here.
			 * 
			 */
			grpStart = new Group(shellComposite, SWT.NONE);
			grpStart.setText("Input your personal details");
			grpStart.setLayout(new GridLayout(2, false));
			GridData gd_grpStart = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
			gd_grpStart.heightHint = 213;
			gd_grpStart.widthHint = 374;
			grpStart.setLayoutData(gd_grpStart);

			grpStart2 = new Group(shellComposite, SWT.NONE);
			grpStart2.setText("Result");
			grpStart2.setLayout(new GridLayout(2, false));
			GridData gd_grpStart2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
			gd_grpStart2.heightHint = 200;
			gd_grpStart2.widthHint = 200;
			grpStart2.setLayoutData(gd_grpStart2);

			lbBala = new Label(grpStart2, SWT.NONE);
			lbBala.setText("Balance");
			lbDetails = new Label(grpStart2, SWT.None);
			lbDetails.setText("Your details");
			lbDoB2 = new Label(grpStart2, SWT.NONE);
			lbDoB2.setText("Date of birth");

			lbName = new Label(grpStart, SWT.NONE);
			lbName.setText("Name: ");
			txtName = new Text(grpStart, SWT.BORDER);
			txtName.setTextLimit(30);

			lbDoB = new Label(grpStart, SWT.NONE);
			lbDoB.setText("Date of birth: ");
			txtDoB = new Text(grpStart, SWT.BORDER);
			txtDoB.setTextLimit(30);

			lbNumber = new Label(grpStart, SWT.None);
			lbNumber.setText("Number: ");
			txtNumber = new Text(grpStart, SWT.BORDER);
			txtNumber.setTextLimit(30);
			lbNumber2 = new Label(grpStart2, SWT.None);
			lbNumber2.setText("Number");

			lbMonthly = new Label(grpStart, SWT.NONE);
			lbMonthly.setText("Monthly wage: ");
			txtMonthly = new Text(grpStart, SWT.BORDER);
			txtMonthly.setTextLimit(30);

			lbExpens = new Label(grpStart, SWT.NONE);
			lbExpens.setText("Monthly expenses: ");
			txtExpens = new Text(grpStart, SWT.BORDER);
			txtExpens.setTextLimit(30);
			LbHouse = new Label(grpStart, SWT.None);
			LbHouse.setText("People living in the household: ");
			txtHouse = new Text(grpStart, SWT.BORDER);
			txtHouse.setTextLimit(30);

			btnSubmit = new Button(grpStart, SWT.None);
			btnSubmit.setToolTipText("Submit");
			btnSubmit.setText("Submit your details");
			btnClear = new Button(grpStart, SWT.NONE);
			btnClear.setToolTipText("Schedule");
			btnClear.setText("Clear");

			/*
			 * These three MouseListeners will be used to create the MouseEvent The
			 * MouseEvent will then determine what kind of event will occour when the mouse
			 * is clicked. In this case, mouseDown is used for the three to make it so that
			 * when a mouse is clicked, the following event will occur.
			 * 
			 */
			btnSubmit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					System.out.println("button clicked");
					System.out.println(txtMonthly.getText());
					System.out.println(txtExpens.getText());
					/*
					 * This is what is used to calculate the income.
					 * 
					 */
					int calculation = Integer.parseInt(txtMonthly.getText())
							- Integer.parseInt(txtExpens.getText()) / Integer.parseInt(txtHouse.getText());
					/*
					 * This will set the text at the Labels in grpStart2
					 */
					lbDetails.setText(txtName.getText());
					lbDoB2.setText(txtDoB.getText());
					lbNumber2.setText(txtNumber.getText());
					lbBala.setText(Integer.toString(calculation));

				}
			});
			/*
			 * This will clear all the text when you press the button clear.
			 * 
			 */
			btnClear.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {

					txtName.setText("");
					txtDoB.setText("");
					txtNumber.setText("");
					lbBala.setText("");
					lbDetails.setText("");
					lbDoB2.setText("");
					txtMonthly.setText("");
					txtExpens.setText("");
					txtHouse.setText("");

				}
			});

			btnClear.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					System.out.println("button clicked");

				}
			});
			/*
			 * This relates to the opening and closing of the shell. It will stay in a state
			 * of "sleeping" until a event is received.
			 */
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			display.dispose();
		}
	}

	/**
	 * A constructor that a creates a Census object.
	 * 
	 */
	public CensusApplication() {
		new Census();
	}

	/**
	 * 
	 * @param args will call the new constructor
	 */
	public static void main(String[] args) {
		new CensusApplication();
	}

}
