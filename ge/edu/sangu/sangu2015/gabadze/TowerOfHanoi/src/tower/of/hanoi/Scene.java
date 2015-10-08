package tower.of.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author user
 *
 */
public class Scene extends JFrame {

	private static final long serialVersionUID = -8180047554483543900L;
	ArrayList<Peg> Pegs = new ArrayList<>();
	ArrayList<Disk> Disks = new ArrayList<>();
	Graphics graphics;
	Timer timer;

	public void Setup() {

		int startHeight = 10;
		int startWidth = 140;
		int startX = 55;
		int startY = 435;

		for (int i = 0; i < 14; i++) {
			Disks.add(new Disk(Color.GRAY, startX, startY, startWidth, startHeight, i + 1));
			startWidth -= 10;
			startX += 5;
			startY -= 15;
		}

		startWidth = 150;
		startX = 50;
		startY = 450;
		startHeight = 15;

		for (int i = 0; i < 3; i++) {
			ArrayList<Disk> disks = i > 0 ? new ArrayList<>() : Disks;
			Pegs.add(new Peg(Color.BLACK, startX, startY, startWidth, startHeight, i + 1, disks));
			startX += 200;
		}
	}

	public Scene() {
		JFrame jFrame = new JFrame("Towers of hanoi ");
		jFrame.setTitle("Towers of hanoi");
		setForeground(Color.GRAY);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(400, 120);
		setSize(650, 500);
		setVisible(true);

		Setup();

	}

	/**
	 * ფუნქცია ხატავს ჯავა ფრეიმში ობიექტის instantiate შემდეგ
	 */

	public void paint(Graphics g) {
		graphics = g;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.white);

		Pegs.stream().forEach((t) -> {
			DrawPegs(g2d, t);
		});

		Disks.stream().forEach((o) -> {
			DrawDisk(g2d, o);
		});

		/*
		 * ვიძახებთ დროის მთვლელს რადგან ფრეიმზე დახატვის შემდეგ ავამუშაოთ Hanoi
		 */
		timer.setRepeats(false);
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Hanoi(Pegs.get(0).getDisks().size(), Pegs.get(0), Pegs.get(1), Pegs.get(2));
				// timer.stop();
			}
		});
		timer.start();
	}

	/*
	 * ფუნქცია ხატავს 2D სამაგრებს ჯავა ფრეიმში
	 */
	public static void DrawPegs(Graphics2D g2d, Peg t) {
		g2d.setColor(t.getColor());
		g2d.fillRect(t.getX(), t.getY(), t.getW(), t.getH());
	}

	/*
	 * ფუნქცია ხატავს 2D დისკოებს სამაგრზე ჯავა ფრეიმში
	 */
	public static void DrawDisk(Graphics2D g2d, Disk disk) {
		g2d.setColor(disk.getColor());
		g2d.fillRect(disk.getX(), disk.getY(), disk.getW(), disk.getH());
	}

	/*
	 * ფუნქცია აკეთებს სამაგრებზე დისკოების გადაადგილების ინიცირებას
	 * რეკურსიაულად
	 */
	public void Hanoi(int d, Peg a, Peg b, Peg c) {

		if (d == 1) {
			Move(a, c);
		} else {
			Hanoi(d - 1, a, c, b);
			Move(a, c);
			Hanoi(d - 1, b, a, c);
		}
	}

	/*
	 * ფუნქცია მოქმედებს ობიექტებზე(დისკოებზე), მათ გადატანაზე
	 * ობიექტებში(სამაგრებზე) და გადაადგილების შემდეგ იძახებს გადახატვის
	 * ფუნქციას (repaint)
	 */
	public void Move(Peg a, Peg b) {

		Disk d = null;

		for (Disk disk : a.getDisks()) {
			d = disk;
		}

		Pegs.get(Pegs.indexOf(b)).getDisks().add(d);
		Pegs.get(Pegs.indexOf(a)).getDisks().remove(d);

		rePaint(graphics, d, b);
	}

	/*
	 * გადახატვის ფუნქცია შლის დისკოს ძველი მდებარეობიდან(სამაგრიდან) და
	 * გადახატავს მას ახალ მდებარეობაზე(სამაგრზე)
	 */
	private void rePaint(Graphics g, Disk disk, Peg peg) {

		int PegId = peg.getId();
		int DiskId = disk.getId();
		int x = ((PegId - 1) * 340 + 50) + (DiskId * 5);
		int y = 450 - peg.getDisks().size() * 15;

		Graphics2D gui = (Graphics2D) g;
		gui.setColor(getBackground());
		gui.clearRect(disk.getX(), disk.getY(), disk.getH(), disk.getW());

		disk.setX(x);
		disk.setY(y);

		gui.setColor(getForeground());
		gui.fillRect(disk.getX(), disk.getY(), disk.getH(), disk.getW());

		/*
		 * ნაკადს ვაძინებთ რადგან გადახატვა ვიზუალურად ვიხილოთ, გადახატვა
		 * მიმდინარეობს სამაგრებზე დისკოების გადაადგილების ვისუალუიზაციისათვის
		 * 
		 */
		try {
			Thread.sleep(100l);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
